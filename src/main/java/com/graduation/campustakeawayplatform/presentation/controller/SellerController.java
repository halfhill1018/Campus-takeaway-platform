package com.graduation.campustakeawayplatform.presentation.controller;

import com.graduation.campustakeawayplatform.application.service.SellerApplicationService;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.PO.SellerPO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author qinziwen
 * @Date 2024/1/10 18:32
 * @Describe
 */
@RestController
public class SellerController {

    @Resource
    SellerApplicationService sellerApplicationService;

    /**
     * 发布商品/重新上架
     * @return
     */
    @PostMapping("/productRelease")
    public boolean productRelease( ProductPO productPO){
        return sellerApplicationService.productRelease(productPO);
    }

    /**
     * 商品下架
     * @param productId 商品id
     * @param sellerId 卖家id
     * @return
     */
    @PostMapping("/productDown")
    public boolean productDown(@RequestParam("productId") String productId, @RequestParam("sellerId")String sellerId){
        return sellerApplicationService.productDown(productId,sellerId);
    }

    /**
     * 用户注册为商家
     * @param token
     * @param sellerPO
     * @return
     */
    @PostMapping("/userToSeller")
    public boolean userToSeller(@RequestParam("token") String token, @RequestBody SellerPO sellerPO){
        return sellerApplicationService.userToSeller(token,sellerPO);
    }
}
