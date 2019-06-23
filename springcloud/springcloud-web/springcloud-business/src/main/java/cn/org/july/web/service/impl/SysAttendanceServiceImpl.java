package cn.org.july.web.service.impl;

import cn.org.july.web.common.support.Convert;
import cn.org.july.web.domain.SysAttendance;
import cn.org.july.web.dao.SysAttendanceMapper;
import cn.org.july.web.service.ISysAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 打卡记录 服务层实现
 *
 * @author null
 * @date 2019-06-23
 */
@Service
public class SysAttendanceServiceImpl implements ISysAttendanceService {
    @Autowired
    private SysAttendanceMapper sysAttendanceMapper;

    /**
     * 查询打卡记录信息
     *
     * @param id 打卡记录ID
     * @return 打卡记录信息
     */
    @Override
    public SysAttendance selectSysAttendanceById(Integer id) {
        return sysAttendanceMapper.selectSysAttendanceById(id);
    }

    /**
     * 查询打卡记录列表
     *
     * @param sysAttendance 打卡记录信息
     * @return 打卡记录集合
     */
    @Override
    public List<SysAttendance> selectSysAttendanceList(SysAttendance sysAttendance) {
        return sysAttendanceMapper.selectSysAttendanceList(sysAttendance);
    }

    /**
     * 新增打卡记录
     *
     * @param sysAttendance 打卡记录信息
     * @return 结果
     */
    @Override
    public int insertSysAttendance(SysAttendance sysAttendance) {
        return sysAttendanceMapper.insertSysAttendance(sysAttendance);
    }

    /**
     * 修改打卡记录
     *
     * @param sysAttendance 打卡记录信息
     * @return 结果
     */
    @Override
    public int updateSysAttendance(SysAttendance sysAttendance) {
        return sysAttendanceMapper.updateSysAttendance(sysAttendance);
    }

    /**
     * 删除打卡记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysAttendanceByIds(String ids) {
        return sysAttendanceMapper.deleteSysAttendanceByIds(Convert.toStrArray(ids));
    }

}
