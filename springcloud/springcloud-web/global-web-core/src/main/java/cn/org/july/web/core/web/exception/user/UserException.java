package cn.org.july.web.core.web.exception.user;


import cn.org.july.web.core.web.exception.base.BaseException;

/**
 * 用户信息异常类
 *
 * @author july
 */
public class UserException extends BaseException {

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
