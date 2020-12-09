package com.rzpt.controller;

import com.rzpt.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    /*默认访问首页*/
   /* @RequestMapping({"/","index"})
    public String index(){
        return "index";
    }
*/
   //@RequestParam 从请求参数中获取信息
    @ResponseBody
    @RequestMapping(value = "/hello")
    public Object Hello(@RequestParam("user")String user){
        if (user.equals("aaa")){
            throw  new UserNotExistException();
        }
        return "hello springboot web";
    }


    //查出用户数据,在页面显示
       @RequestMapping("/success")
      public String success(Map<String,Object> map){
        map.put("hello","<h2>你好</h2>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";

    }

}
