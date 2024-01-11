package com.graduation.campustakeawayplatform.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.graduation.campustakeawayplatform.common.Reuqest.RequestPageParam;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.service.ProductService;
import com.graduation.campustakeawayplatform.domain.repository.service.impl.SellerServiceImpl;
import com.graduation.campustakeawayplatform.domain.service.ProductDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author qinziwen
 * @Date 2024/1/11 15:58
 * @Describe
 */
@Service
public class ProductDomainServiceImpl implements ProductDomainService {

    Logger logger = LoggerFactory.getLogger(ProductDomainServiceImpl.class);

    @Resource
    ProductService productService;

    @Override
    public List<ProductPO> selectAllProduct(RequestPageParam pageParam) {
        logger.info("domain层参数: {}", JSON.toJSONString(pageParam));
        List<ProductPO> productPOS = productService.selectAllProduct(pageParam);
        logger.info("domain层结果: {}",JSON.toJSONString(productPOS));
        return productPOS;
    }
}
