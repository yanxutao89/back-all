package com.springall.auth.controller;

import com.springall.auth.util.MessageUtil;
import com.springall.auth.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/12/19 14:39
 */
@RestControllerAdvice
public class GlobalExceptionController {

    @Autowired
    private MessageUtil messageUtil;

    @ExceptionHandler(BindException.class)
    public Result handleBindException(HttpServletRequest request, HttpServletResponse response, BindException bindException) {
        List<FieldError> fieldErrors = bindException.getFieldErrors();
        StringBuilder msg = new StringBuilder();
        fieldErrors.stream().forEach(fieldError -> {
            Object[] arguments = fieldError.getArguments();
            Object[] actual = Arrays.stream(Arrays.copyOfRange(arguments, 1, arguments.length)).sorted().toArray();
            msg.append(fieldError.getField())
                    .append(" ")
                    .append(messageUtil.getMessage(fieldError.getDefaultMessage(), actual));
        });
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return Result.failure(msg.toString());
    }

}
