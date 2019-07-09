package cn.org.july.web.blog.dao;


import cn.org.july.web.blog.domain.BlogComment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface BlogCommentMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    BlogComment selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKey(BlogComment record);

    List<BlogComment> findBlogCommentList(Map map);

    int getTotalBlogComments(Map map);

    int checkDone(Integer[] ids);

    int deleteBatch(String[] id);


    /**
     * 查询博客评论列表
     *
     * @param tbBlogComment 博客评论信息
     * @return 博客评论集合
     */
    List<BlogComment> selectTbBlogCommentList(BlogComment tbBlogComment);
}