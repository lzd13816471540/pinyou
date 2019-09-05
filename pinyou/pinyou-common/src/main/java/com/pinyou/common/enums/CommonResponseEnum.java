package com.pinyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName CommonResponseEnum
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 10:05
 */
@Getter
@AllArgsConstructor
public enum CommonResponseEnum {

    SUCCESS("200", "成功"),
    ERROR("500","系统内部错误");

    private String code;

    private String msg;

}