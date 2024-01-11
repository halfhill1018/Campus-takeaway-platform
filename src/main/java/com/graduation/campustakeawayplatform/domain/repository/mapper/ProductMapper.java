package com.graduation.campustakeawayplatform.domain.repository.mapper;
import com.graduation.campustakeawayplatform.common.Reuqest.RequestPageParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author qinziwen
* @description 针对表【product】的数据库操作Mapper
* @createDate 2024-01-10 18:58:37
* @Entity com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO
*/
@Mapper
public interface ProductMapper extends BaseMapper<ProductPO> {

    /**
     * 商品上架
     * @param productPO
     * @return
     */
    int insertSelective(ProductPO productPO);

    /**
     * 获取所有生效的商品
     * @return
     */
    List<ProductPO> selectAll(@Param("pageParam") RequestPageParam pageParam);

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


    /**
     * 根据商品id和卖家id下架
     * @param productStatus
     * @param id
     * @param sellerId
     * @return
     */
    int updateProductStatusByIdAndSellerId(@Param("productStatus") Integer productStatus, @Param("id") String id, @Param("sellerId") String sellerId);

    /**
     * 根据商品id获取商品状态
     * @param id
     * @return
     */
    ProductPO selectProductStatusById(@Param("id") String id);

}




