package com.wjh.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.wjh.blog.constant.RedisPrefixConst;
import com.wjh.blog.dao.PageDao;
import com.wjh.blog.entity.Page;
import com.wjh.blog.service.PageService;
import com.wjh.blog.service.RedisService;
import com.wjh.blog.utils.BeanCopyUtils;
import com.wjh.blog.utils.JsonUtils;
import com.wjh.blog.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-30 14:01
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageDao, Page> implements PageService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private PageDao pageDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdatePage(PageVO pageVO) {
        Page page = BeanCopyUtils.copyObject(pageVO, Page.class);
        this.saveOrUpdate(page);
        //删除缓存
        redisService.del(RedisPrefixConst.PAGE_COVER);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePage(Integer pageId) {
        pageDao.deleteById(pageId);
        redisService.del(RedisPrefixConst.PAGE_COVER);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PageVO> listPages() {
        List<PageVO> pageVOList;
        // 查找缓存信息，不存在则从mysql读取，更新缓存
        Object pageList = redisService.get(RedisPrefixConst.PAGE_COVER);
        if (Objects.nonNull(pageList)) {
            pageVOList = JsonUtils.string2Obj(pageList.toString(), new TypeReference<List<PageVO>>(){});
        } else {
            pageVOList = BeanCopyUtils.copyList(pageDao.selectList(null), PageVO.class);
            redisService.set(RedisPrefixConst.PAGE_COVER,JsonUtils.obj2StringPretty(pageVOList));
        }
        return pageVOList;
    }
}
