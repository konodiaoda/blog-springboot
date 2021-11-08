package com.wjh.blog.controller;

import com.wjh.blog.annotation.OptLog;
import com.wjh.blog.common.Result;
import com.wjh.blog.constant.OptTypeConst;
import com.wjh.blog.dto.ArticleBackDTO;
import com.wjh.blog.dto.ArticleHomeDTO;
import com.wjh.blog.enums.FilePathEnum;
import com.wjh.blog.service.ArticleService;
import com.wjh.blog.strategy.context.UploadStrategyContext;
import com.wjh.blog.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wujiahui
 * @description
 * @date 2021-09-13 23:48
 */
@Api(tags = "文章")
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    /**
     * 查看首页文章
     *
     * @return {@link Result<ArticleHomeDTO>} 首页文章列表
     */
    @ApiOperation(value = "查看首页文章")
    @GetMapping("/articles")
    public Result<List<ArticleHomeDTO>> listArticles() {
        return Result.ok(articleService.listArticles());
    }

    /**
     * 查看后台文章
     *
     * @param conditionVO 条件
     * @return {@link Result<ArticleBackDTO>} 后台文章列表
     */
    @ApiOperation(value = "查看后台文章")
    @GetMapping("/admin/articles")
    public Result<PageResult<ArticleBackDTO>> listArticleBacks(ConditionVO conditionVO) {
        return Result.ok(articleService.listArticleBacks(conditionVO));
    }


    /**
     * 删除文章
     *
     * @param articleIdList 文章id列表
     * @return {@link Result<>}
     */
    @OptLog(optType = OptTypeConst.REMOVE)
    @ApiOperation(value = "物理删除文章")
    @DeleteMapping("/admin/articles")
    public Result<?> deleteArticles(@RequestBody List<Integer> articleIdList) {
        articleService.deleteArticles(articleIdList);
        return Result.ok();
    }




    /**
     * 根据id查看后台文章
     *
     * @param articleId 文章id
     * @return {@link Result<ArticleVO>} 后台文章
     */
    @ApiOperation(value = "根据id查看后台文章")
    @ApiImplicitParam(name = "articleId", value = "文章id", required = true, dataType = "Integer")
    @GetMapping("/admin/articles/{articleId}")
    public Result<ArticleVO> getArticleBackById(@PathVariable("articleId") Integer articleId) {
        return Result.ok(articleService.getArticleBackById(articleId));
    }


    /**
     * 添加或修改文章
     *
     * @param articleVO 文章信息
     * @return {@link Result<>}
     */
    @OptLog(optType = OptTypeConst.SAVE_OR_UPDATE)
    @ApiOperation(value = "添加或修改文章")
    @PostMapping("/admin/articles")
    public Result<?> saveOrUpdateArticle(@Valid @RequestBody ArticleVO articleVO) {
        articleService.saveOrUpdateArticle(articleVO);
        return Result.ok();
    }

    /**
     * 修改文章置顶状态
     *
     * @param articleTopVO 文章置顶信息
     * @return {@link Result<>}
     */
    @OptLog(optType = OptTypeConst.UPDATE)
    @ApiOperation(value = "修改文章置顶")
    @PutMapping("/admin/articles/top")
    public Result<?> updateArticleTop(@Valid @RequestBody ArticleTopVO articleTopVO) {
        articleService.updateArticleTop(articleTopVO);
        return Result.ok();
    }


    /**
     * 恢复或删除文章
     *
     * @param deleteVO 逻辑删除信息
     * @return {@link Result<>}
     */
    @OptLog(optType = OptTypeConst.UPDATE)
    @ApiOperation(value = "恢复或删除文章")
    @PutMapping("/admin/articles")
    public Result<?> updateArticleDelete(@Valid @RequestBody DeleteVO deleteVO) {
        articleService.updateArticleDelete(deleteVO);
        return Result.ok();
    }


    /**
     * 上传文章图片
     *
     * @param file 文件
     * @return {@link Result<String>} 文章图片地址
     */
    @ApiOperation(value = "上传文章图片")
    @ApiImplicitParam(name = "file", value = "文章图片", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/articles/images")
    public Result<String> saveArticleImages(MultipartFile file) {
        return Result.ok(uploadStrategyContext.executeUploadStrategy(file, FilePathEnum.ARTICLE.getPath()));
    }

}

