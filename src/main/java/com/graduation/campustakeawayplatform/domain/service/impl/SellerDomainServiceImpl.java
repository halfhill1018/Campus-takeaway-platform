package com.graduation.campustakeawayplatform.domain.service.impl;

import com.graduation.campustakeawayplatform.common.enu.ProductEnum;
import com.graduation.campustakeawayplatform.common.hutool.IdGenerator;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.service.SellerService;
import com.graduation.campustakeawayplatform.domain.service.SellerDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author HuangShen
 * @Date 2024/1/10 19:15
 * @Describe 领域层，负责操作领域，返回的是整个领域模型
 *
 */
@Service
public class SellerDomainServiceImpl implements SellerDomainService {

    @Resource
    SellerService sellerService;

    @Resource
    IdGenerator idGenerator;

    @Override
    @Transactional
    public boolean ProductRelease(ProductPO productPO) {
        try {

            //检查信息合法性
            this.checkProductInfo(productPO);

            //生成商品id
            productPO.setId(idGenerator.generateId());

            //商品状态为上架
            productPO.setProductStatus(ProductEnum.PRODUCT_STATUS_UP);

            //发布
            sellerService.productRelease(productPO);

        }catch (Exception e){
            throw new RuntimeException("发布商品发生异常: {}",e);
        }
        return true;
    }

    public void checkProductInfo(ProductPO productPO){
        if (Objects.isNull(productPO.getSellerId()) ||
                Objects.isNull(productPO.getProductPrice()) || Objects.isNull(productPO.getProductName())){
            throw new RuntimeException("商品信息校验不通过，请检查商品信息");
        }
    }
}
