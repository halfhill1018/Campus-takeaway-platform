package com.graduation.campustakeawayplatform.domain.service;

import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.PO.SellerPO;

/**
 * @Author qinziwen
 * @Date 2024/1/10 19:15
 * @Describe
 */
public interface SellerDomainService {

    /**
     * 商品发布
     * @param productPO
     * @return
     */
    boolean ProductRelease(ProductPO productPO);

    /**
     * 商品下架
     * @param productId
     * @param sellerId
     * @return
     */
    boolean productDown(String productId, String sellerId);

    /**
     * 用户注册为商家
     * @param token
     * @param sellerPO
     * @return
     */
    boolean userToSeller(String token, SellerPO sellerPO);

}
