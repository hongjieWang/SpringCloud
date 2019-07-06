package cn.org.july.web.attendance.service;

import cn.org.july.web.attendance.domain.SysBoke;

import java.util.List;

/**
 * 博客技术 服务层
 *
 * @author null
 * @date 2019-07-02
 */
public interface ISysBokeService {
    /**
     * 查询博客技术信息
     *
     * @param id 博客技术ID
     * @return 博客技术信息
     */
    SysBoke selectSysBokeById(Integer id);

    /**
     * 查询博客技术列表
     *
     * @param sysBoke 博客技术信息
     * @return 博客技术集合
     */
    List<SysBoke> selectSysBokeList(SysBoke sysBoke);

    /**
     * 新增博客技术
     *
     * @param sysBoke 博客技术信息
     * @return 结果
     */
    int insertSysBoke(SysBoke sysBoke);

    /**
     * 修改博客技术
     *
     * @param sysBoke 博客技术信息
     * @return 结果
     */
    int updateSysBoke(SysBoke sysBoke);

    /**
     * 删除博客技术信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSysBokeByIds(String ids);

}
