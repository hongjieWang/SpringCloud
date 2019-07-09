package cn.org.july.web.blog.dao;

import cn.org.july.web.blog.domain.BlogTag;

import java.util.List;

/**
 * 博客标签 数据层
 *
 * @author null
 * @date 2019-07-07
 */
public interface TbBlogTagMapper {
    /**
     * 查询博客标签信息
     *
     * @param tagId 博客标签ID
     * @return 博客标签信息
     */
    BlogTag selectTbBlogTagById(Integer tagId);

    /**
     * 查询博客标签列表
     *
     * @param tbBlogTag 博客标签信息
     * @return 博客标签集合
     */
    List<BlogTag> selectTbBlogTagList(BlogTag tbBlogTag);

    /**
     * 新增博客标签
     *
     * @param tbBlogTag 博客标签信息
     * @return 结果
     */
    int insertTbBlogTag(BlogTag tbBlogTag);

    /**
     * 修改博客标签
     *
     * @param tbBlogTag 博客标签信息
     * @return 结果
     */
    int updateTbBlogTag(BlogTag tbBlogTag);

    /**
     * 删除博客标签
     *
     * @param tagId 博客标签ID
     * @return 结果
     */
    int deleteTbBlogTagById(Integer tagId);

    /**
     * 批量删除博客标签
     *
     * @param tagIds 需要删除的数据ID
     * @return 结果
     */
    int deleteTbBlogTagByIds(String[] tagIds);

}