package com.wjh.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjh.blog.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-23 18:06
 */
@Repository
public interface UserInfoDao extends BaseMapper<UserInfo> {
}
