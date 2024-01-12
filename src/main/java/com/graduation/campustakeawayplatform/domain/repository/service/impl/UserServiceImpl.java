package com.graduation.campustakeawayplatform.domain.repository.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.campustakeawayplatform.common.enu.UserEnum;
import com.graduation.campustakeawayplatform.common.hutool.IdGenerator;
import com.graduation.campustakeawayplatform.common.jwt.JwtUtil;
import com.graduation.campustakeawayplatform.domain.repository.PO.UserPO;
import com.graduation.campustakeawayplatform.domain.repository.service.UserService;
import com.graduation.campustakeawayplatform.domain.repository.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    @Transactional
    public String signIn(UserPO userPO) {
        String loginName = userPO.getLoginName();

        try {
            List<UserPO> userPOS = userMapper.selectLoginNameByLoginName(loginName);
            if (!userPOS.isEmpty()) {return "此用户名不可用";}

            //密码哈希处理
            logger.info("入库参数:{}", JSON.toJSONString(userPO));
            String encodePassword = bCryptPasswordEncoder.encode(userPO.getPassWord()); //密码进行哈希
            userPO.setPassWord(encodePassword); //哈希后的密码
            userPO.setEnableFlag(UserEnum.USER_ENABLE_FLAG); //默认状态开启

            //插入数据库
            int result = userMapper.insertSelective(userPO);
            if (result != 1) {return "注册失败";}
            return "注册成功";

        }catch (Exception e){
            throw new RuntimeException("注册异常",e);
        }


    }

    @Override
    public String login(UserPO userPO) {
        //校验账号密码
          this.checkUserNameAndPassword(userPO);

        //查询数据库密码拿出来比较
        UserPO userPOS = userMapper.selectPassWordByLoginName(userPO.getLoginName());
        logger.info("hash password: {}",JSON.toJSONString(userPOS));

        boolean matchesResult = bCryptPasswordEncoder.matches(userPO.getPassWord(), userPOS.getPassWord());

        //生成token
        String loginToken = JwtUtil.generateToken(userPO.getLoginName());

        //结果判断
        if (matchesResult){return loginToken;}

        return "登录失败";
    }

    @Override
    public boolean verifyUserCount(String loginName) {

        List<UserPO> userPOS = userMapper.selectLoginNameByLoginName(loginName);

        if (Objects.isNull(userPOS) || userPOS.size() != 1){
            return false;
        }
        return true;
    }

    @Override
    public String selectUserId(String loginName) {

        UserPO userPO = userMapper.selectIdByLoginName(loginName);
        if (Objects.nonNull(userPO)){
            return userPO.getId();
        }
        return null;
    }

    protected void checkUserNameAndPassword(UserPO userPO){

        if (!userPO.checkAccount(userPO)){
            throw new RuntimeException("请输入正确的账号密码");
        }
    }
}




