package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {

    public static void main(String[] args) {

        ApplicationContext context1 = new
                ClassPathXmlApplicationContext("applicationConfig.xml");

        ApplicationConfig context2 = new ApplicationConfig(ApplicationConfig.class);

    }

}
