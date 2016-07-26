package org.ts.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.ts.model.Cart;
import org.ts.model.Customer;
import org.ts.model.Warehouse;
import org.ts.service.CartService;
import org.ts.service.WarehouseService;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = {"/buyProduct"})
public class BuyProductController {
    @Autowired
    WarehouseService warehouseService;

    @Autowired
    CartService cartService;

    Logger logger = Logger.getLogger(BuyProductController.class);

    @RequestMapping(value = {"/{warehouseID}"}, method = RequestMethod.GET)
    protected String doGet(HttpSession session, Model model,
                           @PathVariable("warehouseID") Long warehouseID) {
        logger.trace("buyProduct method, get request");
        Warehouse warehouse = warehouseService.findByID(warehouseID);
        model.addAttribute("product", warehouse);
        session.setAttribute("product", warehouse);
        return "product";
    }


    @RequestMapping(value = {"/buy"}, method = RequestMethod.POST)
    protected String doPost(HttpSession session, @RequestParam("amount") int amount) {
        logger.trace("buyProduct method, post request");
        Warehouse warehouse = (Warehouse) session.getAttribute("product");
        Customer customer =  (Customer) session.getAttribute("user");

        Cart shoppingCart = new Cart();
        shoppingCart.setAmount(amount);
        shoppingCart.setCustomer(customer);
        shoppingCart.setWarehouse(warehouse);

            if (customer!=null) {
                cartService.addProductToCart(shoppingCart);
            }
            else{
                List<Cart> scList = (List<Cart>) session.getAttribute("scList");
                if (scList==null) {
                    scList = new LinkedList<>();
                }
                boolean found = false;
                for (Cart cart : scList) {
                    if(shoppingCart.getWarehouse().getId()==cart.getWarehouse().getId()) {
                        cart.setAmount(cart.getAmount()+shoppingCart.getAmount());
                        found = true;
                        break;
                    }
                }
                if(!found)
                    scList.add(shoppingCart);

                session.setAttribute("scList",scList);
            }
            return "redirect:/";
        }


}