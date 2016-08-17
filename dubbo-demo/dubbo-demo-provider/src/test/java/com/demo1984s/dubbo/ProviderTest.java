package com.demo1984s.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class ProviderTest {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:META-INF/spring/provider.xml"});
        context.start();

        System.in.read();// 按任意键退出
    }

}
