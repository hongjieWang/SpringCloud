package cn.org.july.web.blog.service;


import cn.org.july.web.blog.domain.Blog;
import cn.org.july.web.utils.PageQueryUtil;
import cn.org.july.web.utils.PageResult;
import cn.org.july.web.vo.BlogDetailVO;
import cn.org.july.web.vo.BlogListVO;

import java.util.List;

public interface BlogService {
    String saveBlog(Blog blog);

    PageResult getBlogsPage(PageQueryUtil pageUtil);

    Boolean deleteBatch(String ids);

    int getTotalBlogs();

    /**
     * 根据id获取详情
     *
     * @param blogId
     * @return
     */
    Blog getBlogById(Long blogId);


    /**
     * 后台修改
     *
     * @param blog
     * @return
     */
    String updateBlog(Blog blog);

    /**
     * 获取首页文章列表
     *
     * @param page
     * @return
     */
    PageResult getBlogsForIndexPage(int page);

    /**
     * 首页侧边栏数据列表
     * 0-最热 1-最新
     *
     * @param type
     * @return
     */
    List<BlogListVO> getBlogListForIndexPage(int type);


    /**
     * 查询博客列表
     *
     * @param tbBlog 博客信息
     * @return 博客集合
     */
    List<Blog> selectTbBlogList(Blog tbBlog);

    /**
     * 文章详情
     *
     * @param blogId
     * @return
     */
    BlogDetailVO getBlogDetail(Long blogId);

    /**
     * 根据标签获取文章列表
     *
     * @param tagName
     * @param page
     * @return
     */
    PageResult getBlogsPageByTag(String tagName, int page);

    /**
     * 根据分类获取文章列表
     *
     * @param categoryId
     * @param page
     * @return
     */
    PageResult getBlogsPageByCategory(String categoryId, int page);

    /**
     * 根据搜索获取文章列表
     *
     * @param keyword
     * @param page
     * @return
     */
    PageResult getBlogsPageBySearch(String keyword, int page);

    BlogDetailVO getBlogDetailBySubUrl(String subUrl);
}
