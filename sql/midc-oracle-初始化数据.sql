-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO sys_dict (id,parent_id,code,name,seq,type,is_catagory,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('17', '#', 'dict', '数据字典', '0', null, 'Y', '0', sysdate, null, sysdate, null, '');
INSERT INTO sys_dict (id,parent_id,code,name,seq,type,is_catagory,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('27', '17', 'sex', '性别', '0', null, 'Y', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_dict (id,parent_id,code,name,seq,type,is_catagory,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('28', '27', 'M', '男性', '0', null, 'N', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_dict (id,parent_id,code,name,seq,type,is_catagory,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('29', '27', 'F', '女性', '0', null, 'N', '0', sysdate, null, sysdate, null, null);

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
-- update @17-5-3
DELETE FROM sys_menu ;

INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('1', '1', '系统管理', null, '0', 'icon-desktop', '1', '2', '#', null, '0', '0', sysdate, '0', sysdate, null);
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('4', '4', '菜单管理', '/menu/listPage', '0', 'icon-sitemap', '1', '4', '1', '系统管理', '0', '0', sysdate, '0', sysdate, '菜单管理');
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('38', '23', '登录日志', '/loginLog/listPage', '0', 'icon-tasks', '1', null, '1', '系统管理', '0', null, sysdate, null, sysdate, '登录日志');
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('39', '24', '操作日志', '/webLog/list', '0', 'icon-print', '1', null, '1', '系统管理', '0', null, sysdate, null, sysdate, null);
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('41', '1478700606660', '字典管理', '/dict/list', '0', 'icon-screenshot', '1', null, '1', '系统管理', '0', null, sysdate, null, sysdate, '字典管理');


INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('19', '5', '业务管理', null, '0', 'icon-credit-card', '1', '1', '#', null, '0', null, sysdate, null, sysdate, null);
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('2', '2', '用户管理', '/user/listPage', '0', 'icon-user', '1', '2', '5', '业务管理', '0', '0', sysdate, '0', sysdate, '用户管理');
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('3', '3', '角色管理', '/role/listPage', '0', 'icon-magnet', '1', '3', '5', '业务管理', '0', '0', sysdate, '0', sysdate, '角色管理');
-- update @17-3-25
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('58', '58', '医疗机构管理', '/hospital/listPage', '0', 'icon-screenshot', '1', null, '5', '业务管理', '0', null, sysdate, null, sysdate, '');
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('59', '59', '检查项管理', '/checkitem/listPage', '0', 'icon-beer', '1', null, '5', '业务管理', '0', null, sysdate, null, sysdate, null);
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('60', '60', '检查部位管理', '/positionType/listPage', '0', 'icon-book', '1', null, '5', '业务管理', '0', null, sysdate, null, sysdate, null);
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark)  VALUES ('61', '61', '设备类型管理', '/deviceType/listPage', '0', 'icon-book', '1', null, '5', '业务管理', '0', null, sysdate, null, sysdate, null);
-- update @17-4-5
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('62', '62', '设备关联管理', '/devicetypePC/listPage', '0', 'icon-book', '1', null, '5', '业务管理', '0', '0', sysdate, '0', sysdate, null);
-- update @17-4-17
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('63', '63', '患者管理', '/patlist/listPage', '0', 'icon-book', '1', null, '5', '业务管理', '0', '0', sysdate, '0', sysdate, null);
-- update @17-5-12
INSERT INTO sys_menu (id,menu_id,name,url,type,icon,is_show,seq,parent_id,parent_name,is_delete,create_by,create_time,update_by,update_time,remark) VALUES ('65', '65', '存储管理', '/storage/listPage', '0', 'icon-hdd', '1', null, '1', '系统管理', '0', '0', sysdate, '0', sysdate, null);





-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO sys_role (id,role_id,name)VALUES ('1', 'ROLE_ADMIN', '超级管理员');
INSERT INTO sys_role (id,role_id,name)VALUES ('2', 'ROLE_JUNIOR_DOC', '一线医生');
INSERT INTO sys_role (id,role_id,name)VALUES ('3', 'ROLE_SENIOR_DOC', '二线医生');

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('961', 'ROLE_ADMIN', '22', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('962', 'ROLE_ADMIN', '12', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('963', 'ROLE_ADMIN', '23', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('964', 'ROLE_ADMIN', '1479220072000', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('965', 'ROLE_ADMIN', '13', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('966', 'ROLE_ADMIN', '24', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('967', 'ROLE_ADMIN', '14', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('968', 'ROLE_ADMIN', '16', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('969', 'ROLE_ADMIN', '1480224173523', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('970', 'ROLE_ADMIN', '1479220122402', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('971', 'ROLE_ADMIN', '1479219411962', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('972', 'ROLE_ADMIN', '1478700606660', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('973', 'ROLE_ADMIN', '1', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('974', 'ROLE_ADMIN', '2', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('975', 'ROLE_ADMIN', '3', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('976', 'ROLE_ADMIN', '4', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('977', 'ROLE_ADMIN', '5', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('978', 'ROLE_ADMIN', '1480254855433', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('979', 'ROLE_ADMIN', '1480978838674', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('980', 'ROLE_ADMIN', '20', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('981', 'ROLE_ADMIN', '1479219651971', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('982', 'ROLE_ADMIN', '1479219802326', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('983', 'ROLE_ADMIN', '21', '0', sysdate, null, sysdate, null, null);

-- update @17-3-25
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('1034', 'ROLE_ADMIN', '60', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('1011', 'ROLE_ADMIN', '58', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('1012', 'ROLE_ADMIN', '59', '0', sysdate, null, sysdate, null, null);
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('1022', 'ROLE_ADMIN', '61', '0', sysdate, null, sysdate, null, null);
-- update @17-4-5
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('1059', 'ROLE_ADMIN', '62', '0', sysdate, null, sysdate, null, null);
-- update @17-4-17
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('1063', 'ROLE_ADMIN', '63', '0', sysdate, null, sysdate, null, null);
-- update @17-5-12
INSERT INTO sys_role_menu (id,role_id,menu_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('1065', 'ROLE_ADMIN', '65', '0', sysdate, null, sysdate, null, null);

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user (id,user_id,account,true_name,password,birth,sex,email,mobile,error_count,is_lock,login_time,login_ip,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('1', '1', 'admin', 'admin', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', sysdate, null, '123456@qq.com', '13428281893', '0', '0', sysdate, '0:0:0:0:0:0:0:1', '0', sysdate, null, sysdate, null, null);

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO sys_user_role (id,user_id,role_id,is_delete,create_time,create_by,update_time,update_by,remark)VALUES ('1', '1', 'ROLE_ADMIN', '0', sysdate, '0', sysdate, '0', null);
