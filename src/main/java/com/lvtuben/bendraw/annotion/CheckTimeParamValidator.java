package com.lvtuben.bendraw.annotion;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description:
 * @author: Bryce
 * @date: 2019/6/4
 * @version: 1.0
 */
public class CheckTimeParamValidator implements ConstraintValidator<CheckTimeParam,Object> {
    private String startTime;
    @Override
    public void initialize(CheckTimeParam constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return false;
    }
}
