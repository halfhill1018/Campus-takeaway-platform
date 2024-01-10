package com.graduation.campustakeawayplatform.domain.repository.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.graduation.campustakeawayplatform.domain.repository.PO.SellerPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author he
* @description 针对表【seller】的数据库操作Mapper
* @createDate 2023-12-31 19:23:42
* @Entity com.graduation.campustakeawayplatform.domain.repository.repository.SellerPO
*/
public interface SellerMapper extends BaseMapper<SellerPO> {

    int insertSelective(SellerPO sellerPO);

    List<SellerPO> selectShopNameById(@Param("id") String id);

    List<SellerPO> selectAll();


}




