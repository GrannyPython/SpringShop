package org.ts.validator;

import org.ts.model.Customer;
import org.ts.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.ts.service.UserService;

@Component
/**
 * User Validator realisation
 */
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    /**
     * validate form
     * @param o
     * @param errors
     */
    @Override
    public void validate(Object o, Errors errors) {
        Customer user = (Customer) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "house", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "flat", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postalPin", "NotEmpty");

        if (user.getName().length() > 255) {
            errors.rejectValue("name", "Size.userForm.name");
        }

        User user1 = userService.findByEmail(user.getEmail());
        if (user1 != null) {
            errors.rejectValue("name", "Duplicate.userForm.name");
        }


        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
