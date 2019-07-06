package cn.org.july.web.blog.service;


import cn.org.july.web.blog.domain.BlogTagCount;
import cn.org.july.web.utils.PageQueryUtil;
import cn.org.july.web.utils.PageResult;

import java.util.List;

public interface TagService {

    /**
     * 查询标签的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    int getTotalTags();

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);

    List<BlogTagCount> getBlogTagCountForIndex();
}
