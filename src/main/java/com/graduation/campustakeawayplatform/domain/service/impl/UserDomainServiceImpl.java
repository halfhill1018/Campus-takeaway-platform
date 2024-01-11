package com.graduation.campustakeawayplatform.domain.service.impl;

import com.graduation.campustakeawayplatform.common.hutool.IdGenerator;
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

    @Resource
    IdGenerator idGenerator;

    @Override
    public String signIn(UserPO userPO) {
        String generateId = idGenerator.generateId();
        userPO.setId(generateId);
        return userService.signIn(userPO);
    }

    @Override
    public String login(UserPO userPO) {
        return userService.login(userPO);
    }
}
