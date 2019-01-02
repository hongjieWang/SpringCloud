package cn.org.july.web.core.web.exception.user;

/**
 * 用户账号已被删除
 *
 * @author july
 */
public class UserDeleteException extends UserException {

    public UserDeleteException() {
        super("user.password.delete", null);
    }
}
