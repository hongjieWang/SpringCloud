package cn.org.july.springcloud.controller;

import cn.org.july.springcloud.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController_Consumer {

//    private static final String url = "http://localhost:8001/";
    private static final String url = "http://SPRINGCLOUD-USER/";

    /**
     * RestTemplate 提供了多种便捷访问远程HTTP服务的方法
     * 是一种简单便捷的访问restful服务模版类，是Spring提供的用于访问
     * Rest服务的客户端模版工具集
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/user/all")
    @ResponseBody
    public List getUserAll() {
        return restTemplate.getForObject(url.concat("/user/all"), List.class);
    }

    @RequestMapping(value = "/consumer/user/{id}")
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return restTemplate.getForEntity(url.concat("/user/").concat(id.toString()), User.class);
    }

}
