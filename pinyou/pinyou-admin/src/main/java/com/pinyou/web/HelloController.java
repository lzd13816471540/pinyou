package com.pinyou.web;

import com.pinyou.config.jwt.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @ClassName HelloController
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月16日 13:19
 */
@RestController
public class HelloController{


    @RequestMapping("hello")
    public String hello(){

        JwtUtil.createJwt("");
        Random e = new Random();
        if(Boolean.TRUE){
            String s = "a";
            String[] split = s.split("");
        }
        return "hello world";
    }
}
