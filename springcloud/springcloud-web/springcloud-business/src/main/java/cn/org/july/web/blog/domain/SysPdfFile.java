package cn.org.july.web.blog.domain;

import cn.org.july.web.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 文件管理表 sys_file
 *
 * @author null
 * @date 2019-07-07
 */
public class SysPdfFile extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;
    /**
     * 文件名称
     */
    private String pdfName;
    /**
     * 文件下载地址
     */
    private String pdfDownLoadUrl;
    /**
     * 文件本地地址
     */
    private String pdfLoaclUrl;
    /**
     * 文件类型
     */
    private String pdfType;
    /**
     * 上传用户ID
     */
    private Integer userId;
    /**
     * 是否删除
     */
    private Boolean isDelect;
    /**
     * 状态
     */
    private Boolean isStatus = true;
    /**
     * 下载次数
     */
    private Integer downloadNumber = 0;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfDownLoadUrl(String pdfDownLoadUrl) {
        this.pdfDownLoadUrl = pdfDownLoadUrl;
    }

    public String getPdfDownLoadUrl() {
        return pdfDownLoadUrl;
    }

    public void setPdfLoaclUrl(String pdfLoaclUrl) {
        this.pdfLoaclUrl = pdfLoaclUrl;
    }

    public String getPdfLoaclUrl() {
        return pdfLoaclUrl;
    }

    public void setPdfType(String pdfType) {
        this.pdfType = pdfType;
    }

    public String getPdfType() {
        return pdfType;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setIsDelect(Boolean isDelect) {
        this.isDelect = isDelect;
    }

    public Boolean getIsDelect() {
        return isDelect;
    }

    public void setIsStatus(Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Boolean getIsStatus() {
        return isStatus;
    }

    public void setDownloadNumber(Integer downloadNumber) {
        this.downloadNumber = downloadNumber;
    }

    public Integer getDownloadNumber() {
        return downloadNumber;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("pdfName", getPdfName())
                .append("pdfDownLoadUrl", getPdfDownLoadUrl())
                .append("pdfLoaclUrl", getPdfLoaclUrl())
                .append("pdfType", getPdfType())
                .append("userId", getUserId())
                .append("isDelect", getIsDelect())
                .append("isStatus", getIsStatus())
                .append("downloadNumber", getDownloadNumber())
                .toString();
    }
}
