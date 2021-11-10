package com.wjh.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.blog.dao.RoleResourceDao;
import com.wjh.blog.entity.RoleResource;
import com.wjh.blog.service.RoleResourceService;
import org.springframework.stereotype.Service;

/**
 * @author wujiahui
 * @description 角色资源服务
 * @date 2021-11-10 14:25
 */
@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceDao, RoleResource> implements RoleResourceService {
}
