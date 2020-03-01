package com.example.timesheet.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidationUtil {

    @Autowired
    private LocaleMessage message;

//    @Value("${app.validation.basename}")
    private String basename = "app.validation"; // "app.validation"


    public List<String> getErrorMessages(BindingResult bindingResult) {
        List<String> result = new ArrayList<String>();
        for(FieldError error : bindingResult.getFieldErrors()) {
            String fieldName = error.getField();
            String localeFieldName = getValidationField(fieldName);
            String localeMessage = getValidationMessage(fieldName, error.getDefaultMessage());
            result.add(localeFieldName + localeMessage);
        }
        return result;
    }

    public String getValidationField(String fieldName) {
        return message.get(basename + "." + fieldName);
    }

    public String getValidationMessage(String fieldName, String msg) {
        msg = msg.replace(" ", "-");
        return message.get(basename + "." + fieldName + "." + msg);
    }
}

