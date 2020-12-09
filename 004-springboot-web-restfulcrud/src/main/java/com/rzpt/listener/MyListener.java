package com.rzpt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//监听器
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized web应用启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed web 应用关闭了");
    }
}
