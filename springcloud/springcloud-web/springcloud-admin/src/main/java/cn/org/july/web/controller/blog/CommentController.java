package cn.org.july.web.controller.blog;


import cn.org.july.web.blog.domain.BlogComment;
import cn.org.july.web.blog.service.CommentService;
import cn.org.july.web.common.base.AjaxResult;
import cn.org.july.web.common.page.TableDataInfo;
import cn.org.july.web.common.support.Convert;
import cn.org.july.web.core.web.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@Controller
@RequestMapping("/admin")
public class CommentController extends BaseController {

    private String prefix = "blog/tbBlogComment";

    @Resource
    private CommentService commentService;


    @RequiresPermissions("comments:tbBlogComment:view")
    @GetMapping("/tbBlogComment")
    public String tbBlogComment() {
        return prefix + "/tbBlogComment";
    }

    /**
     * 查询博客评论列表
     */
    @RequiresPermissions("comments:tbBlogComment:list")
    @PostMapping("comments/list")
    @ResponseBody
    public TableDataInfo list(BlogComment tbBlogComment) {
        startPage();
        tbBlogComment.setIsDeleted((byte) 0);
        List<BlogComment> list = commentService.selectTbBlogCommentList(tbBlogComment);
        return getDataTable(list);
    }

    /**
     * 修改博客评论
     */
    @GetMapping("/comments/edit/{commentId}")
    public String edit(@PathVariable("commentId") Long commentId, ModelMap mmap) {
        BlogComment tbBlogComment = new BlogComment();
        tbBlogComment.setCommentId(commentId);
        mmap.put("tbBlogComment", tbBlogComment);
        return prefix + "/edit";
    }


    @GetMapping("/comments/checkDone")
    @ResponseBody
    public AjaxResult checkDone(Integer[] ids) {
        if (ids.length < 1) {
            return AjaxResult.error("参数异常！");
        }
        if (commentService.checkDone(ids)) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error("审核失败");
        }
    }

    @PostMapping("/comments/reply")
    @ResponseBody
    public AjaxResult checkDone(@RequestParam("commentId") Long commentId,
                                @RequestParam("replyBody") String replyBody) {
        if (commentId == null || commentId < 1 || StringUtils.isEmpty(replyBody)) {
            return AjaxResult.error("参数异常！");
        }
        if (commentService.reply(commentId, replyBody)) {
            return AjaxResult.success();
        } else {
            return AjaxResult.success("回复失败");
        }
    }

    @PostMapping("/comments/remove")
    @ResponseBody
    public AjaxResult delete(String ids) {
        String[] dels = Convert.toStrArray(ids);
        if (dels.length < 1) {
            return AjaxResult.error("参数异常！");
        }
        if (commentService.deleteBatch(dels)) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error("刪除失败");
        }
    }

    @GetMapping("/comments")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "comments");
        return "admin/comment";
    }


}
