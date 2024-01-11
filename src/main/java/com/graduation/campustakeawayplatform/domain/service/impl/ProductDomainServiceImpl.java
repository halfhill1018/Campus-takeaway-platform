package com.graduation.campustakeawayplatform.domain.service.impl;

import cn.hutool.core.lang.TypeReference;
import com.alibaba.fastjson2.JSON;
import com.graduation.campustakeawayplatform.common.Reuqest.RequestPageParam;
import com.graduation.campustakeawayplatform.common.caffeine.CaffeineCacheUtil;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.service.ProductService;
import com.graduation.campustakeawayplatform.domain.service.ProductDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
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
    CaffeineCacheUtil caffeineCache;

    @Override
    public List<ProductPO> selectAllProduct(RequestPageParam pageParam) {
        List<ProductPO> productPOS = null;
        String key = "selectAllProduct"+pageParam.getPageNo()+pageParam.getPageSize();
        String value = (String) caffeineCache.get(key);

        if (StringUtils.isEmpty(value)){
             productPOS = productService.selectAllProduct(pageParam);
            //首次查询放入缓存
            caffeineCache.put(CaffeineCacheUtil.DEFAULT_CACHE_NAME,"selectAllProduct"+pageParam.getPageNo()+pageParam.getPageSize(),JSON.toJSONString(productPOS),3600);
        }else {
            //缓存中有的话直接反序列化成对象
            productPOS = JSON.parseArray(value, ProductPO.class);
        }
        return productPOS;
    }
}
