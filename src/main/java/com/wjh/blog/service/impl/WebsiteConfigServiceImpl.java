package com.wjh.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.blog.dao.WebsiteConfigDao;
import com.wjh.blog.entity.WebsiteConfig;
import com.wjh.blog.service.WebsiteConfigService;
import org.springframework.stereotype.Service;

/**
 * @author wujiahui
 * @description 配置网站权限
 * @date 2021-09-25 17:27
 */
@Service
public class WebsiteConfigServiceImpl extends ServiceImpl<WebsiteConfigDao, WebsiteConfig> implements WebsiteConfigService {
}
