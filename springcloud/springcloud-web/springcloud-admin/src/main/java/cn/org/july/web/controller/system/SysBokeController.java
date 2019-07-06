package cn.org.july.web.controller.system;

import cn.org.july.web.attendance.domain.SysBoke;
import cn.org.july.web.attendance.service.ISysBokeService;
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
 * 博客技术 信息操作处理
 *
 * @author null
 * @date 2019-07-02
 */
@Controller
@RequestMapping("/business/sysBoke")
public class SysBokeController extends BaseController {
    private String prefix = "business/sysBoke";

    @Autowired
    private ISysBokeService sysBokeService;

    @RequiresPermissions("business:sysBoke:view")
    @GetMapping()
    public String sysBoke() {
        return prefix + "/sysBoke";
    }

    /**
     * 查询博客技术列表
     */
    @RequiresPermissions("business:sysBoke:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysBoke sysBoke) {
        startPage();
        List<SysBoke> list = sysBokeService.selectSysBokeList(sysBoke);
        return getDataTable(list);
    }


    /**
     * 导出博客技术列表
     */
    @RequiresPermissions("business:sysBoke:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysBoke sysBoke) {
        List<SysBoke> list = sysBokeService.selectSysBokeList(sysBoke);
        ExcelUtil<SysBoke> util = new ExcelUtil<SysBoke>(SysBoke.class);
        return util.exportExcel(list, "sysBoke");
    }

    /**
     * 新增博客技术
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 创建博客
     *
     * @return
     */
    @GetMapping("/write")
    public String writeBoke() {
        return prefix + "/write";
    }


    /**
     * 新增保存博客技术
     */
    @RequiresPermissions("business:sysBoke:add")
    @Log(title = "博客技术", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysBoke sysBoke) {
        return toAjax(sysBokeService.insertSysBoke(sysBoke));
    }

    /**
     * 修改博客技术
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        SysBoke sysBoke = sysBokeService.selectSysBokeById(id);
        mmap.put("sysBoke", sysBoke);
        return prefix + "/edit";
    }

    /**
     * 修改保存博客技术
     */
    @RequiresPermissions("business:sysBoke:edit")
    @Log(title = "博客技术", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysBoke sysBoke) {
        return toAjax(sysBokeService.updateSysBoke(sysBoke));
    }

    /**
     * 删除博客技术
     */
    @RequiresPermissions("business:sysBoke:remove")
    @Log(title = "博客技术", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysBokeService.deleteSysBokeByIds(ids));
    }

}
