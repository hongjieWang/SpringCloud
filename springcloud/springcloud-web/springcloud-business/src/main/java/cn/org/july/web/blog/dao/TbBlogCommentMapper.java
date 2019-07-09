package cn.org.july.web.blog.dao;

import cn.org.july.web.blog.domain.BlogComment;

import java.util.List;

/**
 * 博客评论 数据层
 *
 * @author null
 * @date 2019-07-07
 */
public interface TbBlogCommentMapper {
    /**
     * 查询博客评论信息
     *
     * @param commentId 博客评论ID
     * @return 博客评论信息
     */
    BlogComment selectTbBlogCommentById(Long commentId);

    /**
     * 查询博客评论列表
     *
     * @param tbBlogComment 博客评论信息
     * @return 博客评论集合
     */
    List<BlogComment> selectTbBlogCommentList(BlogComment tbBlogComment);

    /**
     * 新增博客评论
     *
     * @param tbBlogComment 博客评论信息
     * @return 结果
     */
    int insertTbBlogComment(BlogComment tbBlogComment);

    /**
     * 修改博客评论
     *
     * @param tbBlogComment 博客评论信息
     * @return 结果
     */
    int updateTbBlogComment(BlogComment tbBlogComment);

    /**
     * 删除博客评论
     *
     * @param commentId 博客评论ID
     * @return 结果
     */
    int deleteTbBlogCommentById(Long commentId);

    /**
     * 批量删除博客评论
     *
     * @param commentIds 需要删除的数据ID
     * @return 结果
     */
    int deleteTbBlogCommentByIds(String[] commentIds);

}