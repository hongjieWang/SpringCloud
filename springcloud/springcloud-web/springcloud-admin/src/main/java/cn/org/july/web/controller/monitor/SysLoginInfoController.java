package cn.org.july.web.controller.monitor;


import cn.org.july.web.common.annotation.Log;
import cn.org.july.web.common.base.AjaxResult;
import cn.org.july.web.common.enums.BusinessType;
import cn.org.july.web.common.page.TableDataInfo;
import cn.org.july.web.common.utils.ExcelUtil;
import cn.org.july.web.core.web.base.BaseController;
import cn.org.july.web.system.entitis.SysLoginInfo;
import cn.org.july.web.system.service.ISysLoginInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 系统访问记录
 *
 * @author july
 */
@Controller
@RequestMapping("/monitor/loginInfo")
public class SysLoginInfoController extends BaseController {
    private String prefix = "monitor/loginInfo";

    @Autowired
    private ISysLoginInfoService loginInfoService;

    @RequiresPermissions("monitor:loginInfo:view")
    @GetMapping()
    public String loginInfo() {
        return prefix + "/loginInfo";
    }

    @RequiresPermissions("monitor:loginInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysLoginInfo loginInfo) {
        startPage();
        List<SysLoginInfo> list = loginInfoService.selectLoginInfoList(loginInfo);
        return getDataTable(list);
    }

    @Log(title = "登陆日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("monitor:loginInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysLoginInfo loginInfo) {
        List<SysLoginInfo> list = loginInfoService.selectLoginInfoList(loginInfo);
        ExcelUtil<SysLoginInfo> util = new ExcelUtil<>(SysLoginInfo.class);
        return util.exportExcel(list, "loginInfo");
    }

    @RequiresPermissions("monitor:loginInfo:remove")
    @Log(title = "登陆日志", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(loginInfoService.deleteLoginInfoByIds(ids));
    }

    @RequiresPermissions("monitor:loginInfo:remove")
    @Log(title = "登陆日志", businessType = BusinessType.CLEAN)
    @PostMapping("/clean")
    @ResponseBody
    public AjaxResult clean() {
        loginInfoService.cleanLoginInfo();
        return success();
    }
}
