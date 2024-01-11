package com.graduation.campustakeawayplatform.domain.service;

import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;

/**
 * @Author HuangShen
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

}
