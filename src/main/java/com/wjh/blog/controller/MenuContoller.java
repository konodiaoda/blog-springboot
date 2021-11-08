package com.wjh.blog.controller;

import com.wjh.blog.common.Result;
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
}
