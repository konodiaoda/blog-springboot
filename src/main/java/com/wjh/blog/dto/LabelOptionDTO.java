package com.wjh.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LabelOptionDTO {

    /**
     * 选项id
     */
    private Integer id;

    /**
     * 接口资源名称
     */
    private String resourceName;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父权限id
     */
    private Integer parentId;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 子选项
     */
    private List<LabelOptionDTO> children;

}
