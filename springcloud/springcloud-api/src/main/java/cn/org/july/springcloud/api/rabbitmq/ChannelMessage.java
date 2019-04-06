package cn.org.july.springcloud.api.rabbitmq;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息通讯类
 */
@Data
public class ChannelMessage implements Serializable {
    private String title;
    private String message;
    private Date createTime = new Date();
}
