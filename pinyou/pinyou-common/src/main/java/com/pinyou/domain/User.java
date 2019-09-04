package com.pinyou.domain;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName UserInfo
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月12日 16:22
 */
@Data
public class User {

    private Integer id;

    private String loginName;

    private String userName;

    private String userPwd;

    private String mobileNo;

    private String status;

    private String remark;

    private String createName;

    private String updateName;

    private Date createTime;

    private Date updateTime;
}
