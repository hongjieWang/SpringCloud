package cn.org.july.web.blog.dao;


import cn.org.july.web.blog.domain.Blog;
import cn.org.july.web.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogMapper {
    int deleteByPrimaryKey(Long blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Long blogId);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

    /**
     * 查询博客列表
     *
     * @param blog 博客信息
     * @return 博客集合
     */
    List<Blog> selectTbBlogList(Blog blog);

    List<Blog> findBlogList(PageQueryUtil pageUtil);

    List<Blog> findBlogListByType(@Param("type") int type, @Param("limit") int limit);

    int getTotalBlogs(PageQueryUtil pageUtil);

    int deleteBatch(String[] ids);

    List<Blog> getBlogsPageByTagId(PageQueryUtil pageUtil);

    int getTotalBlogsByTagId(PageQueryUtil pageUtil);

    Blog selectBySubUrl(String subUrl);

    int updateBlogCategorys(@Param("categoryName") String categoryName, @Param("categoryId") Integer categoryId, @Param("ids") String[] ids);

}