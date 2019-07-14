package cn.org.july.web.controller.monitor;


import cn.org.july.web.core.web.base.BaseController;
import cn.org.july.web.core.web.domain.Server;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 服务器监控
 *
 * @author july
 */
@Controller
@RequestMapping("/monitor/server")
public class ServerController extends BaseController {
    private String prefix = "monitor/server";

    @Resource
    private CacheManager cacheManager;

    @RequiresPermissions("monitor:server:view")
    @GetMapping()
    public String server(ModelMap mmap) throws Exception {
        Server server = new Server();
        Cache<Object, Object> cache = cacheManager.getCache("myBlogNumber");
        int number = (int) cache.get("number");
        server.setNumber(number);
        server.copyTo();
        mmap.put("server", server);
        System.out.println("访问数量：" + number);
        return prefix + "/server";
    }
}
