package com.pinyou.config.filter.jwt;

import com.pinyou.config.jwt.JwtToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName JwtFilter
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 10:38
 */
public class JwtFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        try {
            return executeLogin(request, response);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        JwtToken jwtToken = new JwtToken(token);
        getSubject(request, response).login(jwtToken);
        return true;
    }
}
