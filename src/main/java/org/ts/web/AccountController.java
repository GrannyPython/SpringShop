package org.ts.web;

import JavaMail.TestMail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.LoggerListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.ts.model.Customer;
import org.ts.model.Seller;
import org.ts.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ts.service.UserService;
import javax.servlet.http.HttpSession;
import java.util.Collection;


@Controller

public class AccountController {
    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    Logger logger = Logger.getLogger(AccountController.class);

    /**
     *
     * @return account page
     */
    @RequestMapping(value = {"/account/update"}, method = RequestMethod.GET)
    protected String doGet1() {
        logger.trace("accountUpdate method, get request");
        return "Account/AccountUpdate";
    }


    /**
     *
     * @param userForm data from previous page
     * @param session
     * @return redirect to account page
     */
    @RequestMapping(value = {"/account/update"}, method = RequestMethod.POST)
    protected String UpdatePost(@ModelAttribute("acForm") User userForm, HttpSession session) {
        logger.trace("accountUpdate method, Post request");
        User oldUser= (User) session.getAttribute("user");

        if (oldUser.getRole()==1) {
            Seller newUser = (Seller) oldUser;
            newUser.setName(userForm.getName());
            newUser.setSurname(userForm.getSurname());
            newUser.setPhone(userForm.getPhone());
            userService.save(newUser);
            session.setAttribute("user", newUser);

        }
        if (oldUser.getRole()==2){
            Customer newUser = (Customer) userForm;
            newUser.setName(userForm.getName());
            newUser.setSurname(userForm.getSurname());
            newUser.setPhone(userForm.getPhone());
            newUser.setCity(((Customer) userForm).getCity());
            newUser.setCountry(((Customer) userForm).getCountry());
            newUser.setPostalPin(((Customer) userForm).getPostalPin());
            newUser.setStreet(((Customer) userForm).getStreet());
            newUser.setHouse(((Customer) userForm).getHouse());
            newUser.setFlatNumber(((Customer) userForm).getFlat());
            userService.save(newUser);
            session.setAttribute("user", newUser);
        }

        return "Account/Account";
    }

    /**
     *
     * @return redirect to account page
     */
    @RequestMapping(value = {"/account"}, method = RequestMethod.GET)
    protected String doGet2()
    {
        Collection<? extends GrantedAuthority> role = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        logger.trace("account method, get request");
        return "Account/Account";
    }

    /**
     *
     * @return redirect to account page
     */
    @RequestMapping(value = {"/account"}, method = RequestMethod.POST)
    protected String doPost2() {
        logger.trace("account method, Post request");
        return "Account/Account";
    }

    /**
     *
     * @param session
     * @param newPassword
     * @return account page
     * */
    @RequestMapping(value = {"/account/changePassword"}, method = RequestMethod.POST)
    protected String doPost(HttpSession session, @RequestParam("newPassword") String newPassword) {
        logger.trace("changePassword method, post request");
        User user = (User) session.getAttribute("user");
        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        userService.save(user);
        TestMail.newPassword(user.getEmail(), newPassword);
        return "Account/Account";
    }

    /**
     *
     * @return changePassword page
     */
    @RequestMapping(value = {"account/changePassword"}, method = RequestMethod.GET)
    protected String doGet() {
        logger.trace("changePassword method, get request");
        return "SellerInterface/changePassword";
    }
}