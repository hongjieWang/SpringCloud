package cn.org.july.web.controller.system;

import cn.org.july.web.common.annotation.Log;
import cn.org.july.web.common.base.AjaxResult;
import cn.org.july.web.common.enums.BusinessType;
import cn.org.july.web.common.page.TableDataInfo;
import cn.org.july.web.common.utils.ExcelUtil;
import cn.org.july.web.core.web.base.BaseController;
import cn.org.july.web.domain.SysAttendance;
import cn.org.july.web.domain.SysProject;
import cn.org.july.web.service.ISysAttendanceService;
import cn.org.july.web.service.ISysProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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

    @Autowired
    private ISysProjectService sysProjectService;

    @RequiresPermissions("business:sysAttendance:view")
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
        if (1L != getSysUser().getUserId()) {
            sysAttendance.setUserId(getSysUser().getUserId().intValue());
        }
        List<SysAttendance> list = sysAttendanceService.selectSysAttendanceList(sysAttendance);
        return getDataTable(list);
    }

    @RequiresPermissions("business:sysAttendance:add")
    @PostMapping("/daka")
    @ResponseBody
    public AjaxResult daka(SysAttendance sysAttendance) {
        sysAttendance.setClockEndTime(new Date());
        sysAttendance.setUserName(getLoginName());
        sysAttendance.setUserId(getSysUser().getUserId().intValue());
        sysAttendance.setAttendanceName(getSysUser().getDept().getDeptName());
        isInDate(sysAttendance);
        return toAjax(sysAttendanceService.insertSysAttendance(sysAttendance));
    }

    /**
     * @return
     */
    @GetMapping("/getdaka")
    public String adddaka(ModelMap mmap) {
        SysProject sysProject = new SysProject();
        sysProject.setStatus("1");
        List<SysProject> sysProjectList = sysProjectService.selectSysProjectList(sysProject);
        mmap.put("sysProjectList", sysProjectList);
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


    public static SysAttendance isInDate(SysAttendance sysAttendance) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(sysAttendance.getClockEndTime());
        // 截取当前时间时分秒
        int strDateH = Integer.parseInt(strDate.substring(11, 13));
        int fan = 19;
        int car = 20;
        int rest = 21;
        if (strDateH >= fan && strDateH < car) {
            sysAttendance.setSubsidizedMeals("1");
            sysAttendance.setTraffic("0");
            sysAttendance.setPaidLeave("0");
        } else if (strDateH >= car && strDateH < rest) {
            sysAttendance.setSubsidizedMeals("1");
            sysAttendance.setTraffic("1");
            sysAttendance.setPaidLeave("0");
        } else if (strDateH >= rest) {
            sysAttendance.setSubsidizedMeals("1");
            sysAttendance.setTraffic("1");
            sysAttendance.setPaidLeave("1");
        }
        return sysAttendance;
    }


}
