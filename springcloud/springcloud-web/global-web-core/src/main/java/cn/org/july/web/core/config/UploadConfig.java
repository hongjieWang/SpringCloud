package cn.org.july.web.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created with IntelliJ IDEA.
 * User:  wanghongjie
 * Date:  2019/7/9 - 22:38
 * <p>
 * Description:
 */
@Configuration
public class UploadConfig {

    //显示声明CommonsMultipartResolver为mutipartResolver
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        //resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setResolveLazily(true);
        resolver.setMaxInMemorySize(40960);
        //上传文件大小 5M 5*1024*1024
//        resolver.setMaxUploadSize(5 * 1024 * 1024);
        return resolver;
    }
}