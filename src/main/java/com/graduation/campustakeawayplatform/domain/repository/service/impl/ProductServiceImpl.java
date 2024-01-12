package com.graduation.campustakeawayplatform.domain.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.campustakeawayplatform.common.Reuqest.RequestPageParam;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.service.ProductService;
import com.graduation.campustakeawayplatform.domain.repository.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author qinziwen
* @description 针对表【product】的数据库操作Service实现
* @createDate 2024-01-10 18:58:37
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductPO>
    implements ProductService{
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);


    @Resource
    ProductMapper productMapper;

    @Override
    public List<ProductPO> selectAllProduct(RequestPageParam pageParam) {
        return productMapper.selectAll(pageParam);
    }

    @Override
    public List<ProductPO> selectProductBySeller(String sellerId) {

       return productMapper.selectAllBySellerId(sellerId);

    }
}




