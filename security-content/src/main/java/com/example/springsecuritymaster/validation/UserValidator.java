package com.example.springsecuritymaster.validation;

import com.example.springsecuritymaster.ds.RegisterUser;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterUser.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterUser user = (RegisterUser) target;
        if (!user.getPassword().equals(user.getPassword())){
            errors.rejectValue("password",null,"Password and RepeatedPassword must be the same.");
        }
    }
}
