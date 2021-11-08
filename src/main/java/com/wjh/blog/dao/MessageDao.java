package com.wjh.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjh.blog.entity.Message;
import org.springframework.stereotype.Repository;

/**
 * @author wujiahui
 * @description 留言
 * @date 2021-10-30 12:05
 */
@Repository
public interface MessageDao extends BaseMapper<Message> {
}
