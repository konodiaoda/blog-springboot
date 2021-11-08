package com.wjh.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wjh.blog.dto.UniqueViewDTO;
import com.wjh.blog.entity.UniqueView;

import java.util.List;

/**
 * @author wujiahui
 * @description 用户量统计
 * @date 2021-10-30 13:22
 */
public interface UniqueViewService  extends IService<UniqueView> {

    /**
     * 获取7天用户量统计
     *
     * @return 用户量
     */
    List<UniqueViewDTO> listUniqueViews();

}
