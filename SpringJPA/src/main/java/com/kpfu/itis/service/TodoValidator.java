package com.kpfu.itis.service;

import com.kpfu.itis.model.ToDo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TodoValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return ToDo.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ToDo todo = (ToDo)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title","title.empty","title cannot be empty");
        if(todo.getTitle().length() < 4 || todo.getTitle().length() > 40) {
            errors.rejectValue("title","title length should be in the range of up to 35");
        }
    }
}
