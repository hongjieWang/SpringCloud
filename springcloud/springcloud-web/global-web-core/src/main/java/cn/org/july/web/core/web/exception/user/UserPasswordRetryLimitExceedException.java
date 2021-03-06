package cn.org.july.web.core.web.exception.user;

/**
 * 用户错误最大次数异常类
 *
 * @author july
 */
public class UserPasswordRetryLimitExceedException extends UserException {

    public UserPasswordRetryLimitExceedException(int retryLimitCount) {
        super("user.password.retry.limit.exceed", new Object[]{retryLimitCount});
    }
}
