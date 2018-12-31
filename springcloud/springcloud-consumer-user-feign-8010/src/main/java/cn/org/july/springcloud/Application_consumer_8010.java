package cn.org.july.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"cn.org.july.springcloud"})
public class Application_consumer_8010 {
    public static void main(String[] args) {
        SpringApplication.run(Application_consumer_8010.class, args);
    }
}
