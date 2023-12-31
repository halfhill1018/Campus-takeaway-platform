package com.graduation.campustakeawayplatform.domain.service.impl;

import com.graduation.campustakeawayplatform.domain.repository.PO.UserPO;
import com.graduation.campustakeawayplatform.domain.repository.service.UserService;
import com.graduation.campustakeawayplatform.domain.service.UserDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hzt
 * @version 1.0
 * @date 2023/12/31 19:29
 */
@Service("userDomainServiceImpl")
public class UserDomainServiceImpl implements UserDomainService {
    @Resource
    UserService userService;
    @Override
    public String signIn(UserPO userPO) {
        return userService.signIn(userPO);
    }
}
