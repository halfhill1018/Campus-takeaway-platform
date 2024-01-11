package com.graduation.campustakeawayplatform.domain.service.impl;

import com.graduation.campustakeawayplatform.common.enu.ProductEnum;
import com.graduation.campustakeawayplatform.common.hutool.IdGenerator;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.service.SellerService;
import com.graduation.campustakeawayplatform.domain.service.SellerDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

            //是否为已经下架过的商品又重新上架的
            if (!StringUtils.isEmpty(productPO.getId())){

                this.checkProductReUptInfo(productPO); //必要信息校验
                //商品id不为空就是重新上架
                return sellerService.updateProductStatus(ProductEnum.PRODUCT_STATUS_UP,productPO.getId(),productPO.getSellerId());

            }else {

                //检查信息合法性
                this.checkProductInfo(productPO);

                //生成商品id
                productPO.setId(idGenerator.generateId());

                //商品状态为上架
                productPO.setProductStatus(ProductEnum.PRODUCT_STATUS_UP);

                //发布
                sellerService.productRelease(productPO);
            }

        }catch (Exception e){
            throw new RuntimeException("发布商品发生异常: {}",e);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean productDown(String productId, String sellerId) {
       return sellerService.updateProductStatus(ProductEnum.PRODUCT_STATUS_DOWN,productId,sellerId);

    }

    public void checkProductInfo(ProductPO productPO){
        if (Objects.isNull(productPO.getSellerId()) ||
                Objects.isNull(productPO.getProductPrice()) || Objects.isNull(productPO.getProductName())){
            throw new RuntimeException("商品信息校验不通过，请检查商品信息");
        }
    }

    /**
     * 重新上架时的检查
     * @param productPO
     */
    public void checkProductReUptInfo(ProductPO productPO){
        // 校验数据库此商品状态是否就是下架
        if (Objects.isNull(productPO.getSellerId()) ||
                Objects.isNull(productPO.getId()) ||
                sellerService.checkProductStatus(productPO.getId())){
            throw new RuntimeException("商品信息校验不通过，请检查商品信息");
        }
    }

}
