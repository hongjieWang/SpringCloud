package cn.org.july.web.attendance.service.impl;

import cn.org.july.web.attendance.dao.SysProjectMapper;
import cn.org.july.web.attendance.domain.SysProject;
import cn.org.july.web.attendance.service.ISysProjectService;
import cn.org.july.web.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 项目管理 服务层实现
 *
 * @author null
 * @date 2019-06-26
 */
@Service
public class SysProjectServiceImpl implements ISysProjectService {
    @Autowired
    private SysProjectMapper sysProjectMapper;

    /**
     * 查询项目管理信息
     *
     * @param id 项目管理ID
     * @return 项目管理信息
     */
    @Override
    public SysProject selectSysProjectById(Integer id) {
        return sysProjectMapper.selectSysProjectById(id);
    }

    /**
     * 查询项目管理列表
     *
     * @param sysProject 项目管理信息
     * @return 项目管理集合
     */
    @Override
    public List<SysProject> selectSysProjectList(SysProject sysProject) {
        return sysProjectMapper.selectSysProjectList(sysProject);
    }

    /**
     * 新增项目管理
     *
     * @param sysProject 项目管理信息
     * @return 结果
     */
    @Override
    public int insertSysProject(SysProject sysProject) {
        return sysProjectMapper.insertSysProject(sysProject);
    }

    /**
     * 修改项目管理
     *
     * @param sysProject 项目管理信息
     * @return 结果
     */
    @Override
    public int updateSysProject(SysProject sysProject) {
        return sysProjectMapper.updateSysProject(sysProject);
    }

    /**
     * 删除项目管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysProjectByIds(String ids) {
        return sysProjectMapper.deleteSysProjectByIds(Convert.toStrArray(ids));
    }

}
