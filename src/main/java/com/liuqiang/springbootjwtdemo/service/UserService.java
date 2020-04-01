package com.liuqiang.springbootjwtdemo.service;

import com.liuqiang.springbootjwtdemo.entity.User;
import com.liuqiang.springbootjwtdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private   UserMapper userMapper=null;
    public User findByUsername(User user){
       return   userMapper.findByUsername(user.getUsername());
    }
    public User findUserById(String id) { return userMapper.findUserById(id);
    }
}
