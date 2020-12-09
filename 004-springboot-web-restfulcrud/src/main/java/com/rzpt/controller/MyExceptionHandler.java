package com.rzpt.controller;
//异常处理器

import com.rzpt.exception.UserNotExistException;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
   /*
   1.浏览器客户端返回的都是json,没能自适应
   @ResponseBody
    @ExceptionHandler(UserNotExistException.class)  //标注要处理的异常
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
       return map;
    }*/
    @ExceptionHandler(UserNotExistException.class)  //标注要处理的异常
    public String handleException(Exception e, HttpServletRequest request){
        //传入我们自己的状态码
        request.setAttribute("javax.servlet.error.status_code",400);
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }

}
