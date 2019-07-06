package cn.org.july.web.attendance.domain;

import cn.org.july.web.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 博客技术表 sys_boke
 *
 * @author null
 * @date 2019-07-02
 */
public class SysBoke extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String auther;
    /**
     * 创建时间
     */
    private Date time;
    /**
     * md文件内容
     */
    private String text;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getAuther() {
        return auther;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("auther", getAuther())
                .append("time", getTime())
                .append("text", getText())
                .toString();
    }
}
