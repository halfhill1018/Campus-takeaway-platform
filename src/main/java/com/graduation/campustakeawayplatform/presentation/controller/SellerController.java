package com.graduation.campustakeawayplatform.presentation.controller;

import com.graduation.campustakeawayplatform.application.service.SellerApplicationService;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.service.SellerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author HuangShen
 * @Date 2024/1/10 18:32
 * @Describe
 */
@RestController
public class SellerController {

    @Resource
    SellerApplicationService sellerApplicationService;

    /**
     * 发布商品
     * @return
     */
    @PostMapping("/productRelease")
    public boolean ProductRelease(ProductPO productPO){
        return sellerApplicationService.ProductRelease(productPO);
    }

}
