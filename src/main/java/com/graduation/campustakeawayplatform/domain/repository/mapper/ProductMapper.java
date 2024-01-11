package com.graduation.campustakeawayplatform.domain.repository.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author huangshen
* @description 针对表【product】的数据库操作Mapper
* @createDate 2024-01-10 18:58:37
* @Entity com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO
*/
@Mapper
public interface ProductMapper extends BaseMapper<ProductPO> {

    int insertSelective(ProductPO productPO);

    /**
     * 获取所有商品
     * @return
     */
    List<ProductPO> selectAll();

    /**
     * 根据卖家id获取商品
     * @param sellerId
     * @return
     */
    List<ProductPO> selectAllBySellerId(@Param("sellerId") String sellerId);

    /**
     * 根据商品类型获取商品
     * @param productType
     * @return
     */
    List<ProductPO> selectAllByProductType(@Param("productType") String productType);

    /**
     * 根据商品类型获取商品
     * @param productName
     * @return
     */
    List<ProductPO> selectAllByProductName(@Param("productName") String productName);

    /**
     * 根据卖家id和商品名称获取商品
     * @param productName
     * @param sellerId
     * @return
     */
    List<ProductPO> selectAllByProductNameAndSellerId(@Param("productName") String productName, @Param("sellerId") String sellerId);



}




