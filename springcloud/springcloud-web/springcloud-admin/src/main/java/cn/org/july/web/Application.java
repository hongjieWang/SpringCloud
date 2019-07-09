package cn.org.july.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication
@MapperScan({"cn.org.july.web.system.dao", "cn.org.july.web.dao", "cn.org.july.web.attendance.dao",
        "cn.org.july.web.blog.dao"})
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
