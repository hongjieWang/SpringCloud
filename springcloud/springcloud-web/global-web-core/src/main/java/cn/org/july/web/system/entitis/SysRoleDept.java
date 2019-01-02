package cn.org.july.web.system.entitis;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 角色和部门关联 sys_role_dept
 *
 * @author july
 */
@Data
public class SysRoleDept {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 部门ID
     */
    private Long deptId;

}
