package cn.org.july.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApplicationEureka7003 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEureka7003.class, args);
    }
}
