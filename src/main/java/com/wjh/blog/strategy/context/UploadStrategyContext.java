package com.wjh.blog.strategy.context;

import com.wjh.blog.enums.UploadModeEnum;
import com.wjh.blog.strategy.UploadStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author wujiahui
 * @description
 * @date 2021-11-04 15:13
 */
@Service
public class UploadStrategyContext {
    /**
     * 上传模式
     */
    @Value("${upload.mode}")
    private String uploadMode;

    @Resource
    private Map<String, UploadStrategy> uploadStrategyMap;

    /**
     * 上传文件
     *
     *
     * @param file 文件
     * @param path 路径
     * @return {@link String} 文件地址
     */
    public String executeUploadStrategy(MultipartFile file, String path) {
        return uploadStrategyMap.get(UploadModeEnum.getStrategy(uploadMode)).uploadFile(file, path);
    }
}
