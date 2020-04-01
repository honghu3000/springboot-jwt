package com.liuqiang.springbootjwtdemo.mapper;

import com.liuqiang.springbootjwtdemo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User findByUsername(@Param("username")  String username);
    User findUserById(@Param("Id") String Id);
}
