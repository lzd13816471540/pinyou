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
    /**
     * springboot 打war包步骤
     * 1.继承SpringBootServletInitializer
     * 2.移除springboot内置tomcat
     * 3.引入maven依赖 3.0以后无需配置web.xml
     *      <plugin>
     *        <artifactId>maven-war-plugin</artifactId>
     *         <version>3.0.0</version>
     *      </plugin>
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PinYouApplication.class);
    }
}
