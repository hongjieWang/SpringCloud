package cn.org.july.web.service;

import cn.org.july.web.domain.SysAttendance;

import java.util.List;


/**
 * 打卡记录 服务层
 *
 * @author null
 * @date 2019-06-23
 */
public interface ISysAttendanceService {
    /**
     * 查询打卡记录信息
     *
     * @param id 打卡记录ID
     * @return 打卡记录信息
     */
    SysAttendance selectSysAttendanceById(Integer id);

    /**
     * 查询打卡记录列表
     *
     * @param sysAttendance 打卡记录信息
     * @return 打卡记录集合
     */
    List<SysAttendance> selectSysAttendanceList(SysAttendance sysAttendance);

    /**
     * 新增打卡记录
     *
     * @param sysAttendance 打卡记录信息
     * @return 结果
     */
    int insertSysAttendance(SysAttendance sysAttendance);

    /**
     * 修改打卡记录
     *
     * @param sysAttendance 打卡记录信息
     * @return 结果
     */
    int updateSysAttendance(SysAttendance sysAttendance);

    /**
     * 删除打卡记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSysAttendanceByIds(String ids);

}
