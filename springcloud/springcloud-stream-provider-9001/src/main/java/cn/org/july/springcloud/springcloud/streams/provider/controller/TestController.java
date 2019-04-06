package cn.org.july.springcloud.springcloud.streams.provider.controller;

import cn.org.july.springcloud.springcloud.streams.provider.service.MessageChannelService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private MessageChannelService channelService;

    @RequestMapping(value = "/send")
    @ResponseBody
    public String sendMessage(@Param("msg")String msg){
        for (int i = 0; i < 1000; i++) {
            channelService.sendBrandAdd(msg);
        }
        System.out.println("msg is : "+msg);
        return "ok";
    }

}
