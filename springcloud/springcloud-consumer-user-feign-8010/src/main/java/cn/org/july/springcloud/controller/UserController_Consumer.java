package cn.org.july.springcloud.controller;

import cn.org.july.springcloud.api.entities.User;
import cn.org.july.springcloud.api.services.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController_Consumer {

    @Autowired
    private UserClientService userClientService;

    @RequestMapping(value = "/consumer/user/all")
    @ResponseBody
    public List getUserAll() {
        return userClientService.findAll();
    }

    @RequestMapping(value = "/consumer/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id) {
        return userClientService.findById(id);
    }

}
