package com.wjh.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjh.blog.dto.CategoryBackDTO;
import com.wjh.blog.dto.CategoryDTO;
import com.wjh.blog.entity.Category;
import com.wjh.blog.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-29 20:04
 */
@Repository
public interface CategoryDao extends BaseMapper<Category> {

    /**
     * 查询分类和对应文章数量
     *
     * @return
     */
    List<CategoryDTO> listCategoryDTO();

    /**
     * 查询后台
     *
     * @param current
     * @param size
     * @param condition
     * @return
     */
    List<CategoryBackDTO> listCategoryBackDTO(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionVO condition);


}
