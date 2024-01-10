package com.graduation.campustakeawayplatform.domain.service;

import com.graduation.campustakeawayplatform.domain.repository.PO.UserPO;

/**
 * @author hzt
 * @version 1.0
 * @date 2023/12/31 19:29
 */
public interface UserDomainService {

    String signIn(UserPO userPO);

    String login(UserPO userPO);

}
