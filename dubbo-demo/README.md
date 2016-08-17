# dubbo-demo
dubbo 官方git的例子有点复杂,这里自行查资料做了一个demo

注册中心使用zookeeper-3.4.6

&lt;dubbo:registry address="zookeeper://127.0.0.1:2181" /&gt;

MacBook,使用multicast广播注册中心暴露发现服务地址提示 Cannot assign requested address 问题:

&lt;dubbo:registry address="multicast://224.0.0.0:1234" /&gt;

***
### 2016.08.17更新说明
1.新增dubbo.properties,将dubbo配置从spring配置文件分离出来

2.provider打成zip包
mvn clean assembly:assembly

3.根据官方git增加相关脚本（脚本存放在src/main/scripts,使用src/main/assembly/bin的话bin目录因.gitignore配置会被忽略）

dump.sh - 系统状态

restart.sh - 重启

start.sh - 启动

start.sh debug - 调试

stop.sh - 停止

server.sh - 总入口

server.sh start

server.sh stop

server.sh restart

server.sh debug

server.sh dump
