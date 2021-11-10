package com.wjh.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjh.blog.dao.UserInfoDao;
import com.wjh.blog.dto.UserOnlineDTO;
import com.wjh.blog.entity.UserInfo;
import com.wjh.blog.service.UserInfoService;
import com.wjh.blog.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wujiahui
 * @description 用户信息
 * @date 2021-11-09 19:09
 */
@Service
public class UserInfoServiceImpl  extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {
    @Override
    public void updateUserInfo(UserInfoVO userInfoVO) {

    }

    @Override
    public String updateUserAvatar(MultipartFile file) {
        return null;
    }

    @Override
    public void saveUserEmail(EmailVO emailVO) {

    }

    @Override
    public void updateUserRole(UserRoleVO userRoleVO) {

    }

    @Override
    public void updateUserDisable(UserDisableVO userDisableVO) {

    }

    @Override
    public PageResult<UserOnlineDTO> listOnlineUsers(ConditionVO conditionVO) {
        return null;
    }

    @Override
    public void removeOnlineUser(Integer userInfoId) {

    }
}
