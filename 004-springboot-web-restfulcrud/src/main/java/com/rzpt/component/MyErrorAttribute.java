package com.rzpt.component;


import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//给容器加入我们自己订制的错误提示数据
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    //返回值map就是页面和接送能获取的所有字段,异常所定义的字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        map.put("school","rzpt");
        //我们的异常处理器携带的数据
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;
    }
}
