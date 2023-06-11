SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_user_info
-- ----------------------------
DROP TABLE IF EXISTS `db_user_info`;
CREATE TABLE `db_user_info`
(
    `user_id`         varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '用户ID',
    `nick_name`       varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '用户昵称',
    `email`           varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
    `qq_open_id`      varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '用户关联QQ开放ID',
    `qq_avatar`       varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
    `password`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '用户密码',
    `join_time`       datetime                                                      NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户创建时间',
    `last_login_time` datetime                                                      NULL DEFAULT NULL COMMENT '用户最后一次登录时间',
    `status`          tinyint(1)                                                    NULL DEFAULT NULL COMMENT '用户状态:0:禁用 1:启用',
    `user_space`      bigint(20)                                                    NULL DEFAULT NULL COMMENT '用户使用空间',
    `total_space`     bigint(20)                                                    NULL DEFAULT NULL COMMENT '用户总空间',
    PRIMARY KEY (`user_id`) USING BTREE,
    UNIQUE INDEX `key_email` (`email`) USING BTREE COMMENT '用户邮箱唯一',
    UNIQUE INDEX `key_qq_open_id` (`qq_open_id`) USING BTREE COMMENT '用户关联QQopenid唯一',
    UNIQUE INDEX `key_nick_name` (`nick_name`) USING BTREE COMMENT '用户昵称唯一'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for db_email_code
-- ----------------------------
DROP TABLE IF EXISTS `db_email_code`;
CREATE TABLE `db_email_code`
(
    `email`       varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱号码',
    `code`        varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   NOT NULL COMMENT '编号',
    `create_time` datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `status`      tinyint(1) UNSIGNED ZEROFILL                                  NULL DEFAULT NULL COMMENT '状态 0:未使用 1:已使用',
    PRIMARY KEY (`email`, `code`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '邮箱验证码表'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
