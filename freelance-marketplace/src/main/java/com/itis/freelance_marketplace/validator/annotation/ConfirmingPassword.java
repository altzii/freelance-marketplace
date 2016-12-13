package com.itis.freelance_marketplace.validator.annotation;


import com.itis.freelance_marketplace.validator.ConfirmingPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Alexander on 06/05/2016.
 */
@Documented
@Constraint(validatedBy = ConfirmingPasswordValidator.class)
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmingPassword {
    public static final String MESSAGE = "Введенные пароли не совпадают";
    String password();
    String confirmPassword();
    String message() default MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
