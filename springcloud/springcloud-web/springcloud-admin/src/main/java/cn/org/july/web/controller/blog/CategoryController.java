package cn.org.july.web.controller.blog;


import cn.org.july.web.blog.domain.BlogCategory;
import cn.org.july.web.blog.service.CategoryService;
import cn.org.july.web.common.base.AjaxResult;
import cn.org.july.web.common.page.TableDataInfo;
import cn.org.july.web.common.support.Convert;
import cn.org.july.web.core.web.base.BaseController;
import cn.org.july.web.utils.PageQueryUtil;
import cn.org.july.web.utils.Result;
import cn.org.july.web.utils.ResultGenerator;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@Controller
@RequestMapping("/admin")
public class CategoryController extends BaseController {

    private static final String prefix = "blog/category";
    @Resource
    private CategoryService categoryService;


    @RequiresPermissions("category:tbBlogCategory:view")
    @GetMapping("/tbBlogCategory")
    public String categoryPage(HttpServletRequest request) {
        request.setAttribute("path", "categories");
        return prefix.concat("/tbBlogCategory");
    }

    /**
     * 新增打卡记录
     */
    @GetMapping("/category/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 修改打卡记录
     */
    @GetMapping("/category/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        BlogCategory blogCategory = categoryService.selectTbBlogCategoryById(id);
        mmap.put("tbBlogCategory", blogCategory);
        return prefix + "/edit";
    }

    /**
     * 查询博客分类列表
     */
    @RequiresPermissions("category:tbBlogCategory:list")
    @PostMapping("/category/list")
    @ResponseBody
    public TableDataInfo list(BlogCategory tbBlogCategory) {
        startPage();
        tbBlogCategory.setIsDeleted((byte) 0);
        List<BlogCategory> list = categoryService.selectTbBlogCategoryList(tbBlogCategory);
        return getDataTable(list);
    }

    /**
     * 分类列表
     */
    @RequestMapping(value = "/categories/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(categoryService.getBlogCategoryPage(pageUtil));
    }

    /**
     * 分类添加
     */
    @RequestMapping(value = "/categories/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult save(@RequestParam("categoryName") String categoryName,
                           @RequestParam("categoryIcon") String categoryIcon) {
        if (StringUtils.isEmpty(categoryName)) {
            return AjaxResult.error("请输入分类名称！");
        }
        if (StringUtils.isEmpty(categoryIcon)) {
            return AjaxResult.error("请选择分类图标！");
        }
        if (categoryService.saveCategory(categoryName, categoryIcon)) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error("分类名称重复");
        }
    }


    /**
     * 分类修改
     */
    @RequestMapping(value = "/category/exit", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult update(@RequestParam("categoryId") Integer categoryId,
                             @RequestParam("categoryName") String categoryName,
                             @RequestParam("categoryIcon") String categoryIcon) {
        if (StringUtils.isEmpty(categoryName)) {
            return AjaxResult.error("请输入分类名称！");
        }
        if (StringUtils.isEmpty(categoryIcon)) {
            return AjaxResult.error("请选择分类图标！");
        }
        if (categoryService.updateCategory(categoryId, categoryName, categoryIcon)) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error("分类名称重复");
        }
    }


    /**
     * 分类删除
     */
    @RequestMapping(value = "/category/remove", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult delete(String ids) {
        String[] dels = Convert.toStrArray(ids);
        if (dels.length < 1) {
            return AjaxResult.error("参数异常！");
        }
        if (categoryService.deleteBatch(dels)) {
            return AjaxResult.success();
        } else {
            return AjaxResult.error("删除失败");
        }
    }

}
