package org.ts.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.ts.model.Cart;
import org.ts.model.Customer;
import org.ts.model.User;
import org.ts.service.CartService;
import org.ts.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;

    Logger logger = Logger.getLogger(UserController.class);

    /*
  * This method will serve as default GET handler.
  *
  */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout) {
        logger.trace("login method, get request");


        if (error != null)
            model.addAttribute("error", "Your username or password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }


    @RequestMapping(value = {"/logSuccess"}, method = RequestMethod.GET)
    public String loginSuccess(HttpSession session) {
        logger.trace("logSuccess method, get request");
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByEmail(email);
        session.setAttribute("user", user);


        List<Cart> scList = (List<Cart>) session.getAttribute("scList");
        if (scList != null && user instanceof Customer) {
            for (Cart cart : scList) {
                cart.setCustomer((Customer) user);
                cartService.save(cart);
            }
        }
        return "redirect:/";
    }


}
