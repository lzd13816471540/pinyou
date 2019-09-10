package com.pinyou.web;

import com.pinyou.common.response.GlobalResponse;
import com.pinyou.config.jwt.JwtUtil;
import com.pinyou.domain.SysUser;
import com.pinyou.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 17:18
 */
@Slf4j
@RestController
public class LoginController {

    @Value("${jwt.token.expireTime}")
    private long expireTime;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping( value = "/login",method = RequestMethod.POST)
    public GlobalResponse login(@RequestBody SysUser sysUser){
        return GlobalResponse.ok(JwtUtil.createJwt(sysUser.getLoginName(),expireTime));
    }

    @RequestMapping("/getUserList")
    public GlobalResponse doLogin(){
        SysUser sysUser = userInfoMapper.selectOne(1);
        return GlobalResponse.ok(sysUser);
    }
}
