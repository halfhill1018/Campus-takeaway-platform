package com.graduation.campustakeawayplatform.application.service;

import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;

/**
 * @Author HuangShen
 * @Date 2024/1/10 19:12
 * @Describe
 */
public interface SellerApplicationService {
    boolean productRelease(ProductPO productPO);

    boolean productDown(String productId,String sellerId);
}
