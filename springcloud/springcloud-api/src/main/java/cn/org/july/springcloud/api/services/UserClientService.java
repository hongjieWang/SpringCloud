package cn.org.july.springcloud.api.services;

import cn.org.july.springcloud.api.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(value = "SPRINGCLOUD-USER")
public interface UserClientService {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
    @RequestMapping(value = "/user/all",method = RequestMethod.GET)
    List<User> findAll();
}
