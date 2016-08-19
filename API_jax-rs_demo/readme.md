# 项目说明
这是一个jax-rs demo
jax-rs是写restful api常用的技术 

##jetty
项目在maven的pom.xml配置文件里配置了jetty服务器，主要用在idea里可以很方便的运行调试该程序，配置的端口是10188

* 访问首页index.jsp的地址是 
>http://localhost:10189

* 访问HelloWorldService里配置的restful接口服务地址是 
>http://localhost:10189/rest/hello/test

/rest地址路径的配置是在web.xml，配置了/rest 地址对应的包路径。 /hello则在rest服务类里配置了其路径。 /test是对应方法的参数

##2016.08.18 update

* 增加了对json的支持
* 测试get返回json的地址： 
>http://localhost:10189/rest/hello/get

* 测试post json请求的地址： 
>http://localhost:10189/rest/hello/post

  请求内容： 
>{"title":"test","singer":"dog"} 
  
  格式选 application/json; charset=UTF-8
  
##demo实现步骤

请参考notes.doc

##2016.08.19 update
主要把spring和jax-rs集成的sample加进来。为了方便阅读，把相关配置文件都独立放。集成spring需要做的主要工作有以下：

* 增加spring接口 TransactionBo.java
* 增加spring接口实现类 TransactionBoImpl.java
* 增加spring的配置文件 applicationContext.xml，该文件主要定义了spring bean，定义了spring bean才能以@autowire的注解方式调用到sping接口的具体实现类，而不需要new出来。
* 增加了一个调用spring bean的jax-rs service类，paymentService.java， 通过@Autowired的方式调用spring bean
* web.xml里增加了一个新的/spring 的url路径，map到com.later.spring包对应的servlet。

- 同时web.xml里需要引入spring的配置文件（因为web.xml是项目配置的总入口，引入了spring的配置文件spring配置才生效）。
如下：
>      <context-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>classpath:applicationContext.xml</param-value>
     </context-param>
 
- 同时，web.xml需要注册Register Spring “ContextLoaderListener” listener class,如下：
>     <listener>
         <listener-class>
             org.springframework.web.context.ContextLoaderListener
         </listener-class>
     </listener>
     
- 最后,web.xml里配置的servlet-class需要改成spring对应的那个servlet-class。
>Change Jersey servlet from “com.sun.jersey.spi.container.servlet.ServletContainer” to “com.sun.jersey.spi.spring.container.servlet.SpringServlet“.

>        <servlet-class>
             com.sun.jersey.spi.spring.container.servlet.SpringServlet
         </servlet-class>
         
* 测试效果访问地址 http://localhost:10189/spring/payment/later

###至此，该demo已经集成了支持Json，jax-rs api，Spring，大家再根据自己需要集成相应的访问db的模块，这框架基本上就可以满足了大部分的接口开发需求了。
#是不是发现搭建技术架构，也没有那么难？