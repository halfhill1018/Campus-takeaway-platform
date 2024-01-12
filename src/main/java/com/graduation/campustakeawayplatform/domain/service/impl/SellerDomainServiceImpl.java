package com.graduation.campustakeawayplatform.domain.service.impl;

import com.graduation.campustakeawayplatform.common.caffeine.CaffeineCacheUtil;
import com.graduation.campustakeawayplatform.common.enu.ProductEnum;
import com.graduation.campustakeawayplatform.common.hutool.IdGenerator;
import com.graduation.campustakeawayplatform.common.jwt.JwtUtil;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.PO.SellerPO;
import com.graduation.campustakeawayplatform.domain.repository.service.SellerService;
import com.graduation.campustakeawayplatform.domain.repository.service.UserService;
import com.graduation.campustakeawayplatform.domain.service.SellerDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author qinziwen
 * @Date 2024/1/10 19:15
 * @Describe 领域层，负责操作领域，返回的是整个领域模型
 *
 */
@Service
public class SellerDomainServiceImpl implements SellerDomainService {

    Logger logger = LoggerFactory.getLogger(SellerDomainServiceImpl.class);


    @Resource
    SellerService sellerService;

    @Resource
    IdGenerator idGenerator;

    @Resource
    CaffeineCacheUtil caffeineCache;

    @Resource
    UserService userService;

    @Override
    @Transactional
    public boolean ProductRelease(ProductPO productPO) {
        try {

            //是否为已经下架过的商品又重新上架的
            if (!StringUtils.isEmpty(productPO.getId())){

                this.checkProductReUptInfo(productPO); //必要信息校验

                //商品id不为空就是重新上架
                boolean releaseResult = sellerService.updateProductStatus(ProductEnum.PRODUCT_STATUS_UP, productPO.getId(), productPO.getSellerId());

                //清除查询缓存
                caffeineCache.evictKeysWithPrefix(CaffeineCacheUtil.DEFAULT_CACHE_NAME,"productCache");

                return releaseResult;


            }else {

                //检查信息合法性
                this.checkProductInfo(productPO);

                //生成商品id
                productPO.setId(idGenerator.generateId());

                //商品状态为上架
                productPO.setProductStatus(ProductEnum.PRODUCT_STATUS_UP);

                //发布
                sellerService.productRelease(productPO);

                //清除查询缓存
                caffeineCache.evictKeysWithPrefix(CaffeineCacheUtil.DEFAULT_CACHE_NAME,"productCache");
            }

        }catch (Exception e){
            throw new RuntimeException("发布商品发生异常: {}",e);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean productDown(String productId, String sellerId) {

        //下架
        boolean downResult = sellerService.updateProductStatus(ProductEnum.PRODUCT_STATUS_DOWN, productId, sellerId);

        //清除查询缓存
        caffeineCache.evictKeysWithPrefix(CaffeineCacheUtil.DEFAULT_CACHE_NAME,"productCache");

        return downResult;


    }

    @Override
    public boolean userToSeller(String token, SellerPO sellerPO) {

        //解析token得到用户名
        String verifyToken = JwtUtil.verifyToken(token);

        //校验用户名是否存在
        boolean verifyResult = userService.verifyUserCount(verifyToken);
        if (!verifyResult){
            logger.info("用户名不存在");
            return false;
        }

        //查询用户id
        String userId = userService.selectUserId(verifyToken);
        sellerPO.setUserId(userId);
        sellerPO.setId(idGenerator.generateId());

        //卖家数据写库
        boolean initSellerInfoResult = sellerService.initSellerInfo(sellerPO);
        if (!initSellerInfoResult){
            return false;
        }
        return true;
    }

    /**
     * 第一次上架时的检查
     * @param productPO
     */
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
