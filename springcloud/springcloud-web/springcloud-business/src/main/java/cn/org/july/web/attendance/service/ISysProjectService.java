package cn.org.july.web.attendance.service;

import cn.org.july.web.attendance.domain.SysProject;

import java.util.List;

/**
 * 项目管理 服务层
 * 
 * @author null
 * @date 2019-06-26
 */
public interface ISysProjectService 
{
	/**
     * 查询项目管理信息
     * 
     * @param id 项目管理ID
     * @return 项目管理信息
     */
	SysProject selectSysProjectById(Integer id);
	
	/**
     * 查询项目管理列表
     * 
     * @param sysProject 项目管理信息
     * @return 项目管理集合
     */
	List<SysProject> selectSysProjectList(SysProject sysProject);
	
	/**
     * 新增项目管理
     * 
     * @param sysProject 项目管理信息
     * @return 结果
     */
	int insertSysProject(SysProject sysProject);
	
	/**
     * 修改项目管理
     * 
     * @param sysProject 项目管理信息
     * @return 结果
     */
	int updateSysProject(SysProject sysProject);
		
	/**
     * 删除项目管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteSysProjectByIds(String ids);
	
}
