package com.later.hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liqiliang <liqiliang@baibu.la> on 2017/5/3.
 *
 * @SpringBootApplication相当于@Configuration、@EnableAutoConfiguration和 @ComponentScan，你也可以同时使用这3个注解。
 * 其中@Configuration、@ComponentScan是spring框架的语法，在spring 3.x就有了，用于代码方式创建配置信息和扫描包。
 * @EnableAutoConfiguration是spring boot语法，表示将使用自动配置。你如果下载了spring boot源码，就会看到spring boot实现了很多starter应用，
 * 这些starter就是一些配置信息（有点类似于docker，一组环境一种应用的概念），spring boot看到引入的starter包，就可以计算如果自动配置你的应用。
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
        //在pom配置中我们仅仅使用了spring-boot-starter-web依赖，spring boot会根据此依赖下载相关jar包并初始化基本的运行环境，比如说绑定端口8080等。
        //spring boot封装所有配置信息为键值类型，你想改变默认配置，只需要向应用传入这个键值对就可以，比如我们想改变绑定端口为8081，那么你在main方法里传入“--server.port=8081”即可，或者干脆使用：
        // 　SpringApplication.run(SampleController.class, "--server.port=8081");
        //
        SpringApplication.run(SampleController.class, args);
    }
}
