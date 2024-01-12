package com.graduation.campustakeawayplatform.application.service;

import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.PO.SellerPO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author qinziwen
 * @Date 2024/1/10 19:12
 * @Describe
 */
public interface SellerApplicationService {
    boolean productRelease(ProductPO productPO);

    boolean productDown(String productId,String sellerId);

    boolean userToSeller(String token, SellerPO sellerPO);
}
