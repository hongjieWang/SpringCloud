package cn.org.july.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Application_consumer_8000 {
    public static void main(String[] args) {
        SpringApplication.run(Application_consumer_8000.class, args);
    }
}
