package com.example.workforspringboot;

import com.example.workforspringboot.entity.Admin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@MapperScan(basePackages = "com.example.workforspringboot.mapper")
@EnableWebMvc
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})

public class WorkForSpringbootApplication {

    public static void main(String[] args) {
/*
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        //beanFactory.registerSingleton("user",new User());
        AbstractBeanDefinition beanDefinition= BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(Admin.class);

        beanFactory.registerBeanDefinition("admin",beanDefinition);
        Admin admin=beanFactory.getBean("admin",Admin.class);
        System.out.println(admin);
*/


        SpringApplication.run(WorkForSpringbootApplication.class, args);
    }



}
