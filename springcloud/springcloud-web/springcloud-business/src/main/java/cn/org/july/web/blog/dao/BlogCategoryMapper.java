package cn.org.july.web.blog.dao;


import cn.org.july.web.blog.domain.BlogCategory;
import cn.org.july.web.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(BlogCategory record);

    int insertSelective(BlogCategory record);

    BlogCategory selectByPrimaryKey(Integer categoryId);

    BlogCategory selectByCategoryName(String categoryName);

    int updateByPrimaryKeySelective(BlogCategory record);

    int updateByPrimaryKey(BlogCategory record);

    List<BlogCategory> findCategoryList(PageQueryUtil pageUtil);

    List<BlogCategory> selectByCategoryIds(@Param("categoryIds") List<Integer> categoryIds);

    int getTotalCategories(PageQueryUtil pageUtil);

    int deleteBatch(String[] ids);

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
}