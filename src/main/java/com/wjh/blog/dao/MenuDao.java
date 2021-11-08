package com.wjh.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjh.blog.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wujiahui
 * @description
 * @date 2021-09-25 20:45
 */
@Repository
public interface MenuDao extends BaseMapper<Menu> {

    /**
     * 根据用户id查询菜单
     * @param userInfoId 用户信息id
     * @return 菜单列表
     */
    List<Menu> listMenusByUserInfoId(Integer userInfoId);
}
