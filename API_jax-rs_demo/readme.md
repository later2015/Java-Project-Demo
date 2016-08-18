# 项目说明
这是一个jax-rs demo
jax-rs是写restful api常用的技术 

##jetty
项目在maven的pom.xml配置文件里配置了jetty服务器，主要用在idea里可以很方便的运行调试该程序，配置的端口是10188

* 访问首页index.jsp的地址是 
>http://localhost:10188

* 访问HelloWorldService里配置的restful接口服务地址是 
>http://localhost:10188/rest/hello/test

/rest地址路径的配置是在web.xml，配置了/rest 地址对应的包路径。 /hello则在rest服务类里配置了其路径。 /test是对应方法的参数

##2016.08.18 update

* 增加了对json的支持
* 测试get返回json的地址： 
>http://localhost:10188/rest/hello/get

* 测试post json请求的地址： 
>http://localhost:10188/rest/hello/post

  请求内容： 
>{"title":"test","singer":"dog"} 
  
  格式选 application/json; charset=UTF-8