package com.wjh.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wjh.blog.dto.MenuDTO;
import com.wjh.blog.dto.UserMenuDTO;
import com.wjh.blog.entity.Menu;
import com.wjh.blog.vo.ConditionVO;

import java.util.List;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-02 15:06
 */
public interface MenuService extends IService<Menu> {

    /**
     * 查看用户菜单
     *
     * @return 菜单列表
     */
    List<UserMenuDTO> listUserMenus();

    /**
     * 查看菜单列表
     *
     * @param conditionVO 条件
     * @return 菜单列表
     */
    List<MenuDTO> listMenus(ConditionVO conditionVO);
}
