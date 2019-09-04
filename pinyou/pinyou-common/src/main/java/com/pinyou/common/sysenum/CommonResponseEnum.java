package com.pinyou.common.sysenum;

/**
 * @ClassName CommonResponseEnum
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 10:05
 */
public enum CommonResponseEnum {

    SUCCESS("200", "成功");

    private String code;

    private String msg;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    CommonResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}