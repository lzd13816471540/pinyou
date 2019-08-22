package com.pinyou.config.exception;

import lombok.Data;

/**
 * @ClassName GlobalExecption
 * @Discription 全局统一异常
 * @Author zhidong.li
 * @Date 2019年08月16日 10:01
 */
@Data
public class GlobalException extends RuntimeException{
    //异常状态码
    private String excCode;
    //异常信息
    private String excMsg;

}
