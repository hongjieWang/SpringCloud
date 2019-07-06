package cn.org.july.web.controller.system;

import cn.org.july.web.attendance.domain.SysProject;
import cn.org.july.web.attendance.service.ISysProjectService;
import cn.org.july.web.common.annotation.Log;
import cn.org.july.web.common.base.AjaxResult;
import cn.org.july.web.common.enums.BusinessType;
import cn.org.july.web.common.page.TableDataInfo;
import cn.org.july.web.common.utils.ExcelUtil;
import cn.org.july.web.core.web.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * 项目管理 信息操作处理
 *
 * @author null
 * @date 2019-06-26
 */
@Controller
@RequestMapping("/business/sysProject")
public class SysProjectController extends BaseController {
    private String prefix = "business/sysProject";

    @Autowired
    private ISysProjectService sysProjectService;

    @RequiresPermissions("business:sysProject:view")
    @GetMapping()
    public String sysProject() {
        return prefix + "/sysProject";
    }

    /**
     * 查询项目管理列表
     */
    @RequiresPermissions("business:sysProject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysProject sysProject) {
        startPage();
        List<SysProject> list = sysProjectService.selectSysProjectList(sysProject);
        return getDataTable(list);
    }


    /**
     * 导出项目管理列表
     */
    @RequiresPermissions("business:sysProject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysProject sysProject) {
        List<SysProject> list = sysProjectService.selectSysProjectList(sysProject);
        ExcelUtil<SysProject> util = new ExcelUtil<SysProject>(SysProject.class);
        return util.exportExcel(list, "sysProject");
    }

    /**
     * 新增项目管理
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存项目管理
     */
    @RequiresPermissions("business:sysProject:add")
    @Log(title = "项目管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysProject sysProject) {
        if (sysProject.getStatus().equals("on")) {
            sysProject.setStatus("1");
        } else {
            sysProject.setStatus("0");
        }
        return toAjax(sysProjectService.insertSysProject(sysProject));
    }

    /**
     * 修改项目管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        SysProject sysProject = sysProjectService.selectSysProjectById(id);
        mmap.put("sysProject", sysProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目管理
     */
    @RequiresPermissions("business:sysProject:edit")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysProject sysProject) {
        if (sysProject.getStatus().equals("on")) {
            sysProject.setStatus("1");
        } else {
            sysProject.setStatus("0");
        }
        return toAjax(sysProjectService.updateSysProject(sysProject));
    }

    /**
     * 删除项目管理
     */
    @RequiresPermissions("business:sysProject:remove")
    @Log(title = "项目管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysProjectService.deleteSysProjectByIds(ids));
    }

}
