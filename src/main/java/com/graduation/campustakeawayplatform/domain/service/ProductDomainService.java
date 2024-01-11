package com.graduation.campustakeawayplatform.domain.service;

import com.graduation.campustakeawayplatform.common.Reuqest.RequestPageParam;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;

import java.util.List;

/**
 * @Author qinziwen
 * @Date 2024/1/11 15:57
 * @Describe
 */
public interface ProductDomainService {

    List<ProductPO> selectAllProduct(RequestPageParam pageParam);

}
