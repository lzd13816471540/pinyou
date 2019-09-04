package com.pinyou.web;

import com.pinyou.common.response.GlobalResponse;
import com.pinyou.common.enums.CommonResponseEnum;
import com.pinyou.config.jwt.JwtUtil;
import com.pinyou.domain.User;
import com.pinyou.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping( value = "/login",method = RequestMethod.POST)
    public GlobalResponse login(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        map.put("token",JwtUtil.createJwt(user.getLoginName()));
        return new GlobalResponse(Boolean.TRUE,CommonResponseEnum.SUCCESS.getCode(),CommonResponseEnum.SUCCESS.getMsg(),map);
    }

    @RequestMapping("/getUserList")
    public GlobalResponse doLogin(){
        User user = userInfoMapper.selectOne(1);
        return GlobalResponse.ok(user);
    }
}
