package com.pinyou;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @ClassName PinYouServletInitializer
 * @Discription springboot外置tomcat配置
 * @Author zhidong.li
 * @Date 2019年08月12日 13:16
 */
public class PinYouServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PinYouApplication.class);
    }
}
