package com.graduation.campustakeawayplatform.application.service.impl;

import com.graduation.campustakeawayplatform.application.service.SellerApplicationService;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.service.SellerDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author HuangShen
 * @Date 2024/1/10 19:13
 * @Describe
 */
@Service
public class SellerApplicationServiceImpl implements SellerApplicationService {

    @Resource
    SellerDomainService sellerDomainService;

    @Override
    public boolean ProductRelease(ProductPO productPO) {
        return sellerDomainService.ProductRelease(productPO);

    }
}
