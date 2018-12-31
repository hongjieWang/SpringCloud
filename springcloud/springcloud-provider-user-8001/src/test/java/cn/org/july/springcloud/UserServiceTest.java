package cn.org.july.springcloud;


import cn.org.july.springcloud.service.UserService;
import cn.org.july.springcloud.api.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAll() {
        List<User> userList = userService.findAll();
        userList.forEach(user -> {
            System.out.println(user.getUserName());
            System.out.println(user.getPhone());
        });
    }

    @Test
    public void findById() {
        System.out.println(userService.findById(1L).getUserName());
    }
}
