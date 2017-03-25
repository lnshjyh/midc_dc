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
INSERT INTO `sys_menu` VALUES ('1', '1', '系统管理', null, '0', 'icon-desktop', '1', '1', '#', null, '0', '0', '2016-05-16 17:10:44', '0', '2016-06-02 21:01:12', null);
INSERT INTO `sys_menu` VALUES ('2', '2', '用户管理', '/user/listPage', '0', 'icon-user', '1', '2', '1', '基础管理', '0', '0', '2016-05-06 14:34:37', '0', '2016-06-02 22:44:56', '用户管理');
INSERT INTO `sys_menu` VALUES ('3', '3', '角色管理', '/role/listPage', '0', 'icon-magnet', '1', '3', '1', '基础管理', '0', '0', '2016-05-06 14:35:24', '0', '2016-05-17 14:14:34', '角色管理');
INSERT INTO `sys_menu` VALUES ('4', '4', '菜单管理', '/menu/listPage', '0', 'icon-sitemap', '1', '4', '1', '基础管理', '0', '0', '2016-05-06 14:35:51', '0', '2016-05-15 21:23:15', '菜单管理');
INSERT INTO `sys_menu` VALUES ('19', '5', '日志管理', null, '0', 'icon-credit-card', '1', '5', '#', null, '0', null, '2016-05-22 11:17:51', null, '2016-06-02 23:09:38', null);
INSERT INTO `sys_menu` VALUES ('26', '12', '添加', '/user/add', '1', null, '1', null, '2', '用户管理', '0', null, '2016-06-02 21:00:09', null, '2016-06-02 21:00:09', '添加用户');
INSERT INTO `sys_menu` VALUES ('27', '13', '修改', '/user/edit', '1', null, '1', null, '2', '用户管理', '0', null, '2016-06-02 22:39:47', null, '2016-06-02 22:39:47', '编辑用户');
INSERT INTO `sys_menu` VALUES ('29', '14', '添加', '/role/add', '1', null, '1', null, '3', '角色管理', '0', null, '2016-06-09 00:04:16', null, '2016-06-09 00:04:16', '');
INSERT INTO `sys_menu` VALUES ('31', '16', '分配权限', '/roleRes/save', '1', null, '1', null, '3', '角色管理', '0', null, '2016-06-26 12:11:55', null, '2016-06-26 12:11:55', '保存分配的权限');
INSERT INTO `sys_menu` VALUES ('32', '17', '添加', '/menu/add', '1', null, '1', null, '4', '资源管理', '0', null, '2016-06-26 15:51:06', null, '2016-06-26 15:51:06', '添加资源');
INSERT INTO `sys_menu` VALUES ('33', '18', '修改', '/menu/edit', '1', null, '1', null, '4', '资源管理', '0', null, '2016-06-26 15:52:13', null, '2016-06-26 15:52:13', '修改资源');
INSERT INTO `sys_menu` VALUES ('34', '19', '删除', '/menu/delete', '1', null, '1', null, '4', '资源管理', '0', null, '2016-06-26 15:53:14', null, '2016-06-26 15:53:14', '删除资源');
INSERT INTO `sys_menu` VALUES ('35', '20', '删除', '/user/delete', '1', null, '1', null, '2', '用户管理', '0', null, '2016-06-26 15:56:07', null, '2016-06-26 15:56:07', '删除用户');
INSERT INTO `sys_menu` VALUES ('36', '21', '修改', '/role/edit', '1', null, '1', null, '3', '角色管理', '0', null, '2016-06-26 15:56:54', null, '2016-06-26 15:56:54', '修改角色');
INSERT INTO `sys_menu` VALUES ('37', '22', '删除', '/role/delete', '1', null, '1', null, '3', '角色管理', '0', null, '2016-06-26 15:57:14', null, '2016-06-26 15:57:14', '删除角色');
INSERT INTO `sys_menu` VALUES ('38', '23', '登录日志', '/loginLog/listPage', '0', 'icon-tasks', '1', null, '5', '监控管理', '0', null, '2016-06-26 16:07:57', null, '2016-06-26 16:07:57', '登录日志');
INSERT INTO `sys_menu` VALUES ('39', '24', '操作日志', '/webLog/list', '0', 'icon-print', '1', null, '5', '监控管理', '0', null, '2016-06-26 16:11:30', null, '2016-06-26 16:11:30', null);
INSERT INTO `sys_menu` VALUES ('41', '1478700606660', '字典管理', '/dict/list', '0', 'icon-screenshot', '1', null, '1', '系统管理', '0', null, '2016-11-09 12:42:21', null, '2016-11-09 12:42:21', '字典管理');
INSERT INTO `sys_menu` VALUES ('42', '1480978838674', '角色分配', '/user/addRoles', '1', null, '1', null, '2', '用户管理', '0', null, '2016-11-13 06:14:31', null, '2016-11-13 06:14:31', '给用户分配角色');
INSERT INTO `sys_menu` VALUES ('43', '1479219411962', '查询', '/user/list', '1', null, '1', null, '2', '用户管理', '0', null, '2016-11-15 12:49:06', null, '2016-11-15 12:49:06', null);
INSERT INTO `sys_menu` VALUES ('44', '1479219651971', '重置密码', '/user/resetPwd', '1', null, '1', null, '2', '用户管理', '0', null, '2016-11-15 12:53:06', null, '2016-11-15 12:53:06', '重置密码');
INSERT INTO `sys_menu` VALUES ('45', '1479219802326', '查询', '/role/list', '1', null, '1', null, '3', '角色管理', '0', null, '2016-11-15 12:55:37', null, '2016-11-15 12:55:37', '角色查询');
INSERT INTO `sys_menu` VALUES ('46', '1479220072000', '查询', '/loginLog/list', '1', null, '1', null, '23', '登录日志', '0', null, '2016-11-15 13:00:06', null, '2016-11-15 13:00:06', '日志查询');
INSERT INTO `sys_menu` VALUES ('47', '1479220099932', '删除', '/loginLog/delete', '1', null, '1', null, '23', '登录日志', '0', null, '2016-11-15 13:00:34', null, '2016-11-15 13:00:34', '日志删除');
INSERT INTO `sys_menu` VALUES ('48', '1479220122402', '查询', '/menu/list', '1', null, '1', null, '4', '菜单管理', '0', null, '2016-11-15 13:00:57', null, '2016-11-15 13:00:57', '菜单查询');
INSERT INTO `sys_menu` VALUES ('53', '1480136216606', '测试', '/user/test', '1', null, '1', null, '2', '用户管理', '0', null, '2016-11-26 03:29:11', null, '2016-11-26 03:29:11', null);
INSERT INTO `sys_menu` VALUES ('54', '1480224173523', '添加', '/dic/add', '1', null, '1', null, '1478700606660', '字典管理', '0', null, '2016-11-27 03:55:08', null, '2016-11-27 03:55:08', '添加');
INSERT INTO `sys_menu` VALUES ('55', '1480224199655', '修改', '/dic/edit', '1', null, '1', null, '1478700606660', '字典管理', '0', null, '2016-11-27 03:55:35', null, '2016-11-27 03:55:35', '修改');
INSERT INTO `sys_menu` VALUES ('56', '1480254855433', '删除', '/dic/delete', '1', null, '1', null, '1478700606660', '字典管理', '0', null, '2016-11-27 12:26:30', null, '2016-11-27 12:26:30', null);

