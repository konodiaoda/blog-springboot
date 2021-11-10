package com.wjh.blog.controller;


import com.wjh.blog.common.Result;
import com.wjh.blog.dto.RoleDTO;
import com.wjh.blog.service.RoleService;
import com.wjh.blog.vo.ConditionVO;
import com.wjh.blog.vo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujiahui
 * @description
 * @date 2021-11-09 16:02
 */
@Api(tags = "角色模块")
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询角色列表
     *
     * @param conditionVO 条件
     * @return {@link Result<RoleDTO>} 角色列表
     */
    @ApiOperation(value = "查询角色列表")
    @GetMapping("/admin/roles")
    public Result<PageResult<RoleDTO>> listRoles(ConditionVO conditionVO) {
        return Result.ok(roleService.listRoles(conditionVO));
    }

}
