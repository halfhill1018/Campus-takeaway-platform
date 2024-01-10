CREATE TABLE `product` (
                           `id` varchar(255) NOT NULL COMMENT '主键',
                           `product_name` varchar(128) NOT NULL COMMENT '商品名',
                           `product_type` varchar(128) NOT NULL COMMENT '商品分类',
                           `product_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
                           `product_price` decimal(65,2) NOT NULL COMMENT '商品价格',
                           `product_nventory` varchar(255) NOT NULL COMMENT '商品库存',
                           `product_snapshot` varchar(255) DEFAULT NULL COMMENT '商品快照id',
                           `create_date` datetime NOT NULL default  CURRENT_TIMESTAMP COMMENT '创建时间',
                           `last_update_date` datetime NOT NULL default  CURRENT_TIMESTAMP COMMENT '最后更新时间',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;