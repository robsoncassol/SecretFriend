package com.cassol.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestErrorHandler {


    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorsList processErrors(MethodArgumentNotValidException ex){
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrorList = result.getFieldErrors();

        ErrorsList errorsList = new ErrorsList();
        for(FieldError fieldError: fieldErrorList){
            Locale currentLocale = LocaleContextHolder.getLocale();
            String errorMessage = messageSource.getMessage(fieldError, currentLocale);

            errorsList.addFieldError(fieldError.getField(), errorMessage);
        }

        return errorsList;
    }
}
