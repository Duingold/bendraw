package com.lvtuben.bendraw.annotion;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 * @Description:
 * @author: Bryce
 * @date: 2019/6/4
 * @version: 1.0
 */
public class CheckTimeParamValidator implements ConstraintValidator<CheckTimeParam, Object> {
    private String startTime;
    private String endTime;

    @Override
    public void initialize(CheckTimeParam constraintAnnotation) {
        this.startTime = constraintAnnotation.startTime();
        this.endTime = constraintAnnotation.endTime();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        BeanWrapper beanwrapper = new BeanWrapperImpl(value);
        Object start = beanwrapper.getPropertyValue(startTime);
        Object end = beanwrapper.getPropertyValue(endTime);
        if (null == start || null == end) {
            return true;
        }
        int result = ((Date) end).compareTo((Date) start);
        if (result >= 0) {
            return true;
        }
        return false;
    }
}