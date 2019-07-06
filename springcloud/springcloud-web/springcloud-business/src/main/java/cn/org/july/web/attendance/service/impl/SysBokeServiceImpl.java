package cn.org.july.web.attendance.service.impl;


import cn.org.july.web.attendance.dao.SysBokeMapper;
import cn.org.july.web.attendance.domain.SysBoke;
import cn.org.july.web.attendance.service.ISysBokeService;
import cn.org.july.web.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 博客技术 服务层实现
 *
 * @author null
 * @date 2019-07-02
 */
@Service
public class SysBokeServiceImpl implements ISysBokeService {
    @Autowired
    private SysBokeMapper sysBokeMapper;

    /**
     * 查询博客技术信息
     *
     * @param id 博客技术ID
     * @return 博客技术信息
     */
    @Override
    public SysBoke selectSysBokeById(Integer id) {
        return sysBokeMapper.selectSysBokeById(id);
    }

    /**
     * 查询博客技术列表
     *
     * @param sysBoke 博客技术信息
     * @return 博客技术集合
     */
    @Override
    public List<SysBoke> selectSysBokeList(SysBoke sysBoke) {
        return sysBokeMapper.selectSysBokeList(sysBoke);
    }

    /**
     * 新增博客技术
     *
     * @param sysBoke 博客技术信息
     * @return 结果
     */
    @Override
    public int insertSysBoke(SysBoke sysBoke) {
        return sysBokeMapper.insertSysBoke(sysBoke);
    }

    /**
     * 修改博客技术
     *
     * @param sysBoke 博客技术信息
     * @return 结果
     */
    @Override
    public int updateSysBoke(SysBoke sysBoke) {
        return sysBokeMapper.updateSysBoke(sysBoke);
    }

    /**
     * 删除博客技术对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysBokeByIds(String ids) {
        return sysBokeMapper.deleteSysBokeByIds(Convert.toStrArray(ids));
    }

}
