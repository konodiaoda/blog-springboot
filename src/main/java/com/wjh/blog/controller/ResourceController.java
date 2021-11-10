package com.wjh.blog.controller;

import com.wjh.blog.common.Result;
import com.wjh.blog.dto.LabelOptionDTO;
import com.wjh.blog.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wujiahui
 * @description 资源模块
 * @date 2021-11-09 22:24
 */
@Api(tags = "资源模块")
@RestController
public class ResourceController {



    @Resource
    private ResourceService resourceService;
    /**
     * 查看角色资源选项
     *
     * @return {@link Result<LabelOptionDTO>} 角色资源选项
     */
    @ApiOperation(value = "查看角色资源选项")
    @GetMapping("/admin/role/resources")
    public Result<List<LabelOptionDTO>> listResourceOption() {
        return Result.ok(resourceService.listResourceOption());
    }



}