--update @17-3-25
INSERT INTO `sys_menu` VALUES ('58', '58', '医疗机构管理', '/hospital/listPage', '0', 'icon-screenshot', '1', null, '1', '系统管理', '0', null, '2017-03-21 13:47:15', null, '2017-03-21 13:47:15', '');
INSERT INTO `sys_menu` VALUES ('59', '59', '检查项管理', '/checkitem/listPage', '0', 'icon-beer', '1', null, '1', '系统管理', '0', null, '2017-03-25 11:07:50', null, '2017-03-25 11:07:50', null);
INSERT INTO `sys_menu` VALUES ('60', '60', '检查部位管理', '/positionType/listPage', '0', 'icon-book', '1', null, '1', '系统管理', '0', null, '2017-03-25 11:09:06', null, '2017-03-25 11:09:06', null);
INSERT INTO `sys_menu` VALUES ('61', '61', '设备类型管理', '/deviceType/listPage', '0', 'icon-book', '1', null, '1', '系统管理', '0', null, '2017-03-25 11:09:31', null, '2017-03-25 11:09:31', null);





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

--update @17-3-25
INSERT INTO `sys_role_menu` VALUES ('1034', 'ROLE_ADMIN', '60', '0', '2017-03-25 11:09:58', null, '2017-03-25 11:09:58', null, null);
INSERT INTO `sys_role_menu` VALUES ('1011', 'ROLE_ADMIN', '58', '0', '2017-03-25 11:09:57', null, '2017-03-25 11:09:57', null, null);
INSERT INTO `sys_role_menu` VALUES ('1012', 'ROLE_ADMIN', '59', '0', '2017-03-25 11:09:57', null, '2017-03-25 11:09:57', null, null);
INSERT INTO `sys_role_menu` VALUES ('1022', 'ROLE_ADMIN', '61', '0', '2017-03-25 11:09:57', null, '2017-03-25 11:09:57', null, null);


-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', 'admin', 'admin', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2016-04-15 11:23:23', null, '123456@qq.com', '13428281893', '0', '0', '2017-02-27 15:37:31', '0:0:0:0:0:0:0:1', '0', '2016-04-15 11:23:38', null, '2016-05-12 17:28:04', null, null);

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', 'ROLE_ADMIN', '0', '2016-04-15 14:48:11', '0', '2016-04-15 14:48:13', '0', null);
