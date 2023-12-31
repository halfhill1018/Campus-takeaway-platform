-- 卖家表
create table seller (
                        id varchar(255) NOT NULL COMMENT 'id',
                        user_id varchar(255) NOT NULL COMMENT '用户id',
                        shop_name varchar(255) NOT NULL  COMMENT '店铺名称',
                        shop_type varchar(255) NOT NULL COMMENT '店铺类型，如小吃，粉',
                        authentication_flag tinyint(1) NOT NULL COMMENT '认证状态',
                        business_license varchar(128) NOT NULL COMMENT '营业执照',
                        `create_date` datetime NOT NULL default  CURRENT_TIMESTAMP COMMENT '创建时间',
                        `last_update_date` datetime NOT NULL default  CURRENT_TIMESTAMP COMMENT '最后更新时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

