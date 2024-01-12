package com.graduation.campustakeawayplatform.domain.service.impl;

import cn.hutool.core.lang.TypeReference;
import com.alibaba.fastjson2.JSON;
import com.graduation.campustakeawayplatform.common.Reuqest.RequestPageParam;
import com.graduation.campustakeawayplatform.common.caffeine.CaffeineCacheUtil;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.service.ProductService;
import com.graduation.campustakeawayplatform.domain.repository.service.SellerService;
import com.graduation.campustakeawayplatform.domain.service.ProductDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author qinziwen
 * @Date 2024/1/11 15:58
 * @Describe
 */
@Service
@CacheConfig(cacheNames = "caffeineCacheManager")
public class ProductDomainServiceImpl implements ProductDomainService {

    Logger logger = LoggerFactory.getLogger(ProductDomainServiceImpl.class);

    @Resource
    ProductService productService;

    @Resource
    SellerService sellerService;

    @Resource
    CaffeineCacheUtil caffeineCache;

    @Override
    public List<ProductPO> selectAllProduct(RequestPageParam pageParam) {

        List<ProductPO> productPOS = null;
        //生成缓存key
        String key = "productCache"+pageParam.getPageNo()+pageParam.getPageSize();
        String value = (String) caffeineCache.get(key);

        if (StringUtils.isEmpty(value)){
             productPOS = productService.selectAllProduct(pageParam);
            //首次查询放入缓存
            caffeineCache.put(CaffeineCacheUtil.DEFAULT_CACHE_NAME,"productCache"+pageParam.getPageNo()+pageParam.getPageSize(),JSON.toJSONString(productPOS),3600);
        }else {
            logger.info("select All product get cache >>>>>>>>>>");
            //缓存中有的话直接反序列化成对象
            productPOS = JSON.parseArray(value, ProductPO.class);
        }
        return productPOS;
    }

    @Override
    public List<ProductPO> selectProductByShopName(String shopName) {

        //先根据店铺名去卖家表查卖家id
        String sellerId = sellerService.selectSellerIdByShopName(shopName);
        if (sellerId.isEmpty()){
            return null;
        }
        //根据卖家id去寻找商品表里的所有商品
        return productService.selectProductBySeller(sellerId);

    }
}
