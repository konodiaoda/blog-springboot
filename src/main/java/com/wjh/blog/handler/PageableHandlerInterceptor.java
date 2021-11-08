package com.wjh.blog.handler;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Strings;
import com.wjh.blog.constant.CommonConst;
import com.wjh.blog.utils.PageUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author wujiahui
 * @description 分页拦截器
 * @date 2021-10-21 23:30
 */
public class PageableHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String currentPage = request.getParameter(CommonConst.CURRENT);
        String pageSize = Optional.ofNullable(request.getParameter(CommonConst.SIZE)).orElse(CommonConst.DEFAULT_SIZE);
        if (!Strings.isNullOrEmpty(currentPage)) {
            //将拦截的分页数据插入
            PageUtils.setCurrentPage(new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize)));
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
