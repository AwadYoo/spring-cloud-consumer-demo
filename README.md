# spring-cloud-consumer-demo
spring-cloud-consumer-demo 包含熔断监控Hystrix Dashboard和Turbine
***
启动项目后 访问

[地址]: http://192.168.1.150:9001/hystrix `即可打开监控页面`
***
在*Hystrix Dashboard* 输入框里输入   
检测地址: _**http://ip:port/hystrix.steam**_  
`即可直观地看到各Hystrix Command的请求响应时间, 请求成功率等数据`


2019-05-24
* 改用spring cloud center 配置本项目的配置文件properties
* 新增了bootstrap.properties文件

 `spring.cloud.config.name=consumer`  
 `spring.cloud.config.uri=http://localhost:8009`
 `spring.cloud.config.label=master`  
 `spring.cloud.config.profile=dev`
- spring.application.name：对应{application}部分  
- spring.cloud.config.profile：对应{profile}部分  
- spring.cloud.config.label：对应git的分支。如果配置中心使用的是本地存储，则该参数无用  
- spring.cloud.config.uri：配置中心的具体地址  
- spring.cloud.config.discovery.service-id：指定配置中心的service-id，便于扩展为高可用配置集群。

**注：云端配置加载无需手动配置注入，config center 会自动注入**  