package cn.org.july.springcloud.springcloud.streams.provider.rabbitMQ.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义消息通道
 */
public interface MySendMessagePutChannel {

    String MSG_DEFAULT = "msg_default";
    String MSG_SEND = "msg_send";

    @Output(MSG_DEFAULT)
    MessageChannel sendMessageDefaule();

    @Output(MSG_SEND)
    MessageChannel sendMessage();


}
