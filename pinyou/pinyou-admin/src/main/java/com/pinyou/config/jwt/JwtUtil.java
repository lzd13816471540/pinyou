package com.pinyou.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pinyou.common.constant.SecurityConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @ClassName JwtUtil
 * @Discription jwt工具类
 * @Author zhidong.li
 * @Date 2019年08月14日 15:44
 */
@Slf4j
@Component
public class JwtUtil {

    //JWT加密密钥
    private static final String SECRETKET = "";

    /**
     * 生成jwt token
     *
     * @return
     */
    public static String createJwt(String acoount,long expireTime) {
        try {
            Date date = new Date(System.currentTimeMillis() + expireTime);
            Algorithm algorithm = Algorithm.HMAC256(SECRETKET);
            return JWT.create()
                    .withClaim(SecurityConstant.ACCOUNT, acoount)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            e.printStackTrace();
            log.info("生成token失败：{}", e.getMessage());
        }
        return null;
    }

    /**
     * 验证token
     */
    public static boolean isVerify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRETKET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            log.info("验证token失败：{}", e.getMessage());
        }
        return false;
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getClaim(String token, String claim) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(claim).asString();
        } catch (JWTDecodeException e) {
            log.info("获取token中用户信息失败：{}", e.getMessage());
            return null;
        }
    }

}
