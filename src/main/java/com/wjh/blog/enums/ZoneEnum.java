package com.wjh.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wujiahui
 * @description 时区枚举
 * @date 2021-10-24 00:15
 */
@Getter
@AllArgsConstructor
public enum ZoneEnum {
    /**
     * 上海
     */
    SHANGHAI("Asia/Shanghai", "中国上海");

    /**
     * 时区
     */
    private final String zone;

    /**
     * 描述
     */
    private final String desc;
}
