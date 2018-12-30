package cn.org.july.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "cn.org.july.springcloud")
public class Application_provider_8003 {

    public static void main(String[] args) {
        SpringApplication.run(Application_provider_8003.class, args);
    }

}
