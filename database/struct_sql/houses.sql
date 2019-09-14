/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : houses

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-04-11 15:08:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for community
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_code` varchar(11) NOT NULL DEFAULT '' COMMENT '城市编码',
  `city_name` varchar(11) NOT NULL DEFAULT '' COMMENT '城市名称',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '小区名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小区表';

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '房屋名字',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1销售2出租',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '单位：元',
  `images` varchar(1024) NOT NULL DEFAULT '' COMMENT '图片地址',
  `area` int(11) NOT NULL DEFAULT '0' COMMENT '面积',
  `beds` int(11) NOT NULL DEFAULT '0' COMMENT '卧室数',
  `baths` int(11) NOT NULL DEFAULT '0' COMMENT '卫生间数',
  `remarks` varchar(512) NOT NULL DEFAULT '' COMMENT '房屋描述',
  `floor_plan` varchar(255) NOT NULL DEFAULT '' COMMENT '户型图地址',
  `tags` varchar(20) NOT NULL DEFAULT '' COMMENT '标签',
  `create_time` datetime NOT NULL DEFAULT '2019-01-01 00:00:00' COMMENT '创建时间',
  `city_id` int(11) NOT NULL DEFAULT '0' COMMENT '城市名称',
  `community_id` int(11) NOT NULL DEFAULT '0' COMMENT '小区名称',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1上架2下架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for house_user
-- ----------------------------
DROP TABLE IF EXISTS `house_user`;
CREATE TABLE `house_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_id` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT '2019-01-01 00:00:00' COMMENT '创建时间',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1售卖 2收藏',
  PRIMARY KEY (`id`),
  KEY `house_id_user_id_type` (`house_id`,`user_id`,`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维护房产和用户的关系';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `phone` char(13) NOT NULL DEFAULT '' COMMENT '电话',
  `email` varchar(90) NOT NULL DEFAULT '' COMMENT '电子邮件地址',
  `aboutme` varchar(255) NOT NULL DEFAULT '' COMMENT '自我介绍',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '经过md5加密的密码',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '头像',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '类型 1普通用户 2房产经纪人',
  `create_time` datetime NOT NULL DEFAULT '2019-01-01 00:00:00' COMMENT '创建时间',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用 1启用 0停用',
  PRIMARY KEY (`id`),
  KEY ` idx_email` (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
