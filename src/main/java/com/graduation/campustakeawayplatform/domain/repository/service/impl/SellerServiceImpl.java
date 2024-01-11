package com.graduation.campustakeawayplatform.domain.repository.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.PO.SellerPO;
import com.graduation.campustakeawayplatform.domain.repository.mapper.ProductMapper;
import com.graduation.campustakeawayplatform.domain.repository.service.SellerService;
import com.graduation.campustakeawayplatform.domain.repository.mapper.SellerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
* @author he
* @description 针对表【seller】的数据库操作Service实现
* @createDate 2023-12-31 19:23:42
*/
@Service
public class SellerServiceImpl extends ServiceImpl<SellerMapper, SellerPO>
    implements SellerService{

    Logger logger = LoggerFactory.getLogger(SellerServiceImpl.class);


    @Resource
    ProductMapper productMapper;

    @Override
    public boolean productRelease(ProductPO productPO) {
        logger.info("发布商品参数: {}", JSON.toJSONString(productPO));

        //发布商品
        Integer result = productMapper.insertSelective(productPO);

        return result == 1;
    }
}




