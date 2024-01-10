package com.graduation.campustakeawayplatform.domain.repository.service;

import com.graduation.campustakeawayplatform.domain.repository.PO.UserPO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author he
* @description 针对表【user】的数据库操作Service
* @createDate 2023-12-31 19:23:46
*/
public interface UserService extends IService<UserPO> {

    String signIn(UserPO userPO);

    String login(UserPO userPO);


}
