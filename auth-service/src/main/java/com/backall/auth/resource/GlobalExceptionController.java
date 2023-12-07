package com.backall.auth.resource;

import com.backall.auth.infrastructure.utility.MessageUtil;
import com.backall.auth.infrastructure.utility.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<ObjectError> errors = bindException.getAllErrors();
        String msg = errors.stream().map(this::toMsg).collect(Collectors.joining(";"));
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return Result.failure(msg);
    }

    private String toMsg(ObjectError error) {
        String key = error.getObjectName();
        if (error instanceof FieldError fieldError) {
            key = fieldError.getField();
        }
        Object[] arguments = error.getArguments();
        if (arguments == null) {
            arguments = new Object[]{};
        }
        Object[] actual = Arrays.stream(Arrays.copyOfRange(arguments, 1, arguments.length)).sorted().toArray();
        return key + ":" + messageUtil.getMessage(error.getDefaultMessage(), actual);
    }

}
