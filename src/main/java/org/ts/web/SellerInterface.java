package org.ts.web;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.ts.model.*;
import org.ts.service.OrderDetailsService;
import org.ts.service.OrderService;
import org.ts.service.ProductService;
import javax.servlet.http.HttpSession;
import java.util.List;



@Controller
public class SellerInterface{
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailsService orderDetailsService;
    @Autowired
    ProductService productService;

    Logger logger = Logger.getLogger(SellerInterface.class);

    @RequestMapping(value = {"/userOrders"}, method = RequestMethod.POST)
    protected String doGet(HttpSession session) {
        logger.trace("userOrders method, post request");

        Customer customer = (Customer) session.getAttribute("user");
        List<Order> o = (List<Order>) orderService.getAllOrdersByCustomerID(customer.getId());
        session.setAttribute("orderList", o);

        return "UserInterface/userOrders";
    }

    @RequestMapping(value = {"/sellerOrders"}, method = RequestMethod.GET)
    protected String doGet(HttpSession session, Model model,
                            @RequestParam(value = "ID", required = false) Long orderDetailsID,
                            @RequestParam(value = "ds", required = false) String delivStatus){
        logger.trace("sellerOrders method, get request");

        Seller seller = (Seller) session.getAttribute("user");
        if (orderDetailsID!=null) {
            OrderDetails od = (OrderDetails)  orderDetailsService.findById(orderDetailsID);
            od.setDeliveryStatus(delivStatus);
            orderDetailsService.saveOrUpdate(od);

            List<OrderDetails> list =  (List<OrderDetails>) session.getAttribute("orderList");
            for (OrderDetails details : list) {
                if(details.getId()==orderDetailsID){
                    details.setDeliveryStatus(delivStatus);
                    break;
                }
            }
            session.setAttribute("orderList", list);
        }

        else {
            List list;
            if (delivStatus!=null) {
                list = orderService.getAllOrdersBySellerIDAndDivStatus(seller.getId(), delivStatus);
            }
            else {
                list = orderService.getAllOrdersBySellerIDAndDivStatus(seller.getId(), "not processed");
            }
            session.setAttribute("orderList", list);
        }
        model.addAttribute("ds", delivStatus);
        return "SellerInterface/sellerOrders";
    }

    @RequestMapping(value = {"/showStat"}, method = RequestMethod.GET)
    protected String showStat(Model model) {
        logger.trace("showStat method, get request");
        List<Product> popular = productService.getPopularProducts();
        model.addAttribute("popular", popular);
        return "SellerInterface/showStats";
    }
}
