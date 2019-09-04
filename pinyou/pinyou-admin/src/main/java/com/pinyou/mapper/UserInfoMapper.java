package com.pinyou.mapper;

import com.pinyou.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserInfoMapper
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月09日 14:14
 */
public interface UserInfoMapper {

    User selectOne(@Param("id") Integer id);

    User queryUserByLoginName(String loginName);
}
