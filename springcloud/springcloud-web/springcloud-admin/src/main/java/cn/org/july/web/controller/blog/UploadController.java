package cn.org.july.web.controller.blog;


import cn.org.july.web.blog.domain.SysPdfFile;
import cn.org.july.web.blog.service.ISysPdfFileService;
import cn.org.july.web.common.base.AjaxResult;
import cn.org.july.web.common.utils.StringUtils;
import cn.org.july.web.core.util.FileUploadUtils;
import cn.org.july.web.utils.MyBlogUtils;
import cn.org.july.web.utils.Result;
import cn.org.july.web.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@Controller
public class UploadController {

    @Autowired
    private ISysPdfFileService sysPdfFileService;

    @PostMapping({"/upload/file"})
    @ResponseBody
    public Result upload(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) throws URISyntaxException {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        File fileDirectory = new File(FileUploadUtils.getDefaultBaseDir());
        //创建文件
        File destFile = new File(FileUploadUtils.getDefaultBaseDir() + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Result result = ResultGenerator.genSuccessResult();
        result.setData(MyBlogUtils.getHost(new URI(httpServletRequest.getRequestURL() + "")) + "/upload/" + newFileName);
        return result;
    }

    @GetMapping("/download/{fileName}")
    public void downLoad(@PathVariable("fileName") String fileName, HttpServletRequest request, String path, HttpServletResponse response) throws IOException {
        File destFile = null;
        if (StringUtils.isNotEmpty(path)) {
            destFile = new File(FileUploadUtils.getDefaultBaseDir().concat(File.separator).concat(path).concat(File.separator) + fileName);
        } else {
            destFile = new File(FileUploadUtils.getDefaultBaseDir() + fileName);
        }
        if (destFile.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(destFile);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @GetMapping("/downloadPdfFile/{fileName}")
    @ResponseBody
    public AjaxResult downLoadPdfFile(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SysPdfFile sysPdfFile = null;
        try {
            if (StringUtils.isNotEmpty(id)) {
                sysPdfFile = sysPdfFileService.selectSysFileById(Integer.valueOf(id));
            }
            if (null == sysPdfFile) {
                AjaxResult.error("文件索引错误");
            }
            if (!sysPdfFile.getIsStatus()) {
                return AjaxResult.error("文件不允许下载");
            }
            if (sysPdfFile.getDownloadNumber() > 100) {
                return AjaxResult.error("文件下载次数超限制");
            }
            sysPdfFile.setDownloadNumber(sysPdfFile.getDownloadNumber() + 1);
            sysPdfFileService.updateSysFile(sysPdfFile);
            this.downLoad(fileName, request, FileUploadUtils.PDFFILEPATH, response);
            return null;
        } catch (Exception e) {
            return AjaxResult.error("服务器异常：" + e);
        }
    }

}
