package com.deep.web.http.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 
 * 修改人：fb
 * 修改内容： 全局异常拦截新增验证参数处理和所有异常拦截
 * 修改日期：2015-06-11
 * 修改版本：1.3
 *
 */
@RequestMapping("/api")
public abstract class BaseController {
    @Autowired
    private MessageSource messageSource;
    

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected static ResourceBundle systemProperties = PropertyResourceBundle.getBundle("config/system");

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    protected <T> Result<T> success(T data) {
        String message = messageSource.getMessage(Constants.CODE_SUCCESS, null, "成功", null);
        return new Result<T>(Constants.CODE_SUCCESS, message, data);
    }

    protected <T> Result<T> success() {
        String message = messageSource.getMessage(Constants.CODE_SUCCESS, null, "成功", null);
        return new Result<T>(Constants.CODE_SUCCESS, message, null);
    }

    protected <T> Result<T> success(String code, Object[] param, T data) {
        String message = messageSource.getMessage(code, param, "成功", null);
        return new Result<T>(code, message, data);
    }
    
    protected <T> Result<T> fail(String code) {
        String message = messageSource.getMessage(code, null, code, null);
        return new Result<T>(code, message);
    }

    protected <T> Result<T> failWithMessage(String code,String message){
        return new Result<T>(code,message);
    }

    protected <T> Result<T> fail(String code, Object[] params) {
        String message = messageSource.getMessage(code, params, "系统错误", null);
        return new Result<T>(code, message);
    }

    protected <T> Result<T> fail(String code, String desc) {
        String message = messageSource.getMessage(code, null, desc, null);
        return new Result<T>(code, message);
    }

    protected <T> Result<T> fail(String code, Object[] params, T data) {
        String message = messageSource.getMessage(code, params, null, null);
        return new Result<T>(code, message, data);
    }


    protected <T> Result<T> redirect(String code, T data) {
        return new Result<T>(code, null, data);
    }


    public String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, null);
    }

    /**
     * Spring 全局异常处理方法
     */
    @ExceptionHandler({ RuntimeException.class, Exception.class })
    public Object exceptionHandler(HttpServletRequest request, Exception e) {
        //日志记录　　　
        if (e instanceof BindException) {
            logger.error(request.getServletPath().concat(":").concat(e.getLocalizedMessage()));
        } else {
            logger.error(request.getServletPath(), e);
        }

        // 根据不同的异常类型进行不同处理
        if (e instanceof BindException) {
            FieldError fe = ((BindException) e).getBindingResult().getFieldError();
            return fail(fe.getDefaultMessage());
        }
        if (e instanceof TypeMismatchException)
            return fail(Constants.CODE_REQUEST_INVALID_PARAM);
        if (e instanceof MissingServletRequestParameterException)
            return fail(Constants.CODE_REQUEST_MISS_PARAM);
        if (e instanceof SQLException)
            return fail("");
        if (e instanceof DuplicateKeyException)
            return fail(Constants.DUPLICATE_DEVICE);
        else {
            String code = e.getMessage();
            String message = messageSource.getMessage(code, null, null, null);
            if (StringUtils.isBlank(message)) {
                return fail(Constants.CODE_SYS_ERROR);
            }

            return new Result<String>(code, message);
        }
    }


}
