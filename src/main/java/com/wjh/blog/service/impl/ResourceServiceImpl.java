package com.wjh.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.blog.constant.CommonConst;
import com.wjh.blog.dao.ResourceDao;
import com.wjh.blog.dao.RoleResourceDao;
import com.wjh.blog.dto.LabelOptionDTO;
import com.wjh.blog.dto.ResourceDTO;
import com.wjh.blog.entity.Resource;
import com.wjh.blog.handler.FilterInvocationSecurityMetadataSourceImpl;
import com.wjh.blog.service.ResourceService;
import com.wjh.blog.utils.BeanCopyUtils;
import com.wjh.blog.vo.ConditionVO;
import com.wjh.blog.vo.ResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wujiahui
 * @description
 * @date 2021-11-09 16:07
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, Resource> implements ResourceService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RoleResourceDao roleResourceDao;
    @Autowired
    private FilterInvocationSecurityMetadataSourceImpl filterInvocationSecurityMetadataSource;

    @Override
    public void importSwagger() {

    }

    @Override
    public void saveOrUpdateResource(ResourceVO resourceVO) {

    }

    @Override
    public void deleteResource(Integer resourceId) {

    }

    @Override
    public List<ResourceDTO> listResources(ConditionVO conditionVO) {
        return null;
    }

    @Override
    public List<LabelOptionDTO> listResourceOption() {
        // 查询资源列表,拿到所有资源
        List<Resource> resourceList = baseMapper.selectList(new LambdaQueryWrapper<Resource>()
                .select(Resource::getId, Resource::getResourceName, Resource::getParentId)
                .eq(Resource::getIsAnonymous, CommonConst.FALSE));

        List<LabelOptionDTO> labelOptionDTOS = BeanCopyUtils.copyList(resourceList, LabelOptionDTO.class);

        //封转父子数据
        return labelOptionDTOS.stream().filter(item -> Objects.isNull(item.getParentId())
        ).peek(menu -> menu.setChildren(getChilderns(menu, labelOptionDTOS))).collect(Collectors.toList());

    }

    private List<LabelOptionDTO> getChilderns(LabelOptionDTO menuChildern, List<LabelOptionDTO> list) {
        return list.stream()
                .filter(item-> Objects.equals(item.getParentId(),menuChildern.getId()))
                .peek(menu->menu.setChildren(getChilderns(menu,list))).collect(Collectors.toList());
    }


}
