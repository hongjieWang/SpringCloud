package cn.org.july.web.system.entitis;

import cn.org.july.web.common.annotation.Excel;
import cn.org.july.web.common.base.BaseEntity;
import lombok.Data;
import lombok.ToString;


/**
 * 字典类型表 sys_dict_type
 *
 * @author july
 */
@Data
@ToString
public class SysDictType extends BaseEntity {

    /**
     * 字典主键
     */
    @Excel(name = "字典主键")
    private Long dictId;

    /**
     * 字典名称
     */
    @Excel(name = "字典名称")
    private String dictName;

    /**
     * 字典类型
     */
    @Excel(name = "字典类型 ")
    private String dictType;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

}
