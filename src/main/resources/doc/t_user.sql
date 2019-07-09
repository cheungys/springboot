/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : cloud

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-14 15:35:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `identity_card` varchar(30) DEFAULT NULL COMMENT '身份证',
  `card_type` varchar(10) DEFAULT NULL COMMENT '证件类型',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建人',
  `modify_time` varchar(20) DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `deltag` tinyint(1) DEFAULT '0' COMMENT '删除标识',
  `v_code` varchar(20) DEFAULT NULL COMMENT '验证码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
