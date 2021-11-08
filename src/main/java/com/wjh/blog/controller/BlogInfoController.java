package com.wjh.blog.controller;

import com.wjh.blog.common.Result;
import com.wjh.blog.service.BlogInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-29 19:57
 */
@Api(tags = "博客信息模块")
@RestController
public class BlogInfoController {

    @Autowired
    private BlogInfoService blogInfoService;


    /**
     * 上传访客信息
     *
     * @return
     */
    @PostMapping("/report")
    public Result<?>result(){
        blogInfoService.report();
        return Result.ok();
    }

}
