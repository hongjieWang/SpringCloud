package cn.org.july.web.core.web.exception.user;

/**
 * 用户锁定异常类
 *
 * @author july
 */
public class UserBlockedException extends UserException {

    public UserBlockedException(String reason) {
        super("user.blocked", new Object[]{reason});
    }
}
