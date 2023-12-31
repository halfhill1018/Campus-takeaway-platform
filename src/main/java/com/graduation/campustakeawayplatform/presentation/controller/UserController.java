package com.graduation.campustakeawayplatform.presentation.controller;

import com.graduation.campustakeawayplatform.application.service.UserApplicationService;
import com.graduation.campustakeawayplatform.domain.repository.PO.UserPO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hzt
 * @version 1.0
 * @date 2023/12/31 19:24
 */
@RestController
public class UserController {
    @Resource
    UserApplicationService userApplicationService;

    @PostMapping("/signIn")
    public String signIn(UserPO userPO){
        return userApplicationService.signIn(userPO);
    }
}
