package cn.org.july.web.system.service;

import cn.org.july.web.system.entitis.SysLoginInfo;

import java.util.List;


/**
 * 系统访问日志情况信息 服务层
 *
 * @author july
 */
public interface ISysLoginInfoService {
    /**
     * 新增系统登录日志
     *
     * @param loginInfo 访问日志对象
     */
    void insertLoginInfo(SysLoginInfo loginInfo);

    /**
     * 查询系统登录日志集合
     *
     * @param loginInfo 访问日志对象
     * @return 登录记录集合
     */
    List<SysLoginInfo> selectLoginInfoList(SysLoginInfo loginInfo);

    /**
     * 批量删除系统登录日志
     *
     * @param ids 需要删除的数据
     * @return
     */
    int deleteLoginInfoByIds(String ids);

    /**
     * 清空系统登录日志
     */
    void cleanLoginInfo();
}
