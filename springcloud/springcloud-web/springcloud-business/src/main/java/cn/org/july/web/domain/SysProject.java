package cn.org.july.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import cn.org.july.web.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 项目管理表 sys_project
 *
 * @author null
 * @date 2019-06-26
 */
public class SysProject extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 项目编号
     */
    private String projectNumber;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 状态
     */
    private String status;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("projectNumber", getProjectNumber())
                .append("projectName", getProjectName())
                .append("status", getStatus())
                .toString();
    }
}
