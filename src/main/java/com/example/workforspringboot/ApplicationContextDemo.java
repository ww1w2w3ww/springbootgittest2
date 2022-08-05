/*
package com.example.workforspringboot;


import com.example.workforspringboot.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

*/
/**
 * @program: ApplicationContextDemo
 * @description: ApplicationContext入门学习
 * @author: 辰兮要努力
 * @create: 2021-11-10 22:07:54
 *//*

public class ApplicationContextDemo {

    //打印日志
    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextDemo.class);

    public static void main(String[] args) {
        */
/**
         *
         * ApplicationContext体系结构
         * 主要实现类：
         * ClassPathXmlApplicationContext：默认从类路径加载配置文件
         * FileSystemXmlApplicationContext：默认从文件系统中装载配置文件
         *//*

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        */
/**
         * Singleton：单实例（在容器启动完成之前就已经创建好了，保存在容器中了，任何时候获取都是获取之前创建好的那个对象）
         *//*

        User user = (User) applicationContext.getBean("UserSingleton");
        User user1 = (User) applicationContext.getBean("UserSingleton");
        */
/**
         * 换一种写法：<T> T getBean(String var1, Class<T> var2) throws BeansException;
         *//*

        User user2 =  applicationContext.getBean("UserSingleton",User.class);

        logger.info("user.hashCode()是:{}",user.hashCode());
        logger.info("user1.hashCode()是:{}",user1.hashCode());

        logger.info("user是:{}",user);
        logger.info("user1是:{}",user1);
        logger.info("user == user1 :{}",user == user1);



        */
/**
         * Prototype：多实例（容器启动默认不会创建多实例bean对象，只有在获取的时候才创建，每次获取都会创建一个新的实例对象）
         *//*

        User user3 = (User) applicationContext.getBean("UserPrototype");
        User user4 = (User) applicationContext.getBean("UserPrototype");

        logger.info("user3.hashCode()是:{}",user3.hashCode());
        logger.info("user4.hashCode()是:{}",user4.hashCode());
        logger.info("user3是:{}",user3);
        logger.info("user4是:{}",user4);
        logger.info("user3 == user4 :{}",user3 == user4);

    }
}
*/
