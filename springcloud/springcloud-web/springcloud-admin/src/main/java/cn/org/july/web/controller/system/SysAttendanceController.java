package cn.org.july.web.controller.system;

import cn.org.july.web.common.annotation.Log;
import cn.org.july.web.common.base.AjaxResult;
import cn.org.july.web.common.enums.BusinessType;
import cn.org.july.web.common.page.TableDataInfo;
import cn.org.july.web.common.utils.ExcelUtil;
import cn.org.july.web.core.web.base.BaseController;
import cn.org.july.web.domain.SysAttendance;
import cn.org.july.web.service.ISysAttendanceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * 打卡记录 信息操作处理
 *
 * @author null
 * @date 2019-06-23
 */
@Controller
@RequestMapping("/business/sysAttendance")
public class SysAttendanceController extends BaseController {
    private String prefix = "business/sysAttendance";

    @Autowired
    private ISysAttendanceService sysAttendanceService;

    @RequiresPermissions("null:sysAttendance:view")
    @GetMapping()
    public String sysAttendance() {
        return prefix + "/sysAttendance";
    }

    /**
     * 查询打卡记录列表
     */
    @RequiresPermissions("business:sysAttendance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysAttendance sysAttendance) {
        startPage();
        List<SysAttendance> list = sysAttendanceService.selectSysAttendanceList(sysAttendance);
        return getDataTable(list);
    }

    @RequiresPermissions("business:sysAttendance:add")
    @PostMapping("/daka")
    @ResponseBody
    public AjaxResult daka(SysAttendance sysAttendance) {
        sysAttendance.setClockEndTime(new Date());
        sysAttendance.setUserName(getLoginName());
        sysAttendance.setAttendanceName(getSysUser().getDept().getDeptName());
        return toAjax(sysAttendanceService.insertSysAttendance(sysAttendance));
    }

    /**
     *
     * @return
     */
    @GetMapping("/getdaka")
    public String adddaka() {
        return prefix + "/daka";
    }

    /**
     * 导出打卡记录列表
     */
    @RequiresPermissions("business:sysAttendance:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysAttendance sysAttendance) {
        List<SysAttendance> list = sysAttendanceService.selectSysAttendanceList(sysAttendance);
        ExcelUtil<SysAttendance> util = new ExcelUtil<SysAttendance>(SysAttendance.class);
        return util.exportExcel(list, "sysAttendance");
    }

    /**
     * 新增打卡记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存打卡记录
     */
    @RequiresPermissions("business:sysAttendance:add")
    @Log(title = "打卡记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysAttendance sysAttendance) {
        return toAjax(sysAttendanceService.insertSysAttendance(sysAttendance));
    }

    /**
     * 修改打卡记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        SysAttendance sysAttendance = sysAttendanceService.selectSysAttendanceById(id);
        mmap.put("sysAttendance", sysAttendance);
        return prefix + "/edit";
    }

    /**
     * 修改保存打卡记录
     */
    @RequiresPermissions("business:sysAttendance:edit")
    @Log(title = "打卡记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysAttendance sysAttendance) {
        return toAjax(sysAttendanceService.updateSysAttendance(sysAttendance));
    }

    /**
     * 删除打卡记录
     */
    @RequiresPermissions("business:sysAttendance:remove")
    @Log(title = "打卡记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysAttendanceService.deleteSysAttendanceByIds(ids));
    }

}
