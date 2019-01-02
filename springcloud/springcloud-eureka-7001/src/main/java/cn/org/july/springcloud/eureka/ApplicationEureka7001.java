package cn.org.july.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author july_whj
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationEureka7001 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEureka7001.class, args);
    }

}
