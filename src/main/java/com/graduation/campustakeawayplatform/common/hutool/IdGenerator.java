package com.graduation.campustakeawayplatform.common.hutool;

/**
 * @author hzt
 * @version 1.0
 * @date 2023/12/31 20:00
 */
import cn.hutool.core.lang.Snowflake;
import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

    private final Snowflake snowflake;

    public IdGenerator() {
        // 参数1是机器ID，参数2是数据中心ID
        this.snowflake = new Snowflake(1, 1);
    }

    public String generateId() {
        return String.valueOf(snowflake.nextId());
    }
}

