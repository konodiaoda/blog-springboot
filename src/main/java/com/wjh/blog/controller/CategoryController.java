package com.wjh.blog.controller;

import com.wjh.blog.annotation.OptLog;
import com.wjh.blog.common.Result;
import com.wjh.blog.constant.OptTypeConst;
import com.wjh.blog.dto.CategoryBackDTO;
import com.wjh.blog.dto.CategoryOptionDTO;
import com.wjh.blog.service.CategoryService;
import com.wjh.blog.vo.CategoryVO;
import com.wjh.blog.vo.ConditionVO;
import com.wjh.blog.vo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wujiahui
 * @description 分类控制器
 * @date 2021-11-03 22:20
 */
@Api(tags = "分类模块")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    /**
     * 查看后台分类列表
     *
     * @param condition 条件
     * @return {@link Result<CategoryBackDTO>} 后台分类列表
     */
    @ApiOperation(value = "查看后台分类列表")
    @GetMapping("/admin/categories")
    public Result<PageResult<CategoryBackDTO>> listBackCategories(ConditionVO condition) {
        return Result.ok(categoryService.listBackCategories(condition));
    }


    /**
     * 添加或修改分类
     *
     * @param categoryVO 分类信息
     * @return {@link Result<>}
     */
    @OptLog(optType = OptTypeConst.SAVE_OR_UPDATE)
    @ApiOperation(value = "添加或修改分类")
    @PostMapping("/admin/categories")
    public Result<?> saveOrUpdateCategory(@Valid @RequestBody CategoryVO categoryVO) {
        categoryService.saveOrUpdateCategory(categoryVO);
        return Result.ok();
    }

    /**
     * 搜索文章分类
     *
     * @param condition 条件
     * @return {@link Result<CategoryOptionDTO>} 分类列表
     *
     */
    @ApiOperation(value = "搜索文章分类")
    @GetMapping("/admin/categories/search")
    public Result<List<CategoryOptionDTO>> listCategoriesBySearch(ConditionVO condition) {
        return Result.ok(categoryService.listCategoriesBySearch(condition));
    }

}
