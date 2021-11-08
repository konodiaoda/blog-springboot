package com.wjh.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjh.blog.entity.OperationLog;
import org.springframework.stereotype.Repository;

/**
 * @author wujiahui
 * @description
 * @date 2021-11-02 13:16
 */
@Repository
public interface OperationLogDao extends BaseMapper<OperationLog> {
}
