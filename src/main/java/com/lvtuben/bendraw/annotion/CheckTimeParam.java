package com.lvtuben.bendraw.annotion;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description:
 * @author: Bryce
 * @date: 2019/6/4
 * @version: 1.0
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(CheckTimeParam.List.class)
@Documented
@Constraint(validatedBy = CheckTimeParamValidator.class)
public @interface CheckTimeParam {
    String startTime() default "from";

    String endTime() default "to";


    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        CheckTimeParam[] value();
    }
}
