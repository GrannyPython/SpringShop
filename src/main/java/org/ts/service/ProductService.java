package org.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ts.model.*;
import org.ts.repository.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.jar.Attributes;

@Service
/**
 * Service layer class
 */
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    /**
     * Boilerplate save method
     *
     * @param product
     * @return Product entity
     */
    @Transactional
    public Product save(Product product) {
        return productRepository.save(productRepository.save(product));
    }

    /**
     * find product by
     *
     * @param name
     * @return Product entity
     */
    @Transactional
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }


    /**
     * Create Order and OD from cart entities
     *
     * @param userID
     * @param deliveryMetod
     * @param paymentMethod
     */
    @Transactional
    public void buyProducts(Long userID, String deliveryMetod, String paymentMethod) {
        Customer customer = (Customer) userRepository.findById(userID);
        //initialization of Order
        Order order = new Order();
        order.setPaymentStatus("paid");
        order.setPaymentMethod(paymentMethod);
        order.setDeliveryMethod(deliveryMetod);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date date = new java.util.Date();
        String result = dateFormat.format(date).toString();
        order.setDate(result);
        order.setCustomer(customer);

        orderRepository.save(order);

        List<Cart> list = cartRepository.findAllByCustomerId(customer.getId());
        Warehouse warehouse;
        customer.getSc().clear();

        //transfer info from Cart-form to OrderForm
        for (Cart cart : list) {
            warehouse = cart.getWarehouse();
            warehouse.setAmount(warehouse.getAmount() - cart.getAmount());
            warehouseRepository.save(warehouse);
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setProduct(cart.getWarehouse().getProduct());
            orderDetails.setAmount(cart.getAmount());
            orderDetails.setSeller(cart.getWarehouse().getSeller());
            orderDetails.setOrder(order);
            orderDetails.setDeliveryStatus("not processed");
            orderDetails.setOrder(order);
            orderDetailsRepository.save(orderDetails);
            order.getOrder_details().add(orderDetails);
            warehouse.setCart(null);
        }
        for (Cart cart : list) {
            cartRepository.delete(cart);
        }
        userRepository.save(customer);
        order.setCustomer(customer);
        orderRepository.save(order);
    }

    /**
     * Get stat data about the most popular products
     * @deprecated
     * @return list of Products
     */
    @Transactional
    public List<Product> getPopularProducts() {
        List<OrderDetails> list = orderDetailsRepository.findAll();
        LinkedHashMap<Long, Integer> map = new LinkedHashMap<Long, Integer>();
        for (OrderDetails orderDetails : list) {
            Long id = orderDetails.getProduct().getProductID();
            Integer amount = orderDetails.getAmount();
            if (map.containsKey(id)) {
                Integer value = map.get(id);
                if (value == null) {
                    value = amount;
                } else {
                    value += amount;
                }
                map.put(id, value);
            } else {
                map.put(id, amount);
            }
        }
        List<Product> productList = new LinkedList<>();
        Map a = sortByValue(map);

        Iterator it = a.entrySet().iterator();
        int i = 0;
        int x;
        if (a.size() < 10) {
            x = a.size() - 1;
        } else {
            x = 10;
        }
        while (it.hasNext()) {
            if (i <= x) {
                Map.Entry pair = (Map.Entry) it.next();
                Long b = (Long) pair.getKey();
                Product pr = productRepository.findOne(b);
                productList.add(pr);
            }
        }
        return productList;
    }

//standard comparator
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {

            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return (-1) * (e1.getValue()).compareTo(e2.getValue());
            }
        });
        Map<K, V> result = new LinkedHashMap();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }


}
