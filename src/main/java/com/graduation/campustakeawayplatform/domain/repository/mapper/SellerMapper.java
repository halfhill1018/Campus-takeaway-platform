package com.graduation.campustakeawayplatform.domain.repository.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.graduation.campustakeawayplatform.domain.repository.PO.SellerPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author he
* @description 针对表【seller】的数据库操作Mapper
* @createDate 2023-12-31 19:23:42
* @Entity com.graduation.campustakeawayplatform.domain.repository.repository.SellerPO
*/
@Mapper
public interface SellerMapper extends BaseMapper<SellerPO> {

    /**
     * 生成卖家
     * @param sellerPO
     * @return
     */
    int insertSelective(SellerPO sellerPO);

    /**
     * 根据id获取店铺名
     * @param id
     * @return
     */
    List<SellerPO> selectShopNameById(@Param("id") String id);

    /**
     * 查询所有商家信息
     * @return
     */
    List<SellerPO> selectAll();

    /**
     * 获取所有卖家的id和店名，用于前台的商品搜索
     * @return
     */
    List<SellerPO> selectIdAndShopName();

    SellerPO selectIdByShopName(@Param("shopName") String shopName);


}




