package com.itis.freelance_marketplace.validator;

import com.itis.freelance_marketplace.entity.User;
import com.itis.freelance_marketplace.service.UserService;
import com.itis.freelance_marketplace.validator.annotation.UniqueEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by alt on 06/05/2016.
 */
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    UserService userService;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email == null) {
            return false;
        }

        User user = userService.findByEmail(email);
        return user == null;
    }
}
