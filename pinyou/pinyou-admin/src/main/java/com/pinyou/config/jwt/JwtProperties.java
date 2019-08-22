package com.pinyou.config.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName JwtProperties
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 15:33
 */
@Data
@ConfigurationProperties(prefix = "jwt.token")
@Component
public class JwtProperties {

    private String secret;

    private Integer expireTime;
}
