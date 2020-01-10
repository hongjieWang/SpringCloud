package cn.org.july.springcloudapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.swing.*;
import java.io.Serializable;

/**
 * 部门实体
 *
 * @author wanghongjie
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String userName;
    /**
     * 存储数据库位置（分布式部署可能存在多个数据库）
     */
    private String dbSource;
    /**
     * 电话号
     */
    private Spring phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String pwd;

}
