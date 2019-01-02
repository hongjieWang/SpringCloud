package cn.org.july.web.system.entitis;


import cn.org.july.web.common.base.BaseEntity;
import lombok.Data;

/**
 * 通知表 sys_notice
 *
 * @author july
 */
@Data
public class SysNotice extends BaseEntity {

    /**
     * 公告ID
     */
    private Long noticeId;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告类型（1通知 2公告）
     */
    private String noticeType;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告状态（0正常 1关闭）
     */
    private String status;

}
