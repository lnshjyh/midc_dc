-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('17', '#', 'dict', '数据字典', '0', null, 'Y', '0', '2016-11-27 12:38:33', null, '2016-11-27 12:38:33', null, '');
INSERT INTO `sys_dict` VALUES ('26', '17', 'test', '测试', '0', null, 'Y', '0', '2016-11-30 13:35:52', null, '2016-11-30 13:35:52', null, null);
INSERT INTO `sys_dict` VALUES ('27', '17', 'sex', '性别', '0', null, 'Y', '0', '2016-11-30 13:40:10', null, '2016-11-30 13:40:10', null, null);
INSERT INTO `sys_dict` VALUES ('28', '27', 'nanxing', '男性', '0', null, 'N', '0', '2016-11-30 13:42:16', null, '2016-12-04 12:24:54', null, null);
INSERT INTO `sys_dict` VALUES ('29', '27', 'nvxing', '女性', '0', null, 'N', '0', '2016-12-04 12:24:11', null, '2016-12-04 12:24:11', null, null);
INSERT INTO `sys_dict` VALUES ('30', '26', 'test1', 'test1', '0', null, 'Y', '0', '2017-02-26 16:06:38', null, '2017-02-26 16:06:38', null, null);
INSERT INTO `sys_dict` VALUES ('31', '30', 'aaa', 'aaa', '0', null, 'N', '0', '2017-02-26 16:07:08', null, '2017-02-26 16:07:08', null, null);

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
-- update @17-5-3
DELETE FROM `sys_menu` ;

INSERT INTO `sys_menu` VALUES ('1', '1', '系统管理', null, '0', 'icon-desktop', '1', '2', '#', null, '0', '0', '2016-05-16 17:10:44', '0', '2016-06-02 21:01:12', null);
INSERT INTO `sys_menu` VALUES ('4', '4', '菜单管理', '/menu/listPage', '0', 'icon-sitemap', '1', '4', '1', '系统管理', '0', '0', '2016-05-06 14:35:51', '0', '2016-05-15 21:23:15', '菜单管理');
INSERT INTO `sys_menu` VALUES ('38', '23', '登录日志', '/loginLog/listPage', '0', 'icon-tasks', '1', null, '1', '系统管理', '0', null, '2016-06-26 16:07:57', null, '2016-06-26 16:07:57', '登录日志');
INSERT INTO `sys_menu` VALUES ('39', '24', '操作日志', '/webLog/list', '0', 'icon-print', '1', null, '1', '系统管理', '0', null, '2016-06-26 16:11:30', null, '2016-06-26 16:11:30', null);
INSERT INTO `sys_menu` VALUES ('41', '1478700606660', '字典管理', '/dict/list', '0', 'icon-screenshot', '1', null, '1', '系统管理', '0', null, '2016-11-09 12:42:21', null, '2016-11-09 12:42:21', '字典管理');


INSERT INTO `sys_menu` VALUES ('19', '5', '业务管理', null, '0', 'icon-credit-card', '1', '1', '#', null, '0', null, '2016-05-22 11:17:51', null, '2016-06-02 23:09:38', null);
INSERT INTO `sys_menu` VALUES ('2', '2', '用户管理', '/user/listPage', '0', 'icon-user', '1', '2', '5', '业务管理', '0', '0', '2016-05-06 14:34:37', '0', '2016-06-02 22:44:56', '用户管理');
INSERT INTO `sys_menu` VALUES ('3', '3', '角色管理', '/role/listPage', '0', 'icon-magnet', '1', '3', '5', '业务管理', '0', '0', '2016-05-06 14:35:24', '0', '2016-05-17 14:14:34', '角色管理');
-- update @17-3-25
INSERT INTO `sys_menu` VALUES ('58', '58', '医疗机构管理', '/hospital/listPage', '0', 'icon-screenshot', '1', null, '5', '业务管理', '0', null, '2017-03-21 13:47:15', null, '2017-03-21 13:47:15', '');
INSERT INTO `sys_menu` VALUES ('59', '59', '检查项管理', '/checkitem/listPage', '0', 'icon-beer', '1', null, '5', '业务管理', '0', null, '2017-03-25 11:07:50', null, '2017-03-25 11:07:50', null);
INSERT INTO `sys_menu` VALUES ('60', '60', '检查部位管理', '/positionType/listPage', '0', 'icon-book', '1', null, '5', '业务管理', '0', null, '2017-03-25 11:09:06', null, '2017-03-25 11:09:06', null);
INSERT INTO `sys_menu` VALUES ('61', '61', '设备类型管理', '/deviceType/listPage', '0', 'icon-book', '1', null, '5', '业务管理', '0', null, '2017-03-25 11:09:31', null, '2017-03-25 11:09:31', null);
-- update @17-4-5
INSERT INTO `sys_menu` VALUES ('62', '62', '设备关联管理', '/devicetypePC/listPage', '0', 'icon-book', '1', null, '5', '业务管理', '0', '0', '2017-04-05 20:44:42', '0', '2017-04-05 20:44:57', null);
-- update @17-4-17
INSERT INTO `sys_menu` VALUES ('63', '63', '患者管理', '/patlist/listPage', '0', 'icon-book', '1', null, '5', '业务管理', '0', '0', '2017-04-17 22:44:42', '0', '2017-04-17 22:44:57', null);
-- update @17-5-12
INSERT INTO `sys_menu` VALUES ('65', '65', '存储管理', '/storage/listPage', '0', 'icon-hdd', '1', null, '1', '系统管理', '0', '0', '2017-05-12 10:13:42', '0', '2017-05-12 10:13:42', null);






