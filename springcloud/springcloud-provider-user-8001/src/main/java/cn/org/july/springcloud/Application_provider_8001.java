package cn.org.july.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.org.july.springcloud")
public class Application_provider_8001 {

    public static void main(String[] args) {
        SpringApplication.run(Application_provider_8001.class, args);
    }

}
