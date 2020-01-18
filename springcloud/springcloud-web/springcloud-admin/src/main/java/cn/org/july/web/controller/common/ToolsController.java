package cn.org.july.web.controller.common;

import cn.org.july.web.blog.domain.SysPdfFile;
import cn.org.july.web.common.base.AjaxResult;
import cn.org.july.web.common.config.Global;
import cn.org.july.web.common.utils.CompactAlgorithm;
import cn.org.july.web.common.utils.QRCodeUtils;
import cn.org.july.web.common.utils.StringUtils;
import cn.org.july.web.core.util.FileUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @author goodboy
 */
@Controller
public class ToolsController {
    /**
     * 用户目录
     */
    private static String HOME_PATH = System.getProperty("user.home");
    /**
     * 默认上传的地址
     */
    private static String defaultBaseDir = Global.getProfile();

    /**
     * 首页
     *
     * @return
     */
    @GetMapping({"/tool"})
    public String tool(HttpServletRequest request) {
        return "tool/QRcode/QRcode";
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping({"/tool/createCode"})
    @ResponseBody
    public AjaxResult createCode(HttpServletRequest request) throws Exception {
        AjaxResult ajax = new AjaxResult();
        String downCode = UUID.randomUUID().toString();
        String startStr = request.getParameter("start");
        String endStr = request.getParameter("end");
        String sizeStr = request.getParameter("size");
        System.out.println("二维码生成开始：" + startStr);
        System.out.println("二维码生成结束：" + endStr);
        System.out.println("二维码大小：" + sizeStr);
        int start = Integer.valueOf(startStr);
        int end = Integer.valueOf(endStr);
        int size = Integer.valueOf(sizeStr);
        //生成二维码
        while (start <= end) {
            String content = String.valueOf(start++);
            QRCodeUtils.encodeFileIsContent(content, size, getAbsoluteFile(downCode).getPath());
        }
        //压缩二维码
        File f = new File(getAbsoluteFile(downCode).getPath());
        new CompactAlgorithm(new File(getAbsoluteFile(downCode).getParent(), f.getName() + ".zip")).zipFiles(f);
        return ajax.put("downCode", downCode.concat(".zip"));
    }


    private static final File getAbsoluteFile(String filename) {
        File desc = new File(HOME_PATH.concat(defaultBaseDir).concat(File.separator) + filename);
        if (!desc.exists()) {
            desc.mkdirs();
        }
        return desc;
    }

}
