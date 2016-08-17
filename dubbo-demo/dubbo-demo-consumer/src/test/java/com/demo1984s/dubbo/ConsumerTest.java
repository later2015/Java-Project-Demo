package com.demo1984s.dubbo;

import com.demo1984s.dubbo.api.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class ConsumerTest {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:META-INF/spring/consumer.xml"});
        context.start();

        DemoService demoService = (DemoService)context.getBean("demoService", DemoService.class); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法

        System.out.println( hello ); // 显示调用结果

        System.in.read();// 按任意键退出
    }

}
