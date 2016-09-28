# SpringMVC hello world sample（spring3）
##功能说明
* 这是一个web项目，需要跑在web容器上。maven配置里配了jetty插件，也可以直接用jetty跑。
* SpringMVC的sample，实现了从URL传值到controller再到jsp的一个过程。如果需要接上db的话，在controller里接上即可。
* 该sample是使用xml配置的

##遗留问题
* 对于URL的mapping过程还是了解得不太清楚。跟jax-rs的配置略有不同。
pom.xml配置了部署在jetty上的路径/Spring3，web.xml配置了根路径。但是根路径该mapping到那个文件夹的controller的，好像没有显式配置。其中机制还没了解清楚。
* jsp里面引用的css和js包没放进来，不过不影响程序运行，只是界面难看点。

