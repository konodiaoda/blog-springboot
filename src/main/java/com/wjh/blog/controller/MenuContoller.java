package com.wjh.blog.controller;

import com.wjh.blog.common.Result;
import com.wjh.blog.dto.LabelOptionDTO;
import com.wjh.blog.dto.UserMenuDTO;
import com.wjh.blog.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wujiahui
 * @description
 * @date 2021-09-25 20:13
 */
@Api(tags = "菜单列表")
@RestController
public class MenuContoller {

    @Autowired
    private MenuService menuService;


    /**
     * 查看当前用户菜单
     *
     * @return {@link Result<UserMenuDTO>} 菜单列表
     */
    @ApiOperation(value = "查看当前用户菜单")
    @GetMapping("/admin/user/menus")
    public Result <List<UserMenuDTO>> listUserMenus(){
        return Result.ok(menuService.listUserMenus());
    }

    /**
     * 查看角色菜单选项
     *
     * @return {@link Result<LabelOptionDTO>} 查看角色菜单选项
     */
    @ApiOperation(value = "查看角色菜单选项")
    @GetMapping("/admin/role/menus")
    public Result<List<LabelOptionDTO>> listMenuOptions() {
        return Result.ok(menuService.listMenuOptions());
    }

}
