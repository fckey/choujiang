/*
 Navicat Premium Data Transfer

 Source Server         : MySQL8.0-localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : choujiang

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 14/06/2022 14:28:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cj_draw
-- ----------------------------
DROP TABLE IF EXISTS `cj_draw`;
CREATE TABLE `cj_draw`  (
  `draw_id` int NOT NULL COMMENT '唯一标识某次抽签',
  `draw_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述抽签的内容',
  `draw_num` int NULL DEFAULT NULL COMMENT '签子的数量',
  `draw_luck` int NULL DEFAULT NULL COMMENT '中奖的数量',
  PRIMARY KEY (`draw_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cj_draw
-- ----------------------------

-- ----------------------------
-- Table structure for cj_draw_record
-- ----------------------------
DROP TABLE IF EXISTS `cj_draw_record`;
CREATE TABLE `cj_draw_record`  (
  `record_id` int NOT NULL COMMENT '唯一标识某次抽签活动',
  `draw_id` int NULL DEFAULT NULL COMMENT '表示此签归属的活动',
  `record_rand` int NULL DEFAULT NULL COMMENT '随机数，唯一表示改签的签号',
  `record_issused` int NULL DEFAULT 0 COMMENT ' 0 表示没有被人抽，1表示签等待确认状态 2 表示确认被抽',
  `record_status` int NULL DEFAULT NULL COMMENT '0 表示改签是有效签 ',
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cj_draw_record
-- ----------------------------

-- ----------------------------
-- Table structure for cj_organization
-- ----------------------------
DROP TABLE IF EXISTS `cj_organization`;
CREATE TABLE `cj_organization`  (
  `org_code` int NOT NULL DEFAULT 0 COMMENT '主键，单位代码，键表示唯一',
  `org_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '单位名称',
  `org_quota` int UNSIGNED NULL DEFAULT 0 COMMENT '单位配额',
  `org_joined` int NULL DEFAULT NULL COMMENT '0 代表没有参加， 1 代表参加',
  PRIMARY KEY (`org_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cj_organization
-- ----------------------------
INSERT INTO `cj_organization` VALUES (1, 'xx开发公司', NULL, NULL);
INSERT INTO `cj_organization` VALUES (2, 'yy开发公司', NULL, NULL);

-- ----------------------------
-- Table structure for cj_user
-- ----------------------------
DROP TABLE IF EXISTS `cj_user`;
CREATE TABLE `cj_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '主键，表示用户的唯一id',
  `user_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名称',
  `user_pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户密码',
  `org_code` int NULL DEFAULT NULL COMMENT '单位代码，表示该用户所属的单位',
  `user_role` int NULL DEFAULT NULL COMMENT '用户角色 | 0 ，表示普通用户| 1 表示管理员',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cj_user
-- ----------------------------
INSERT INTO `cj_user` VALUES (1, 'zhangsan', 'zhangsan123', 12321, 1);
INSERT INTO `cj_user` VALUES (2, 'lisi', 'lisi123', 2, 1);
INSERT INTO `cj_user` VALUES (3, 'wangwu', 'wangwu123', 0, 0);
INSERT INTO `cj_user` VALUES (4, 'fangshaolei', 'ef63227abb102d7a74b06f4fdfee44f8', NULL, 0);

-- ----------------------------
-- Table structure for cj_user_record
-- ----------------------------
DROP TABLE IF EXISTS `cj_user_record`;
CREATE TABLE `cj_user_record`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '该记录的唯一标识',
  `user_id` int NOT NULL COMMENT '外键，指向用户id',
  `draw_id` int NULL DEFAULT NULL COMMENT '外键，指向抽签的签id',
  `record_id` int NULL DEFAULT NULL COMMENT '外键，指向某次活动',
  `date` datetime NULL DEFAULT NULL COMMENT '抽签的日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cj_user_record
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
