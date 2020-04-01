package com.liuqiang.springbootjwtdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.liuqiang.springbootjwtdemo.annotation.UserLoginToken;
import com.liuqiang.springbootjwtdemo.entity.User;
import com.liuqiang.springbootjwtdemo.service.TokenService;
import com.liuqiang.springbootjwtdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api")
public class UserApi {
    @Resource
    UserService userService=null;
    @Resource
    TokenService tokenService=null;
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonpObject=new JSONObject();
        User userForBase=userService.findByUsername(user);
        if(userForBase==null){
            jsonpObject.put("message","登录失败,用户不存在");
            return jsonpObject;
        }
        else {
            if(!userForBase.getPassword().equals(user.getPassword())){
                jsonpObject.put("message","登陆失败，密码错误");
                return jsonpObject;
            }
            else {
                String token=tokenService.getToken(userForBase);
                jsonpObject.put("token",token);
                jsonpObject.put("user",userForBase);
                return jsonpObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
