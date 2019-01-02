package cn.org.july.web.system.service.impl;

import java.util.List;

import cn.org.july.web.common.support.Convert;
import cn.org.july.web.system.dao.SysLoginInfoDao;
import cn.org.july.web.system.entitis.SysLoginInfo;
import cn.org.july.web.system.service.ISysLoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 系统访问日志情况信息 服务层处理
 *
 * @author july
 */
@Service
public class SysLoginInfoServiceImpl implements ISysLoginInfoService {

    @Autowired
    private SysLoginInfoDao loginInfoDao;

    /**
     * 新增系统登录日志
     *
     * @param loginInfo 访问日志对象
     */
    @Override
    public void insertLoginInfo(SysLoginInfo loginInfo) {
        loginInfoDao.insertLoginInfo(loginInfo);
    }

    /**
     * 查询系统登录日志集合
     *
     * @param loginInfo 访问日志对象
     * @return 登录记录集合
     */
    @Override
    public List<SysLoginInfo> selectLoginInfoList(SysLoginInfo loginInfo) {
        return loginInfoDao.selectLoginInfoList(loginInfo);
    }

    /**
     * 批量删除系统登录日志
     *
     * @param ids 需要删除的数据
     * @return
     */
    @Override
    public int deleteLoginInfoByIds(String ids) {
        return loginInfoDao.deleteLoginInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 清空系统登录日志
     */
    @Override
    public void cleanLoginInfo() {
        loginInfoDao.cleanLoginInfo();
    }
}
