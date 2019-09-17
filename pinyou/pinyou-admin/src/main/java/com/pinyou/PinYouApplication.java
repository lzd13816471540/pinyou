package com.pinyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName PinYouApplication
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月12日 13:14
 */

@SpringBootApplication
@MapperScan(basePackages = {"com.pinyou.mapper"})
public class PinYouApplication {
    /*
    * https://blog.csdn.net/u013257679/article/details/54020815
    * */
    public static void main(String[] args) {
        SpringApplication.run(PinYouApplication.class, args);
    }
}
