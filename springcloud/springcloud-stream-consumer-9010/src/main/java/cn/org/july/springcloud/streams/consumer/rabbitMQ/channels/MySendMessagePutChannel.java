package cn.org.july.springcloud.streams.consumer.rabbitMQ.channels;

import org.springframework.cloud.stream.annotation.Input;
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

    @Input(MSG_SEND)
    MessageChannel sendMessage();


}
