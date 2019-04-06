package cn.org.july.springcloud.streams.consumer.service;

import cn.org.july.springcloud.streams.consumer.rabbitMQ.channels.MySendMessagePutChannel;
import cn.org.july.springcloud.streams.consumer.rabbitMQ.channels.receiveMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(value = {MySendMessagePutChannel.class})
@Slf4j
public class ReceiveMsgImpl implements receiveMsg {

    @Override
    @StreamListener(MySendMessagePutChannel.MSG_SEND)
    public void receiveMsg(String msg) {
        log.info("receive msg is {}", msg);
    }
}
