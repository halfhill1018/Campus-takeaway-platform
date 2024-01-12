package com.graduation.campustakeawayplatform.presentation.controller;

import com.alibaba.fastjson2.JSON;
import com.graduation.campustakeawayplatform.application.service.ProductApplicationService;
import com.graduation.campustakeawayplatform.common.Reuqest.RequestPageParam;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author qinziwen
 * @Date 2024/1/11 15:02
 * @Describe
 */
@RestController
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);


    @Resource
    ProductApplicationService productApplicationService;


    /**
     * 获取本校全部商品信息
     */
    @GetMapping("/selectAllProduct")
    public List<ProductPO> selectAllProduct( RequestPageParam pageParam){

        pageParam.initPageParams(); //初始化分页参数
        logger.info("初始化后的分页参数: {}", JSON.toJSONString(pageParam));
        return productApplicationService.selectAllProduct(pageParam);
    }

    /**
     * 根据店铺名称搜索商品
     * @param shopName
     * @return
     */
    @GetMapping("/selectProductByShopName")
    public List<ProductPO> selectProductByShopName(@RequestParam("shopName") String shopName){
        return productApplicationService.selectProductByShopName(shopName);
    }
}
