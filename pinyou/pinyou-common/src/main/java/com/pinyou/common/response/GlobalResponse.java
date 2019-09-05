package com.pinyou.common.response;

import com.pinyou.common.enums.CommonResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName GlobalResponse
 * @Discription 统一的返回对象
 * @Author zhidong.li
 * @Date 2019年08月16日 9:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalResponse {
    //是否成功
    private boolean isSuccess;
    //返回响应码
    private String resCode;
    //返回信息
    private String resMsg;
    //返回数据
    private Object data;

    public GlobalResponse(String resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public static GlobalResponse ok(){
        return new GlobalResponse(Boolean.TRUE, CommonResponseEnum.SUCCESS.getCode(),CommonResponseEnum.SUCCESS.getMsg(),null);
    }

    public static GlobalResponse ok(Object data){
        return new GlobalResponse(Boolean.TRUE, CommonResponseEnum.SUCCESS.getCode(),CommonResponseEnum.SUCCESS.getMsg(),data);
    }

    public static GlobalResponse error(){
        return new GlobalResponse(Boolean.FALSE, CommonResponseEnum.ERROR.getCode(),CommonResponseEnum.ERROR.getMsg(),null);
    }

    public static GlobalResponse error(String resCode,String resMsg,Object data){
        return new GlobalResponse(Boolean.FALSE, resCode,resMsg,data);
    }
}
