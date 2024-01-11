package com.graduation.campustakeawayplatform.application.service.impl;

import com.graduation.campustakeawayplatform.application.service.SellerApplicationService;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.service.impl.UserServiceImpl;
import com.graduation.campustakeawayplatform.domain.service.SellerDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author qinziwen
 * @Date 2024/1/10 19:13
 * @Describe
 */
@Service
public class SellerApplicationServiceImpl implements SellerApplicationService {
    Logger logger = LoggerFactory.getLogger(SellerApplicationServiceImpl.class);

    @Resource
    SellerDomainService sellerDomainService;

    @Override
    public boolean productRelease(ProductPO productPO) {
        return sellerDomainService.ProductRelease(productPO);

    }

    @Override
    public boolean productDown(String productId, String sellerId) {
        try {


            // 上层就做好参数校验
            boolean validateResult = this.validateParameters(productId, sellerId);

            //调领域下架
            sellerDomainService.productDown(productId, sellerId);


        }catch (Exception e){
            logger.info("下架发生异常: ",e);
            return false;
        }
        return true;
    }



    public  boolean validateParameters(Object... args) {
        for (Object arg : args) {
            if (arg == null || (arg instanceof String && ((String) arg).trim().isEmpty())) {
            throw new RuntimeException("参数校验不通过");
            }
        }
        return true;  // 所有参数都不为空，返回true
    }
}
