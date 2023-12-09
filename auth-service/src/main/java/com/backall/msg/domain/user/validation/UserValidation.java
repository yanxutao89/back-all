package com.backall.msg.domain.user.validation;

import com.backall.msg.application.dto.AuthUserDTO;
import com.backall.msg.domain.user.dao.AuthUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.util.function.Predicate;

public class UserValidation<T extends Annotation> implements ConstraintValidator<T, AuthUserDTO> {

    @Autowired
    protected AuthUserRepository authUserRepository;

    protected Predicate<AuthUserDTO> predicate = value -> true;

    @Override
    public void initialize(T constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AuthUserDTO value, ConstraintValidatorContext context) {
        return authUserRepository == null || predicate.test(value);
    }

    public static class NotConflictUserValidator extends UserValidation<NotConflictUser> {

        @Override
        public void initialize(NotConflictUser constraintAnnotation) {
            predicate = value -> authUserRepository.findByUsername(value.getUsername()) == null;
        }

    }

}
