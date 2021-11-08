package com.wjh.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wujiahui
 * @description 文章状态
 * @date 2021-10-31 23:07
 */
@Getter
@AllArgsConstructor
public enum ArticleStatusEnum {
    /**
     * 公开
     */
    PUBLIC(1, "公开"),
    /**
     * 私密
     */
    SECRET(2, "私密"),
    /**
     * 草稿
     */
    DRAFT(3, "草稿");

    /**
     * 状态
     */
    private final Integer status;

    /**
     * 描述
     */
    private final String desc;
}
