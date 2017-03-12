/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : midc_dc

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-03-11 23:38:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` varchar(64) DEFAULT NULL,
  `org_id` varchar(255) DEFAULT NULL,
  `org_name` varchar(255) DEFAULT NULL,
  `seq` tinyint(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT 'HOS:医院 BASIC:基层医院',
  `is_delete` tinyint(1) NOT NULL COMMENT '软删除标识',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
