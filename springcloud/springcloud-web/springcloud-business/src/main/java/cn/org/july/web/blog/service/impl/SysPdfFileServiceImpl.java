package cn.org.july.web.blog.service.impl;

import cn.org.july.web.blog.dao.SysPdfFileMapper;
import cn.org.july.web.blog.domain.SysPdfFile;
import cn.org.july.web.blog.service.ISysPdfFileService;
import cn.org.july.web.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 文件管理 服务层实现
 *
 * @author null
 * @date 2019-07-07
 */
@Service
public class SysPdfFileServiceImpl implements ISysPdfFileService {
    @Autowired
    private SysPdfFileMapper sysPdfFileMapper;

    /**
     * 查询文件管理信息
     *
     * @param id 文件管理ID
     * @return 文件管理信息
     */
    @Override
    public SysPdfFile selectSysFileById(Integer id) {
        return sysPdfFileMapper.selectSysFileById(id);
    }

    /**
     * 查询文件管理列表
     *
     * @param sysPdfFile 文件管理信息
     * @return 文件管理集合
     */
    @Override
    public List<SysPdfFile> selectSysFileList(SysPdfFile sysPdfFile) {
        return sysPdfFileMapper.selectSysFileList(sysPdfFile);
    }

    /**
     * 新增文件管理
     *
     * @param sysPdfFile 文件管理信息
     * @return 结果
     */
    @Override
    public int insertSysFile(SysPdfFile sysPdfFile) {
        return sysPdfFileMapper.insertSysFile(sysPdfFile);
    }

    /**
     * 修改文件管理
     *
     * @param sysPdfFile 文件管理信息
     * @return 结果
     */
    @Override
    public int updateSysFile(SysPdfFile sysPdfFile) {
        return sysPdfFileMapper.updateSysFile(sysPdfFile);
    }

    /**
     * 删除文件管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysFileByIds(String ids) {
        return sysPdfFileMapper.deleteSysFileByIds(Convert.toStrArray(ids));
    }

}
