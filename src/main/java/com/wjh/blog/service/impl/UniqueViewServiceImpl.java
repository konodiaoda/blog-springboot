package com.wjh.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.blog.dao.UniqueViewDao;
import com.wjh.blog.dto.UniqueViewDTO;
import com.wjh.blog.entity.UniqueView;
import com.wjh.blog.service.UniqueViewService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-30 13:29
 */
@Service
public class UniqueViewServiceImpl extends ServiceImpl<UniqueViewDao, UniqueView> implements UniqueViewService {
    @Override
    public List<UniqueViewDTO> listUniqueViews() {
        return null;
    }
}

