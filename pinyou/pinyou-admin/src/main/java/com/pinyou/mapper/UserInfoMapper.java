package com.pinyou.mapper;

import com.pinyou.domain.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserInfoMapper
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月09日 14:14
 */
public interface UserInfoMapper {

    SysUser selectOne(@Param("id") Integer id);

    SysUser queryUserByLoginName(String loginName);
}
