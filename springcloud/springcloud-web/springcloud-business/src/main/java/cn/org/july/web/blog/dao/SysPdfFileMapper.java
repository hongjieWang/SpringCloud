package cn.org.july.web.blog.dao;

import cn.org.july.web.blog.domain.SysPdfFile;

import java.util.List;

/**
 * 文件管理 数据层
 *
 * @author null
 * @date 2019-07-07
 */
public interface SysPdfFileMapper {
    /**
     * 查询文件管理信息
     *
     * @param id 文件管理ID
     * @return 文件管理信息
     */
    SysPdfFile selectSysFileById(Integer id);

    /**
     * 查询文件管理列表
     *
     * @param sysPdfFile 文件管理信息
     * @return 文件管理集合
     */
    List<SysPdfFile> selectSysFileList(SysPdfFile sysPdfFile);

    /**
     * 新增文件管理
     *
     * @param sysPdfFile 文件管理信息
     * @return 结果
     */
    int insertSysFile(SysPdfFile sysPdfFile);

    /**
     * 修改文件管理
     *
     * @param sysPdfFile 文件管理信息
     * @return 结果
     */
    int updateSysFile(SysPdfFile sysPdfFile);

    /**
     * 删除文件管理
     *
     * @param id 文件管理ID
     * @return 结果
     */
    int deleteSysFileById(Integer id);

    /**
     * 批量删除文件管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteSysFileByIds(String[] ids);

}