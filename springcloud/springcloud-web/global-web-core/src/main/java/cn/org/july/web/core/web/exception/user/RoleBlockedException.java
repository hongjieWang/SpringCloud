package cn.org.july.web.core.web.exception.user;

/**
 * 角色锁定异常类
 *
 * @author july
 */
public class RoleBlockedException extends UserException {
    public RoleBlockedException(String reason) {
        super("role.blocked", new Object[]{reason});
    }
}
