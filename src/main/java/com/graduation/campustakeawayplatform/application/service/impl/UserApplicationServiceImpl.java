package com.graduation.campustakeawayplatform.application.service.impl;

import com.alibaba.fastjson2.JSON;
import com.graduation.campustakeawayplatform.application.service.UserApplicationService;
import com.graduation.campustakeawayplatform.domain.repository.PO.UserPO;
import com.graduation.campustakeawayplatform.domain.service.UserDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hzt
 * @version 1.0
 * @date 2023/12/31 19:28
 */
@Service("userApplicationServiceImpl")
public class UserApplicationServiceImpl implements UserApplicationService {
    Logger logger = LoggerFactory.getLogger(UserApplicationServiceImpl.class);
    @Resource
    UserDomainService userDomainService;


    @Override
    public String signIn(UserPO userPO) {
        logger.info("注册参数:{}", JSON.toJSONString(userPO));
        return userDomainService.signIn(userPO);
    }
}
