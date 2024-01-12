package com.graduation.campustakeawayplatform.common.caffeine;

/**
 * @Author HuangShen
 * @Date 2024/1/11 17:47
 * @Describe
 */
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

@Component
public class CaffeineCacheUtil {

    public static final String DEFAULT_CACHE_NAME = "defaultCache";

    private static final long DEFAULT_EXPIRE_SECONDS = 300; // 默认过期时间为5分钟

    private final CacheManager cacheManager;

    public CaffeineCacheUtil(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    private Cache getCaffeineCache(String cacheName) {
        return cacheManager.getCache(cacheName);
    }

    /**
     * 将数据放入缓存
     *
     * @param key           缓存键
     * @param value         缓存值
     */
    public void put(String key, Object value) {
        put(DEFAULT_CACHE_NAME, key, value, DEFAULT_EXPIRE_SECONDS);
    }

    /**
     * 将数据放入指定缓存
     *
     * @param cacheName     缓存名称
     * @param key           缓存键
     * @param value         缓存值
     * @param expireSeconds 过期时间（秒）
     */
    public void put(String cacheName, String key, Object value, long expireSeconds) {
        Cache caffeineCache = getCaffeineCache(cacheName);
        if (caffeineCache != null) {
            // 放入缓存
            caffeineCache.put(key, value);
            if (expireSeconds > 0) {
                // 设置过期时间
                Caffeine<Object, Object> caffeineBuilder = Caffeine.newBuilder()
                        .expireAfterWrite(expireSeconds, TimeUnit.SECONDS);
                ((com.github.benmanes.caffeine.cache.Cache<Object, Object>) caffeineCache.getNativeCache())
                        .policy().eviction().get().setMaximum(1); // 设置最大条目数，用于触发过期
            }
        }
    }

    /**
     * 从默认缓存中获取数据
     *
     * @param key 缓存键
     * @return 缓存值
     */
    public Object get(String key) {
        return get(DEFAULT_CACHE_NAME, key);
    }

    /**
     * 从指定缓存中获取数据
     *
     * @param cacheName 缓存名称
     * @param key       缓存键
     * @return 缓存值
     */
    public Object get(String cacheName, String key) {
        Cache caffeineCache = getCaffeineCache(cacheName);
        return (caffeineCache != null) ? caffeineCache.get(key, Object.class) : null;
    }

    /**
     * 从默认缓存中移除数据
     *
     * @param key 缓存键
     */
    public void evict(String key) {
        evict(DEFAULT_CACHE_NAME, key);
    }

    /**
     * 从指定缓存中移除数据
     *
     * @param cacheName 缓存名称
     * @param key       缓存键
     */
    public void evict(String cacheName, String key) {
        Cache caffeineCache = getCaffeineCache(cacheName);
        if (caffeineCache != null) {
            // 移除缓存数据
            caffeineCache.evict(key);
        }
    }


    /**
     * 删除指定前缀开头的所有缓存键值对
     *
     * @param cacheName 缓存名称
     * @param keyPrefix  前缀
     */
    public void evictKeysWithPrefix(String cacheName, String keyPrefix) {
        Cache caffeineCache = getCaffeineCache(cacheName);
        if (caffeineCache != null) {
            // 获取Caffeine原生缓存对象
            com.github.benmanes.caffeine.cache.Cache nativeCache = (com.github.benmanes.caffeine.cache.Cache) caffeineCache.getNativeCache();

            // 迭代处理缓存键，删除符合前缀条件的键值对
            Iterator<Object> iterator = nativeCache.asMap().keySet().iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                if (key instanceof String && ((String) key).startsWith(keyPrefix)) {
                    iterator.remove(); // 删除匹配前缀的键
                    nativeCache.invalidate(key); // 同时删除对应的值
                }
            }
        }
    }



}


