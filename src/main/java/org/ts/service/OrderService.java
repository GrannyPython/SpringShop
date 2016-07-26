package org.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ts.model.Cart;
import org.ts.model.Order;
import org.ts.model.OrderDetails;
import org.ts.repository.CartRepository;
import org.ts.repository.OrderDetailsRepository;
import org.ts.repository.OrderRepository;

import java.util.List;

@Service
/**
 * Service layer class
 */
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    /**
     * Find all Orders entities by
     * @param id sellerID and
     * @param delivStatus deliveryStatus variable
     * @return list of orderDetails
     */
    @Transactional
    public List<OrderDetails> getAllOrdersBySellerIDAndDivStatus(Long id, String delivStatus){
        return orderDetailsRepository.getAllOrdersBySellerIDAndByDeliveryStatus(id, delivStatus);
    }

    /**
     * Find all Orders entities by
     * @param id Customer ID
     * @return list of OD
     */
    @Transactional
    public List<Order> getAllOrdersByCustomerID(Long id) {
        return orderRepository.findAllOrdersByCustomerID(id);
    }

    /**
     * Boilerplate save nethod
     * @param order Order entity
     * @return Order Entity with ID
     */
    @Transactional
    public Order save(Order order){
        return orderRepository.save(order);
    }

}
