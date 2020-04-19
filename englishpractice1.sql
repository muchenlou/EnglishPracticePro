/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : englishpractice1

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 19/04/2020 14:53:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_curriculum
-- ----------------------------
DROP TABLE IF EXISTS `tb_curriculum`;
CREATE TABLE `tb_curriculum`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `type_id` int(12) NOT NULL COMMENT '类型ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_type`;
CREATE TABLE `tb_type`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `new_time` datetime(0) NOT NULL COMMENT '注册时间',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, '张三', '123456', '2020-04-19 13:39:04', '13169113260');
INSERT INTO `tb_user` VALUES (2, '??', 'javase520', '2020-04-19 06:50:11', '17602051787');

-- ----------------------------
-- Table structure for tb_user_curriculum
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_curriculum`;
CREATE TABLE `tb_user_curriculum`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(12) NOT NULL COMMENT '用户id',
  `curriculum_id` int(12) NOT NULL COMMENT '课程id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与课程关联表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_word
-- ----------------------------
DROP TABLE IF EXISTS `tb_word`;
CREATE TABLE `tb_word`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `english` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '英语单词',
  `chinase` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '汉语单词',
  `curriculum_id` int(12) NOT NULL COMMENT '课程ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '单词表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
