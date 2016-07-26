package org.ts.web;

import JavaMail.TestMail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.ts.model.Customer;
import org.ts.model.Seller;
import org.ts.model.User;
import org.ts.service.UserService;
import org.ts.validator.UserValidator;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    Logger logger = Logger.getLogger(RegistrationController.class);

    private String CONFIRM_CODE;
    private User USER_INFO;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        logger.trace("registration method, get request");
        model.addAttribute("userForm", new Customer());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") @Validated Customer userForm, BindingResult bindingResult, Model model) {
        logger.trace("registration method, post request");

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("userForm", userForm);
            return "registration";
        }

        CONFIRM_CODE = String.valueOf(TestMail.generateAndSendEmail(userForm.getEmail()));
        logger.info("Confir code is "+CONFIRM_CODE);

        if(userForm.getRole()==1) {
            Seller seller = new Seller(userForm.getName(), userForm.getSurname(), userForm.getPhone(), userForm.getEmail(),
                    userForm.getPassword(), userForm.getRole(), 0);
            USER_INFO=seller;
        }
        else{
            USER_INFO=userForm;
        }
        USER_INFO.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
        return "registrationConfirm";
    }

    @RequestMapping(value = "registrationConfirm", method = RequestMethod.POST)
    public String emailModule(Model model,  @RequestParam("emailcode") String emailcode){
        logger.trace("registrationConfirm method, post request");
        if (CONFIRM_CODE.equals(emailcode)) {
            userService.save(USER_INFO);
            return "index";
        }
        model.addAttribute("error", "Your code is wrong");
        return "registrationConfirm";
    }
}
