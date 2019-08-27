package com.pinyou.common.response;

import com.pinyou.common.sysenum.CommonResponseEnum;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName GlobalResponse
 * @Discription 统一的返回对象
 * @Author zhidong.li
 * @Date 2019年08月16日 9:56
 */
@Data
public class GlobalResponse {
    //是否成功
    private boolean isSuccess;
    //返回响应码
    private String resCode;
    //返回信息
    private String resMsg;
    //返回数据
    private Map<String,Object> data;

    public GlobalResponse() {
    }

    public GlobalResponse(String resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public GlobalResponse(boolean isSuccess, String resCode, String resMsg, Map<String, Object> data) {
        this.isSuccess = isSuccess;
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.data = data;
    }

    public static GlobalResponse success(Map<String,Object> data){
        return new GlobalResponse(true, CommonResponseEnum.SUCCESS.getCode(),CommonResponseEnum.SUCCESS.getMsg(),data);
    }
}
