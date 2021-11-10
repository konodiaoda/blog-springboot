package com.wjh.blog.handler;

import com.wjh.blog.common.Result;
import com.wjh.blog.dao.UserAuthDao;
import com.wjh.blog.dto.UserInfoDTO;
import com.wjh.blog.entity.UserAuth;
import com.wjh.blog.utils.BeanCopyUtils;
import com.wjh.blog.utils.JsonUtils;
import com.wjh.blog.utils.UserUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-22 12:06
 */
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Resource
    private UserAuthDao userAuthDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //返回登陆信息
        UserInfoDTO userInfoDTO = BeanCopyUtils.copyObject(UserUtils.getLoginUser(), UserInfoDTO.class);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JsonUtils.obj2StringPretty(Result.ok(userInfoDTO)));
        updateUserInfo();
    }
    /**
     * 更新用户信息
     */
    @Async
    public void updateUserInfo() {
        UserAuth userAuth = UserAuth.builder()
                .id(UserUtils.getLoginUser().getId())
                .ipAddress(UserUtils.getLoginUser().getIpAddress())
                .ipSource(UserUtils.getLoginUser().getIpSource())
                .lastLoginTime(UserUtils.getLoginUser().getLastLoginTime())
                .build();
        userAuthDao.updateById(userAuth);
    }

}
