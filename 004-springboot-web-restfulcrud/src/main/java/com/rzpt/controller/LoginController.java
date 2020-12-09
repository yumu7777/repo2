package com.rzpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

//登录
@Controller
public class LoginController {
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
   //新特性
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        if (!StringUtils.isEmpty(username)&&"123".equals(password)){
           //登录成功,防止表单重复提交,可以重定向导主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名密码错误");
            return "login";
        }


    }

}
