package com.liuqiang.springbootjwtdemo.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GloablExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e){
        String msg=e.getMessage();
        if(msg==null || msg.equals("")){
            msg="服务器出错";
        }
        JSONObject obj=new JSONObject();
        obj.put("message",msg);
        return obj;
    }
}
