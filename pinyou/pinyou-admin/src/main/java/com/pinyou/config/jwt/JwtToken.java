package com.pinyou.config.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @ClassName JwtToken
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 17:11
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
