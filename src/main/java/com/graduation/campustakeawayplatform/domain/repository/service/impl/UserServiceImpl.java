package com.graduation.campustakeawayplatform.domain.repository.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.campustakeawayplatform.common.hutool.IdGenerator;
import com.graduation.campustakeawayplatform.domain.repository.PO.UserPO;
import com.graduation.campustakeawayplatform.domain.repository.service.UserService;
import com.graduation.campustakeawayplatform.domain.repository.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* @author he
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-12-31 19:23:46
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO>
    implements UserService{
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Resource
    UserMapper userMapper;

    @Resource
    IdGenerator idGenerator;

    @Override
    @Transactional
    public String signIn(UserPO userPO) {

        String loginName = userPO.getLoginName();

        try {
            List<UserPO> userPOS = userMapper.selectLoginNameByLoginName(loginName);
            if (!userPOS.isEmpty()) {
                return "此用户名不可用";
            }
            //userPO.setId(String.valueOf(idGenerator.generateId()));
            logger.info("入库参数:{}", JSON.toJSONString(userPO));
            int result = userMapper.insertSelective(userPO);
            if (result != 1) {
                return "注册失败";
            }
            return "注册成功";
        }catch (Exception e){
            throw new RuntimeException("注册异常");
        }


    }
}




