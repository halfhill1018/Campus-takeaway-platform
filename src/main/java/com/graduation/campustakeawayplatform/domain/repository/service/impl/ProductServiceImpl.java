package com.graduation.campustakeawayplatform.domain.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduation.campustakeawayplatform.domain.repository.PO.ProductPO;
import com.graduation.campustakeawayplatform.domain.repository.service.ProductService;
import com.graduation.campustakeawayplatform.domain.repository.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author huangshen
* @description 针对表【product】的数据库操作Service实现
* @createDate 2024-01-10 18:58:37
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductPO>
    implements ProductService{

}




