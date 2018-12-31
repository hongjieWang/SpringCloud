package cn.org.july.springcloud.controller;

import cn.org.july.springcloud.service.UserService;
import cn.org.july.springcloud.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/all")
    @ResponseBody
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id){
        return userService.findById(id);
    }


}
