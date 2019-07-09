package cn.org.july.web.blog.service;


import cn.org.july.web.blog.domain.BlogCategory;
import cn.org.july.web.utils.PageQueryUtil;
import cn.org.july.web.utils.PageResult;

import java.util.List;

public interface CategoryService {

    /**
     * 查询分类的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogCategoryPage(PageQueryUtil pageUtil);

    /**
     * 查询博客分类列表
     *
     * @param tbBlogCategory 博客分类信息
     * @return 博客分类集合
     */
    List<BlogCategory> selectTbBlogCategoryList(BlogCategory tbBlogCategory);

    /**
     * 查询博客分类信息
     *
     * @param categoryId 博客分类ID
     * @return 博客分类信息
     */
    BlogCategory selectTbBlogCategoryById(Integer categoryId);

    int getTotalCategories();

    /**
     * 添加分类数据
     *
     * @param categoryName
     * @param categoryIcon
     * @return
     */
    Boolean saveCategory(String categoryName, String categoryIcon);

    Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon);

    Boolean deleteBatch(String[] ids);

    List<BlogCategory> getAllCategories();
}
