package cn.org.july.web.blog.dao;


import cn.org.july.web.blog.domain.BlogCategory;

import java.util.List;

/**
 * 博客分类 数据层
 *
 * @author null
 * @date 2019-07-07
 */
public interface TbBlogCategoryMapper {
    /**
     * 查询博客分类信息
     *
     * @param categoryId 博客分类ID
     * @return 博客分类信息
     */
    BlogCategory selectTbBlogCategoryById(Integer categoryId);

    /**
     * 查询博客分类列表
     *
     * @param tbBlogCategory 博客分类信息
     * @return 博客分类集合
     */
    List<BlogCategory> selectTbBlogCategoryList(BlogCategory tbBlogCategory);

    /**
     * 新增博客分类
     *
     * @param tbBlogCategory 博客分类信息
     * @return 结果
     */
    int insertTbBlogCategory(BlogCategory tbBlogCategory);

    /**
     * 修改博客分类
     *
     * @param tbBlogCategory 博客分类信息
     * @return 结果
     */
    int updateTbBlogCategory(BlogCategory tbBlogCategory);

    /**
     * 删除博客分类
     *
     * @param categoryId 博客分类ID
     * @return 结果
     */
    int deleteTbBlogCategoryById(Integer categoryId);

    /**
     * 批量删除博客分类
     *
     * @param categoryIds 需要删除的数据ID
     * @return 结果
     */
    int deleteTbBlogCategoryByIds(String[] categoryIds);

}