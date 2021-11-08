package com.wjh.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjh.blog.dto.UserBackDTO;
import com.wjh.blog.entity.UserAuth;
import com.wjh.blog.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-23 10:43
 */
@Repository
public interface UserAuthDao extends BaseMapper<UserAuth> {

    /**
     * 查询后台用户列表
     * @param current
     * @param size
     * @param condition
     * @return
     */
    List<UserBackDTO> listUsers(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);

    /**
     * 查询后台用户数量
     * @param condition
     * @return
     */
    Integer countUser(@Param("condition") ConditionVO condition);
}
