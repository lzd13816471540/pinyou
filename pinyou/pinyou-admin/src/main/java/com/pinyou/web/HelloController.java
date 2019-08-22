package com.pinyou.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        int i = 1/0;

        return "hello world";
    }
}
