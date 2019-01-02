package cn.org.july.web.core.web.exception.user;

/**
 * 用户密码不正确或不符合规范异常类
 *
 * @author july
 */
public class UserPasswordNotMatchException extends UserException {
    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
