package com.pinyou.common.sysenum;

/**
 * @ClassName CommonResponseEnum
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 10:05
 */
public enum CommonResponseEnum {

    SUCCESS("200","成功"),
    ;

    private String code;

    private String msg;

    CommonResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }}
