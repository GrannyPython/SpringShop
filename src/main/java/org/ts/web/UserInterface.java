package org.ts.web;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ts.model.*;
import org.ts.repository.OrderRepository;
import org.ts.service.CartService;
import org.ts.service.CategoryService;
import org.ts.service.ProductService;
import org.ts.service.WarehouseService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;


@Controller
public class UserInterface extends HttpServlet {
    @Autowired
    CategoryService categoryService;
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderRepository orderRepository;

    final static Logger logger = Logger.getLogger(UserInterface.class);

    @RequestMapping(value = {"/userOrders"}, method = RequestMethod.GET)
    protected String doGet(HttpSession session) {
        logger.trace("userOrders method, get request ");
        Customer customer = (Customer) session.getAttribute("user");
        List<Order> o = (List<Order>) orderRepository.findAllOrdersByCustomerID(customer.getId());
        session.setAttribute("orderList", o);
        return "UserInterface/userOrders";
    }


    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    protected String doGet(HttpSession session, Model model) {
        logger.trace("cartController, getRequest");
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List scList = cartService.findAllByCustomerId(user.getId());
            model.addAttribute("scList", scList);
        } else {
            model.addAttribute("scList", session.getAttribute("scList"));
        }
        return "UserInterface/shoppingCart";
    }

    @RequestMapping(value = {"/cart"}, method = RequestMethod.POST)
    protected String doPost(HttpSession session,
                            @RequestParam(value = "paymentMethod", required = false) String pM,
                            @RequestParam(value = "deliveryMethod", required = false) String dM) {
        logger.trace("cart method, post request");
        Customer customer = (Customer) session.getAttribute("user");
        if (customer != null) {

            productService.buyProducts(customer.getId(), dM, pM);

            return "redirect:/";
        } else {
            return "/login";
        }
    }



    @RequestMapping(value = {"/403"}, method = RequestMethod.GET)
    protected String addCategoryGet() {
        return "403";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    protected String doGet(HttpSession session, Model model,
                           @RequestParam(value = "product", required = false) String productName,
                           @RequestParam(value = "by",  required = false) String mode,
                           @RequestParam(value = "category", required = false) String categoryName,
                           @RequestParam(value = "page", defaultValue = "1", required = false) Integer pageNumber) {
        logger.trace("index method, get request");


        if(categoryName!=null)
            session.setAttribute("category", categoryName);
        else{
            String sessionCategoryName = (String) session.getAttribute("category");
            if (sessionCategoryName!=null) {
                categoryName = sessionCategoryName;
            }
        }
        List<Category> categoryList = categoryService.findAll();
        User user = (User) session.getAttribute("user");
        Page<Warehouse> page = null;

        if (pageNumber==null)
            pageNumber=1;

        if (productName != null & mode != null) {
            session.removeAttribute("category");
            logger.info("Product search, Search form data="+productName+ "; mode=" +mode +";");
            page = warehouseService.getProductsByModeAndByProductName(mode, productName, pageNumber);
        }

        if (categoryName != null & productName == null & mode == null) {
            logger.info("Find by category="+categoryName);
            page = warehouseService.findByCategory(categoryName, pageNumber);
        }


        if (productName == null & mode == null & categoryName == null) {
            logger.info("First visit main page");
            page = warehouseService.findAll(pageNumber);
        }
        List<Warehouse> list = page.getContent();

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());
        int last = page.getTotalPages();

        logger.info("currentPage="+current+"; search mode="+mode+"; category="+categoryName+";" );

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("lastIndex", last);
        model.addAttribute("firstIndex", 1);
        model.addAttribute("user", user);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("productList", list);
        model.addAttribute("by", mode);
        model.addAttribute("category", categoryName);
        return "index";
    }

}
