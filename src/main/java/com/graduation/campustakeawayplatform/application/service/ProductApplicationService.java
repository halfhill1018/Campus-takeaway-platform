package com.graduation.campustakeawayplatform.application.service;

import com.graduation.campustakeawayplatform.common.Reuqest.RequestPageParam;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;

import java.util.List;

/**
 * @Author qinziwen
 * @Date 2024/1/11 15:40
 * @Describe
 */
public interface ProductApplicationService {
    List<ProductPO> selectAllProduct(RequestPageParam pageParam);
}
