package com.wjh.blog.annotation;

import java.lang.annotation.*;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-24 00:31
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptLog {
    /**
     * @return 操作类型
     */
    String optType() default "";
}
