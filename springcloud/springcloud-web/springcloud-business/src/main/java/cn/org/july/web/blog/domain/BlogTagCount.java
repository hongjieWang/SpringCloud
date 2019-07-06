package cn.org.july.web.blog.domain;

import lombok.Data;

@Data
public class BlogTagCount {
    private Integer tagId;

    private String tagName;

    private Integer tagCount;

}
