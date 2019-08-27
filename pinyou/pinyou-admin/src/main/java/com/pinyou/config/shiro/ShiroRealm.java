package com.pinyou.config.shiro;

import com.pinyou.common.constant.SecurityConstant;
import com.pinyou.config.jwt.JwtToken;
import com.pinyou.config.jwt.JwtUtil;
import com.pinyou.domain.User;
import com.pinyou.mapper.UserInfoMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName ShiroRealm
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 13:39
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoMapper mapper;

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
    /**
     * 用户认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String jwtToken = (String) token.getPrincipal();

        String loginName = JwtUtil.getClaim(jwtToken, SecurityConstant.ACCOUNT);
        if(null == loginName){
            throw new AuthenticationException("无效的token");
        }

        User user = mapper.queryUserByLoginName(loginName);
        if(user == null){
            throw new AuthenticationException("用户不存在");
        }

        if (!JwtUtil.isVerify(jwtToken)){
            throw new AuthenticationException("用户名或密码错误");
        }
        return new SimpleAuthenticationInfo(jwtToken,jwtToken,getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }



}
