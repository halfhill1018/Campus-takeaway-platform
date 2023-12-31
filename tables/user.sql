-- 用户表
CREATE TABLE `user` (
                        `id` varchar(255) NOT NULL COMMENT '主键',
                        `login_name` varchar(255) NOT NULL COMMENT '登录名',
                        `pass_word` varchar(255) NOT NULL COMMENT '密码',
                        `sex` tinyint(1) NOT NULL COMMENT '性别 1：男   2： 女',
                        `address` varchar(255) NOT NULL COMMENT '收货地址',
                        `enable_flag` tinyint(1) NOT NULL COMMENT '启用： 0，锁定： 1',
                        `user_type` tinyint(1) NOT NULL COMMENT '用户类型 1：学生 2： 老师',
                        `create_date` datetime NOT NULL default  CURRENT_TIMESTAMP COMMENT '创建时间',
                        `last_update_date` datetime NOT NULL default  CURRENT_TIMESTAMP COMMENT '最后更新时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

