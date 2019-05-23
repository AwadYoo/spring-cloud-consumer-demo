package com.jet;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@see 看板地址：http://localhost:9001/hystrix
//监控地址：http://192.168.1.150/hystrix.stream 注:localhost报错
@EnableHystrixDashboard
//启动断路器
@EnableCircuitBreaker
public class SpringCloudConsumerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerDemoApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean regBean = new ServletRegistrationBean(streamServlet);
        regBean.setLoadOnStartup(1);
        List mappingList = new ArrayList();
        mappingList.add("/hystrix.stream");
        regBean.setUrlMappings(mappingList);
        regBean.setName("hystrixServlet");
        return regBean;
    }
}
