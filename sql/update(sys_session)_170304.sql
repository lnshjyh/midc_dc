/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : jlight

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-03-05 02:09:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_session`
-- ----------------------------
DROP TABLE IF EXISTS `sys_session`;
CREATE TABLE `sys_session` (
  `sessionid` varchar(100) NOT NULL,
  `session` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_session
-- ----------------------------
