package cn.org.july.web.blog.service.impl;


import cn.org.july.web.blog.dao.BlogCategoryMapper;
import cn.org.july.web.blog.dao.BlogMapper;
import cn.org.july.web.blog.domain.BlogCategory;
import cn.org.july.web.blog.service.CategoryService;
import cn.org.july.web.utils.PageQueryUtil;
import cn.org.july.web.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public PageResult getBlogCategoryPage(PageQueryUtil pageUtil) {
        List<BlogCategory> categoryList = blogCategoryMapper.findCategoryList(pageUtil);
        int total = blogCategoryMapper.getTotalCategories(pageUtil);
        PageResult pageResult = new PageResult(categoryList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }


    /**
     * 查询博客分类列表
     *
     * @param tbBlogCategory 博客分类信息
     * @return 博客分类集合
     */
    @Override
    public List<BlogCategory> selectTbBlogCategoryList(BlogCategory tbBlogCategory) {
        return blogCategoryMapper.selectTbBlogCategoryList(tbBlogCategory);
    }

    /**
     * 查询博客分类信息
     *
     * @param categoryId 博客分类ID
     * @return 博客分类信息
     */
    @Override
    public BlogCategory selectTbBlogCategoryById(Integer categoryId) {
        return blogCategoryMapper.selectTbBlogCategoryById(categoryId);
    }

    @Override
    public int getTotalCategories() {
        return blogCategoryMapper.getTotalCategories(null);
    }

    @Override
    public Boolean saveCategory(String categoryName, String categoryIcon) {
        BlogCategory temp = blogCategoryMapper.selectByCategoryName(categoryName);
        if (temp == null) {
            BlogCategory blogCategory = new BlogCategory();
            blogCategory.setCategoryName(categoryName);
            blogCategory.setCategoryIcon(categoryIcon);
            return blogCategoryMapper.insertSelective(blogCategory) > 0;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon) {
        BlogCategory blogCategory = blogCategoryMapper.selectByPrimaryKey(categoryId);
        if (blogCategory != null) {
            blogCategory.setCategoryIcon(categoryIcon);
            blogCategory.setCategoryName(categoryName);
            //修改分类实体
            blogMapper.updateBlogCategorys(categoryName, blogCategory.getCategoryId(), new String[]{String.valueOf(categoryId)});
            return blogCategoryMapper.updateByPrimaryKeySelective(blogCategory) > 0;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteBatch(String[] ids) {
        if (ids.length < 1) {
            return false;
        }
        //修改tb_blog表
        blogMapper.updateBlogCategorys("默认分类", 0, ids);
        //删除分类数据
        return blogCategoryMapper.deleteBatch(ids) > 0;
    }

    @Override
    public List<BlogCategory> getAllCategories() {
        return blogCategoryMapper.findCategoryList(null);
    }

}
