package com.backall.msg.infrastructure.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Locale;

@Service
public class MessageUtil {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String code) {
        return getMessage(code, null);
    }

    public String getMessage(String code, Object... args) {
        return getMessage(code, args, Locale.getDefault());
    }

    public String getMessage(String code, Object[] args, Locale locale) {
        Assert.notNull(code, "Parameter 'code' must not be null");
        return messageSource.getMessage(code, args, locale);
    }

}
