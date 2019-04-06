package cn.org.july.springcloud.springcloud.streams.provider.service;

import cn.org.july.springcloud.springcloud.streams.provider.rabbitMQ.channels.MySendMessagePutChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@EnableBinding(MySendMessagePutChannel.class)
@Slf4j
public class MessageChannelService {
    @Autowired
    @Output(MySendMessagePutChannel.MSG_SEND)
    private MessageChannel channel;

    public void sendBrandAdd(String brand) {
        channel.send(MessageBuilder.withPayload(brand).build());
        log.info("【MQ发送内容】" + brand);
    }

}
