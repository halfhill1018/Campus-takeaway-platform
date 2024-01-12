package com.graduation.campustakeawayplatform.domain.repository.service;

import com.graduation.campustakeawayplatform.common.Reuqest.RequestPageParam;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author qinziwen
* @description 针对表【product】的数据库操作Service
* @createDate 2024-01-10 18:58:37
*/
public interface ProductService extends IService<ProductPO> {

    List<ProductPO> selectAllProduct(RequestPageParam pageParam);

    List<ProductPO> selectProductBySeller(String sellerId);


}