-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN', '超级管理员');
INSERT INTO `sys_role` VALUES ('2', 'ROLE_JUNIOR_DOC', '一线医生');
INSERT INTO `sys_role` VALUES ('3', 'ROLE_SENIOR_DOC', '二线医生');

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('961', 'ROLE_ADMIN', '22', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('962', 'ROLE_ADMIN', '12', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('963', 'ROLE_ADMIN', '23', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('964', 'ROLE_ADMIN', '1479220072000', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('965', 'ROLE_ADMIN', '13', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('966', 'ROLE_ADMIN', '24', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('967', 'ROLE_ADMIN', '14', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('968', 'ROLE_ADMIN', '16', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('969', 'ROLE_ADMIN', '1480224173523', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('970', 'ROLE_ADMIN', '1479220122402', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('971', 'ROLE_ADMIN', '1479219411962', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('972', 'ROLE_ADMIN', '1478700606660', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('973', 'ROLE_ADMIN', '1', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('974', 'ROLE_ADMIN', '2', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('975', 'ROLE_ADMIN', '3', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('976', 'ROLE_ADMIN', '4', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('977', 'ROLE_ADMIN', '5', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('978', 'ROLE_ADMIN', '1480254855433', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('979', 'ROLE_ADMIN', '1480978838674', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('980', 'ROLE_ADMIN', '20', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('981', 'ROLE_ADMIN', '1479219651971', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('982', 'ROLE_ADMIN', '1479219802326', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);
INSERT INTO `sys_role_menu` VALUES ('983', 'ROLE_ADMIN', '21', '0', '2016-11-27 12:26:44', null, '2016-11-27 12:26:44', null, null);

-- update @17-3-25
INSERT INTO `sys_role_menu` VALUES ('1034', 'ROLE_ADMIN', '60', '0', '2017-03-25 11:09:58', null, '2017-03-25 11:09:58', null, null);
INSERT INTO `sys_role_menu` VALUES ('1011', 'ROLE_ADMIN', '58', '0', '2017-03-25 11:09:57', null, '2017-03-25 11:09:57', null, null);
INSERT INTO `sys_role_menu` VALUES ('1012', 'ROLE_ADMIN', '59', '0', '2017-03-25 11:09:57', null, '2017-03-25 11:09:57', null, null);
INSERT INTO `sys_role_menu` VALUES ('1022', 'ROLE_ADMIN', '61', '0', '2017-03-25 11:09:57', null, '2017-03-25 11:09:57', null, null);
-- update @17-4-5
INSERT INTO `sys_role_menu` VALUES ('1059', 'ROLE_ADMIN', '62', '0', '2017-04-05 12:49:55', null, '2017-04-05 12:49:55', null, null);
-- update @17-4-17
INSERT INTO `sys_role_menu` VALUES ('1063', 'ROLE_ADMIN', '63', '0', '2017-04-17 22:49:55', null, '2017-04-17 22:49:55', null, null);
-- update @17-5-12
INSERT INTO `sys_role_menu` VALUES ('1065', 'ROLE_ADMIN', '65', '0', '2017-05-12 12:49:55', null, '2017-05-12 12:49:55', null, null);

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', 'admin', 'admin', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2016-04-15 11:23:23', null, '123456@qq.com', '13428281893', '0', '0', '2017-02-27 15:37:31', '0:0:0:0:0:0:0:1', '0', '2016-04-15 11:23:38', null, '2016-05-12 17:28:04', null, null);

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', 'ROLE_ADMIN', '0', '2016-04-15 14:48:11', '0', '2016-04-15 14:48:13', '0', null);
