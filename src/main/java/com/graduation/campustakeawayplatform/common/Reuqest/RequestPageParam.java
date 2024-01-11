package com.graduation.campustakeawayplatform.common.Reuqest;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author qinziwen
 * @Date 2024/1/11 15:43
 * @Describe
 */
@Data
@Accessors(chain = true)
public class RequestPageParam {

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 每页大小
     */
    private Integer pageSize;

    public void initPageParams(){
        this.pageNo = this.getPageNo() - 1 ;
    }
}
