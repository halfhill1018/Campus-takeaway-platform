-- 订单主表
create table order_main (
                            id varchar(255) NOT NULL COMMENT '订单id',
                            order_number varchar(255) NOT NULL COMMENT '订单号',
                            buyer_id varchar(255) NOT NULL COMMENT '买家id',
                            seller_id varchar(255) NOT NULL COMMENT '卖家id',
                            order_status varchar(128) NOT NULL COMMENT '订单状态',
                            order_type varchar(128) NOT NULL COMMENT '订单类型',
                            order_snapshot_id varchar(128) NOT NULL COMMENT '订单快照id',
                            `create_date` datetime NOT NULL default  CURRENT_TIMESTAMP COMMENT '创建时间',
                            `last_update_date` datetime NOT NULL default  CURRENT_TIMESTAMP COMMENT '最后更新时间',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;