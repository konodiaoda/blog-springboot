package com.wjh.blog.utils;

import com.wjh.blog.dto.UserDetailDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-22 12:40
 */
@Component
public class UserUtils {
    /**
     * 获取当前登录用户
     * @return
     */
    public static UserDetailDTO getLoginUser() {
        return (UserDetailDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
