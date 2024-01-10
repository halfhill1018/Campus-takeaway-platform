package com.graduation.campustakeawayplatform.domain.repository.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.graduation.campustakeawayplatform.domain.repository.PO.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author he
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-12-31 19:23:46
* @Entity com.graduation.campustakeawayplatform.domain.repository.repository.UserPO
*/
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

    List<UserPO> selectLoginNameByLoginName(@Param("loginName") String loginName);

    int insertSelective(UserPO userPO);

    UserPO selectPassWordByLoginName(@Param("loginName") String loginName);

}




