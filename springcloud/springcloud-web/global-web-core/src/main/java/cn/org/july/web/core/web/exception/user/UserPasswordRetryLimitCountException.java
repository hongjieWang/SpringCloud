package cn.org.july.web.core.web.exception.user;

/**
 * 用户错误记数异常类
 *
 * @author july
 */
public class UserPasswordRetryLimitCountException extends UserException {
    public UserPasswordRetryLimitCountException(int retryLimitCount) {
        super("user.password.retry.limit.count", new Object[]{retryLimitCount});
    }
}
