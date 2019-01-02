package cn.org.july.web.system.entitis;

import cn.org.july.web.common.base.BaseEntity;
import cn.org.july.web.common.enums.OnlineStatus;
import lombok.Data;

import java.util.Date;

/**
 * 在线状态统计
 *
 * @author july
 */
@Data
public class SysUserOnline extends BaseEntity {

    /**
     * 用户会话id
     */
    private String sessionId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地址
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * session创建时间
     */
    private Date startTimestamp;

    /**
     * session最后访问时间
     */
    private Date lastAccessTime;

    /**
     * 超时时间，单位为分钟
     */
    private Long expireTime;

    /**
     * 在线状态
     */
    private OnlineStatus status = OnlineStatus.on_line;
}
