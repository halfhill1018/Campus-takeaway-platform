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
        return productDomainService.selectAllProduct(pageParam);
    }
}
