package cn.org.july.web.controller.blog;


import cn.org.july.web.blog.domain.SysPdfFile;
import cn.org.july.web.blog.service.ISysPdfFileService;
import cn.org.july.web.common.annotation.Log;
import cn.org.july.web.common.base.AjaxResult;
import cn.org.july.web.common.enums.BusinessType;
import cn.org.july.web.common.page.TableDataInfo;
import cn.org.july.web.common.utils.ExcelUtil;
import cn.org.july.web.core.util.FileUploadUtils;
import cn.org.july.web.core.web.base.BaseController;
import cn.org.july.web.utils.MyBlogUtils;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 文件管理 信息操作处理
 *
 * @author null
 * @date 2019-07-07
 */
@Controller
@RequestMapping("/blog/sysFile")
public class SysFileController extends BaseController {
    private String prefix = "blog/sysFile";

    @Autowired
    private ISysPdfFileService sysFileService;

    @RequiresPermissions("blog:sysFile:view")
    @GetMapping()
    public String sysFile() {
        return prefix + "/sysFile";
    }

    /**
     * 查询文件管理列表
     */
    @RequiresPermissions("blog:sysFile:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysPdfFile sysPdfFile) {
        startPage();
        List<SysPdfFile> list = sysFileService.selectSysFileList(sysPdfFile);
        return getDataTable(list);
    }


    /**
     * 导出文件管理列表
     */
    @RequiresPermissions("blog:sysFile:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysPdfFile sysPdfFile) {
        List<SysPdfFile> list = sysFileService.selectSysFileList(sysPdfFile);
        ExcelUtil<SysPdfFile> util = new ExcelUtil<SysPdfFile>(SysPdfFile.class);
        return util.exportExcel(list, "sysPdfFile");
    }

    /**
     * 新增文件管理
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存文件管理
     */
    @RequiresPermissions("blog:sysFile:add")
    @Log(title = "文件管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam(name = "file", required = true)
                                      MultipartFile file, HttpServletRequest request) throws IOException, URISyntaxException {
        String pdfName = request.getParameter("pdfName");
        if (file.isEmpty()) {
            return AjaxResult.error("文件上传失败");
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        StringBuilder tempName = new StringBuilder();
        Random r = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        //创建文件
        File destFile = new File(FileUploadUtils.getDefaultBaseDir().concat(FileUploadUtils.PDFFILEPATH).concat(File.separator) + newFileName);
        String fileUrl = MyBlogUtils.getHost(new URI(request.getRequestURL() + "")) + "/downloadPdfFile/" + newFileName;
        File fileDirectory = new File(FileUploadUtils.getDefaultBaseDir().concat(FileUploadUtils.PDFFILEPATH).concat(File.separator));
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.transferTo(destFile);
        SysPdfFile sysPdfFile = new SysPdfFile();
        sysPdfFile.setPdfName(pdfName);
        sysPdfFile.setPdfLoaclUrl(destFile.getPath());
        sysPdfFile.setPdfType(suffixName);
        sysPdfFile.setUserId(getSysUser().getUserId().intValue());
        sysPdfFile.setPdfDownLoadUrl(fileUrl);
        return toAjax(sysFileService.insertSysFile(sysPdfFile));
    }

    /**
     * 修改文件管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        SysPdfFile sysPdfFile = sysFileService.selectSysFileById(id);
        mmap.put("sysPdfFile", sysPdfFile);
        return prefix + "/edit";
    }

    /**
     * 修改保存文件管理
     */
    @RequiresPermissions("blog:sysFile:edit")
    @Log(title = "文件管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysPdfFile sysPdfFile) {
        return toAjax(sysFileService.updateSysFile(sysPdfFile));
    }

    /**
     * 删除文件管理
     * 删除文件管理
     * 删除文件管理
     */
    @RequiresPermissions("blog:sysFile:remove")
    @Log(title = "文件管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        String[] delIds = ids.split(",");
        for (String id : delIds) {
            SysPdfFile pdfFile = sysFileService.selectSysFileById(Integer.valueOf(id));
            FileUtils.deleteQuietly(new File(pdfFile.getPdfLoaclUrl()));
        }
        return toAjax(sysFileService.deleteSysFileByIds(ids));
    }

}
