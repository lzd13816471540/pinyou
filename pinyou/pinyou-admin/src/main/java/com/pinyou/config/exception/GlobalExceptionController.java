package com.pinyou.config.exception;

import com.pinyou.common.response.GlobalResponse;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GlobalExceptionController
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 10:10
 */
@ControllerAdvice(basePackages = {"com.pinyou"})
public class GlobalExceptionController {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public GlobalResponse globalExceptionHandler(Exception e){
        GlobalResponse res = new GlobalResponse();
        if(e instanceof GlobalException){
            GlobalException ge = (GlobalException) e;
            res.setResCode(ge.getExcCode());
            res.setResMsg(ge.getExcMsg());
            return res;
        }
        return new GlobalResponse("500",e.getMessage() == null? "服务器内部错误" : e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = AuthenticationException.class)
    public GlobalResponse globalExceptionHandler(AuthenticationException e){
        return new GlobalResponse("401",e.getMessage());
    }
}
