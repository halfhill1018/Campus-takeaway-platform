package com.graduation.campustakeawayplatform.application.service.impl;

import com.graduation.campustakeawayplatform.application.service.ProductApplicationService;
import com.graduation.campustakeawayplatform.common.Reuqest.RequestPageParam;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.service.ProductDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author qinziwen
 * @Date 2024/1/11 15:40
 * @Describe
 */
@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {

    @Resource
    ProductDomainService productDomainService;

    @Override
    public List<ProductPO> selectAllProduct(RequestPageParam pageParam) {

        //查询出结果
        List<ProductPO> productPOS = productDomainService.selectAllProduct(pageParam);

        //上层应用加一层缓存


        return productPOS;
    }

    @Override
    public List<ProductPO> selectProductByShopName(String shopName) {

        //校验参数
        if (shopName.isEmpty()){
            throw new RuntimeException("参数校验不通过");
        }
        return productDomainService.selectProductByShopName(shopName);

    }
}
