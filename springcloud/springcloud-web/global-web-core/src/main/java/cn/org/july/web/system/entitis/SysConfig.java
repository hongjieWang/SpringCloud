package cn.org.july.web.system.entitis;

import cn.org.july.web.common.annotation.Excel;
import cn.org.july.web.common.base.BaseEntity;
import lombok.Data;
import lombok.ToString;


/**
 * 参数配置表 sys_config
 *
 * @author july
 */
@Data
@ToString
public class SysConfig extends BaseEntity {

    /**
     * 参数主键
     */
    @Excel(name = "参数主键")
    private Long configId;

    /**
     * 参数名称
     */
    @Excel(name = "参数名称")
    private String configName;

    /**
     * 参数键名
     */
    @Excel(name = "参数键名")
    private String configKey;

    /**
     * 参数键值
     */
    @Excel(name = "参数键值")
    private String configValue;

    /**
     * 系统内置（Y是 N否）
     */
    @Excel(name = "系统内置", readConverterExp = "Y=是,N=否")
    private String configType;


}
