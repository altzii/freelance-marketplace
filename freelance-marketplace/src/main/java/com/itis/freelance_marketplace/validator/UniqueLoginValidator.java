package com.itis.freelance_marketplace.validator;

import com.itis.freelance_marketplace.entity.User;
import com.itis.freelance_marketplace.service.UserService;
import com.itis.freelance_marketplace.validator.annotation.UniqueLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by alt on 06/05/2016.
 */
@Component
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {
    @Autowired
    UserService userService;

    @Override
    public void initialize(UniqueLogin uniqueLogin) {
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        if (login == null) {
            return false;
        }

        User user = userService.findByLogin(login);
        return user == null;
    }
}