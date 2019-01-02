package cn.org.july.web.core.web.exception.user;

/**
 * 验证码错误异常类
 *
 * @author july
 */
public class CaptchaException extends UserException {

    public CaptchaException() {
        super("user.jcaptcha.error", null);
    }
}
