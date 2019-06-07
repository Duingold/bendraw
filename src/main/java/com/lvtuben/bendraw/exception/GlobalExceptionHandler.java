package com.lvtuben.bendraw.exception;

import com.lvtuben.bendraw.response.BaseResponse;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @Description:异常处理器
 * @author: Bryce
 * @date: 2019/6/3
 * @version: 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public BaseResponse handleException(Exception e){
        //参数校验异常
        StringBuilder builder = new StringBuilder();
        if (e instanceof BindException){
            BindException ex = (BindException)e;
            for (ObjectError o : ex.getAllErrors()) {
                builder.append(o.getDefaultMessage()).append("!");

            }
            return new BaseResponse(Boolean.FALSE,"-1",builder.toString());
        }
        if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException)e;
            List<ObjectError> errors = exception.getBindingResult().getAllErrors();
            for (ObjectError error : errors) {
                builder.append(error.getDefaultMessage()).append("!");
            }
            return new BaseResponse(Boolean.FALSE,"-1",builder.toString());
        }
        BaseResponse response=new BaseResponse();
        response.setMsg(StringUtils.isEmpty(e.getMessage())?"服务器异常":e.getMessage());
        return response;
    }
}
