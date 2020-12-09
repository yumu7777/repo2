package com.rzpt.config;

import com.rzpt.filter.MyFilter;
import com.rzpt.listener.MyListener;
import com.rzpt.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;
import java.util.Arrays;

//配置类
@Configuration
public class MyServletConfig {

    //注册servlet三大组件
    //Servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        //后面有参构造,new 自己的servlet,然后路径
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");

        return registrationBean;
    }
    //Filter
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }
    //Listener
    @Bean
    public ServletListenerRegistrationBean<MyListener> myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean(new MyListener());
        return registrationBean;
    }

}
