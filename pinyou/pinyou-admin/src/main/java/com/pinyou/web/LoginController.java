package com.pinyou.web;

import com.pinyou.common.response.GlobalResponse;
import com.pinyou.common.sysenum.CommonResponseEnum;
import com.pinyou.config.jwt.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 17:18
 */
@Slf4j
@RestController
public class LoginController {

    @RequestMapping("/login")
    public GlobalResponse login(){
        Map<String, Object> map = new HashMap<>();
        map.put("token",JwtUtil.createJwt("shangsan"));
        return new GlobalResponse(Boolean.TRUE,CommonResponseEnum.SUCCESS.getCode(),CommonResponseEnum.SUCCESS.getMsg(),map);
    }
}
