# Spring boot demo

Spring Boot是Spring团队推出的新框架，它所使用的核心技术还是Spring框架，主要是Spring 4.x，所以如果熟悉spring 4的人，能够更快的接受和学会这个框架。Spring boot可以看做是在spring框架基础上再包了一层，这一层包含方便开发者进行配置管理和快速开发的模块，以及提供了一些开箱即用的工具，比如监控等。
   
   　　Spring Boot官方文档有中文翻译版：
   
   　　https://github.com/qibaoguang/Spring-Boot-Reference-Guide
   
## 项目创建步骤
- 创建maven项目
- 给maven的pom.xml 配置文件里加上Spring boot的配置（具体内容见代码）
- new一个类，给类里放入代码

      package com.later.hello;
    import org.springframework.boot.*;
    import org.springframework.boot.autoconfigure.*;
    import org.springframework.stereotype.*;
    import org.springframework.web.bind.annotation.*;
    /**
     * Created by later on 2017/5/3.
     */
    @Controller
    @SpringBootApplication
    public class SampleController {
        @ResponseBody
        @RequestMapping(value = "/")
        String home() {
            return "Hello World!";
        }
    
        public static void main(String[] args) throws Exception {
            SpringApplication.run(SampleController.class, args);
        }
    }

- 然后就可以运行应用了，点击F11，或者在SampleController类右键“Run Java Application”就可以看到应用启动并运行了。
  
  此时在浏览器输入http://localhost:8080/，你会看到helloworld字样，这是一个web应用，使用了嵌入式的tomcat。
  
  在pom配置中我们仅仅使用了spring-boot-starter-web依赖，spring boot会根据此依赖下载相关jar包并初始化基本的运行环境，比如说绑定端口8080等。
  
  spring boot封装所有配置信息为键值类型，你想改变默认配置，只需要向应用传入这个键值对就可以，比如我们想改变绑定端口为8081，那么你在main方法里传入“—server.port=8081”即可，或者干脆使用：
  
     SpringApplication.run(SampleController.class, "--server.port=8081");
  
## 部署spring boot应用
  
  
  　　要部署运行spring boot应用，首选要打包spring boot应用，你在pom文件中看到的spring-boot-maven-plugin插件就是打包spring boot应用的。
  
  进入工程目录运行mvn package，如：
  
    D:\cloud-simple-helloword>mvn package
  
  　　打包过后就可以进入target目录使用java原生命令执行这个应用了。
  
    D:\cloud-simple-helloword\target>java -jar cloud-simple-helloword-0.0.1.jar --server.port=8081
  
  　　如此，你就看到一个基于jar包的web应用启动了。
  
  　　Spring boot提供的一些开箱即用的应用非常容易使用，比如监控，你只需要在pom文件中引入： 
      
      <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-actuator</artifactId>
      </dependency>
  
引入之后，spring boot是默认开启监控的，运行应用你可以在浏览器中输入：
  
           http://localhost:8080/health
  
  　　就可以看到默认的监控信息了：
  
     {"status":"UP","diskSpace":{"status":"UP","total":161067397120,"free":91618398208,"threshold":10485760}}
  
  　　信息包括程序执行状态以及基本的磁盘信息。