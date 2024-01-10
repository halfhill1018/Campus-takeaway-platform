package com.graduation.campustakeawayplatform.application.service;

import com.graduation.campustakeawayplatform.domain.repository.PO.UserPO;

/**
 * @author hzt
 * @version 1.0
 * @date 2023/12/31 19:27
 */
public interface UserApplicationService {
    String signIn(UserPO userPO);

    String login(UserPO userPO);
}
