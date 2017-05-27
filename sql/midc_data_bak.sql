/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.6.25 : Database - midc_dc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `checkitem` */

DROP TABLE IF EXISTS `checkitem`;

CREATE TABLE `checkitem` (
  `checkitem_id` int(11) NOT NULL AUTO_INCREMENT,
  `checkitem_name` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_available` varchar(4) DEFAULT NULL,
  `oper_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`checkitem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `checkitem` */

insert  into `checkitem`(`checkitem_id`,`checkitem_name`,`create_time`,`is_available`,`oper_id`,`update_time`) values (2,'平扫','2017-05-03 02:42:22','1','1','2017-05-03 02:42:22');
insert  into `checkitem`(`checkitem_id`,`checkitem_name`,`create_time`,`is_available`,`oper_id`,`update_time`) values (3,'增强','2017-05-03 02:42:32','1','1','2017-05-03 02:42:32');

/*Table structure for table `device_type` */

DROP TABLE IF EXISTS `device_type`;

CREATE TABLE `device_type` (
  `device_type_id` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `device_type_name` varchar(64) DEFAULT NULL,
  `is_available` varchar(4) DEFAULT NULL,
  `oper_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`device_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `device_type` */

insert  into `device_type`(`device_type_id`,`create_time`,`device_type_name`,`is_available`,`oper_id`,`update_time`) values ('CT','2017-05-03 02:41:00','CT','1','1','2017-05-03 02:41:14');
insert  into `device_type`(`device_type_id`,`create_time`,`device_type_name`,`is_available`,`oper_id`,`update_time`) values ('MR','2017-05-03 02:41:26','磁共振','1','1','2017-05-03 02:41:26');
insert  into `device_type`(`device_type_id`,`create_time`,`device_type_name`,`is_available`,`oper_id`,`update_time`) values ('US','2017-05-03 02:41:37','超声','1','1','2017-05-03 02:41:37');

/*Table structure for table `devicetype_position_checkitem` */

DROP TABLE IF EXISTS `devicetype_position_checkitem`;

CREATE TABLE `devicetype_position_checkitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `checkitem_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `device_type_id` varchar(255) DEFAULT NULL,
  `oper_id` varchar(32) DEFAULT NULL,
  `positiontype_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deviceTypeName` varchar(255) DEFAULT NULL,
  `checkitemName` varchar(255) DEFAULT NULL,
  `positiontypeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `devicetype_position_checkitem` */

insert  into `devicetype_position_checkitem`(`id`,`checkitem_id`,`create_time`,`device_type_id`,`oper_id`,`positiontype_id`,`update_time`,`deviceTypeName`,`checkitemName`,`positiontypeName`) values (4,2,'2017-05-03 05:23:47','CT','1',3,'2017-05-03 05:23:47','CT','平扫','腹部');
insert  into `devicetype_position_checkitem`(`id`,`checkitem_id`,`create_time`,`device_type_id`,`oper_id`,`positiontype_id`,`update_time`,`deviceTypeName`,`checkitemName`,`positiontypeName`) values (5,3,'2017-05-03 05:24:27','CT','1',2,'2017-05-03 05:24:27','CT','增强','头部');

/*Table structure for table `file_info` */

DROP TABLE IF EXISTS `file_info`;

CREATE TABLE `file_info` (
  `file_id` varchar(128) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `failed_reason` varchar(256) DEFAULT NULL,
  `file_path` varchar(128) DEFAULT NULL,
  `hospital_id` varchar(64) DEFAULT NULL,
  `media_id` varchar(64) DEFAULT NULL,
  `orig_file_name` varchar(128) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `study_info_id` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `file_info` */

insert  into `file_info`(`file_id`,`create_time`,`failed_reason`,`file_path`,`hospital_id`,`media_id`,`orig_file_name`,`status`,`study_info_id`,`update_time`,`user_id`) values ('3B35C9486DB04DB7900A066114B91454','2017-05-12 07:04:14','','/1234567/6EB7FB1E5080455886C07C8919308813','312DDA20904B4D4185432E944B8A8CE6','4291570CFAEB47B693AE0F4A9242705C','D0002.zip','1','1234567','2017-05-12 07:04:14',NULL);

/*Table structure for table `hospital` */

DROP TABLE IF EXISTS `hospital`;

CREATE TABLE `hospital` (
  `hosp_id` varchar(32) NOT NULL,
  `address` varchar(256) DEFAULT NULL,
  `client_id` varchar(32) DEFAULT NULL,
  `client_secret` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `hosp_name` varchar(64) DEFAULT NULL,
  `is_available` varchar(4) DEFAULT NULL,
  `is_connected` varchar(4) DEFAULT NULL,
  `last_hb_time` datetime DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`hosp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hospital` */

insert  into `hospital`(`hosp_id`,`address`,`client_id`,`client_secret`,`create_time`,`hosp_name`,`is_available`,`is_connected`,`last_hb_time`,`latitude`,`longitude`,`update_time`) values ('312DDA20904B4D4185432E944B8A8CE6','仁爱','1001','FF6A0AA21E9B4E1B90092C4DD32271E7','2017-05-03 02:34:58','仁爱','1','0',NULL,NULL,NULL,'2017-05-03 02:34:58');
insert  into `hospital`(`hosp_id`,`address`,`client_id`,`client_secret`,`create_time`,`hosp_name`,`is_available`,`is_connected`,`last_hb_time`,`latitude`,`longitude`,`update_time`) values ('3B1EB401C10F45908613119818C4E690','慈济','1002','CC77FD58E1DC4451ACCA463752548C27','2017-05-03 02:36:34','慈济','1','0',NULL,NULL,NULL,'2017-05-03 02:36:34');

/*Table structure for table `instance` */

DROP TABLE IF EXISTS `instance`;

CREATE TABLE `instance` (
  `instance_uid` varchar(128) NOT NULL,
  `acq_date_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `file_id` varchar(128) DEFAULT NULL,
  `inst_no` varchar(128) DEFAULT NULL,
  `series_uid` varchar(128) DEFAULT NULL,
  `sop_iuid` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`instance_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `instance` */

/*Table structure for table `media_info` */

DROP TABLE IF EXISTS `media_info`;

CREATE TABLE `media_info` (
  `media_id` varchar(128) NOT NULL,
  `storage_id` varchar(128) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `media_name` varchar(128) DEFAULT NULL,
  `path` varchar(128) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`media_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `media_info` */

insert  into `media_info`(`media_id`,`storage_id`,`create_time`,`media_name`,`path`,`status`,`update_time`) values ('4291570CFAEB47B693AE0F4A9242705C','1','2017-05-12 02:28:03','201705132','/201705132','0','2017-05-12 02:28:03');

/*Table structure for table `oauth_access_token` */

DROP TABLE IF EXISTS `oauth_access_token`;

CREATE TABLE `oauth_access_token` (
  `access_token` varchar(32) NOT NULL,
  `client_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `refresh_token` varchar(32) DEFAULT NULL,
  `refresh_token_expired_seconds` int(11) DEFAULT NULL,
  `token_expired_seconds` int(11) DEFAULT NULL,
  `token_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`access_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oauth_access_token` */

insert  into `oauth_access_token`(`access_token`,`client_id`,`create_time`,`refresh_token`,`refresh_token_expired_seconds`,`token_expired_seconds`,`token_type`) values ('78394C2F87474B3B9278033037E91231','1001','2017-05-12 10:22:59','D0DD87B4195E45C390BD78BFF9F845AA',2592000,43200,'BEARER');

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `pat_id` varchar(64) NOT NULL,
  `address` varchar(512) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `id_number` varchar(32) DEFAULT NULL,
  `nationality` varchar(128) DEFAULT NULL,
  `oper_id` varchar(64) DEFAULT NULL,
  `pat_card_id` varchar(128) DEFAULT NULL,
  `pat_name` varchar(64) NOT NULL,
  `pat_spell_name` varchar(128) DEFAULT NULL,
  `patient_type` varchar(4) DEFAULT NULL,
  `phone_number` varchar(32) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `patient` */

insert  into `patient`(`pat_id`,`address`,`birthday`,`create_time`,`id_number`,`nationality`,`oper_id`,`pat_card_id`,`pat_name`,`pat_spell_name`,`patient_type`,`phone_number`,`sex`,`update_time`) values ('8B006028D2F3456FBF02C160644AB68B','中国中国中国中国中国中国中国中国中国','1987-11-11 00:00:00','2017-05-12 06:08:22','423105188311111083','中国','','p423105188311111083','张三','zhangsan','1','17355555555','M','2017-05-12 06:08:22');
insert  into `patient`(`pat_id`,`address`,`birthday`,`create_time`,`id_number`,`nationality`,`oper_id`,`pat_card_id`,`pat_name`,`pat_spell_name`,`patient_type`,`phone_number`,`sex`,`update_time`) values ('C6D980645B5648979B0AE666C3A053D6','中国中国中国中国中国中国中国中国中国','1987-11-11 00:00:00','2017-05-12 02:23:43','423105188311111083','中国','','p423105188311111083','张三','zhangsan','1','17355555555','M','2017-05-12 02:23:43');
insert  into `patient`(`pat_id`,`address`,`birthday`,`create_time`,`id_number`,`nationality`,`oper_id`,`pat_card_id`,`pat_name`,`pat_spell_name`,`patient_type`,`phone_number`,`sex`,`update_time`) values ('FB59D9F25B304822AA30E6C44BE8C7FC','中国中国中国中国中国中国中国中国中国','1987-11-11 00:00:00','2017-05-03 05:31:59','423105188311111083','中国','','p423105188311111083','张三','zhangsan','1','17355555555','M','2017-05-03 05:31:59');

/*Table structure for table `positiontype` */

DROP TABLE IF EXISTS `positiontype`;

CREATE TABLE `positiontype` (
  `positiontype_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `is_available` varchar(4) DEFAULT NULL,
  `oper_id` varchar(32) DEFAULT NULL,
  `positiontype_name` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`positiontype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `positiontype` */

insert  into `positiontype`(`positiontype_id`,`create_time`,`is_available`,`oper_id`,`positiontype_name`,`update_time`) values (2,'2017-05-03 02:41:58','1','1','头部','2017-05-03 02:41:58');
insert  into `positiontype`(`positiontype_id`,`create_time`,`is_available`,`oper_id`,`positiontype_name`,`update_time`) values (3,'2017-05-03 02:42:07','1','1','腹部','2017-05-03 02:42:07');

/*Table structure for table `report` */

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
  `rpt_id` varchar(64) NOT NULL,
  `advice` varchar(4000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `diagnosis` varchar(4000) DEFAULT NULL,
  `d_doc_id` varchar(64) DEFAULT NULL,
  `j_doc_id` varchar(64) DEFAULT NULL,
  `s_doc_id` varchar(64) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `studyinfo_id` varchar(128) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `device_type` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`rpt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `report` */

insert  into `report`(`rpt_id`,`advice`,`create_time`,`diagnosis`,`d_doc_id`,`j_doc_id`,`s_doc_id`,`status`,`studyinfo_id`,`update_time`,`description`,`device_type`) values ('7000A30C47F2491E8A4625876E82B09F','建议：临床跟踪','2017-05-03 05:45:50','诊断，可能肺炎',NULL,'-45898497714937788461284','-45898497714937788461284','0','312DDA20904B4D4185432E944B8A8CE6123','2017-05-03 05:45:50','描述，肺部阴影',NULL);
insert  into `report`(`rpt_id`,`advice`,`create_time`,`diagnosis`,`d_doc_id`,`j_doc_id`,`s_doc_id`,`status`,`studyinfo_id`,`update_time`,`description`,`device_type`) values ('8C4BCA515A4D473CA84B49A3E895CA8F','adviceyoubing有病34','2017-05-03 05:46:48','diagnosiszhangsanyoubing有病34',NULL,'-45898497714937788461284','-45898497714937788461284','1','312DDA20904B4D4185432E944B8A8CE6123','2017-05-03 05:46:48','descritpionyoubing有病34',NULL);

/*Table structure for table `ris_pacs_rel` */

DROP TABLE IF EXISTS `ris_pacs_rel`;

CREATE TABLE `ris_pacs_rel` (
  `study_info_id` varchar(64) NOT NULL,
  `study_uid` varchar(128) NOT NULL,
  PRIMARY KEY (`study_info_id`,`study_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ris_pacs_rel` */

insert  into `ris_pacs_rel`(`study_info_id`,`study_uid`) values ('312DDA20904B4D4185432E944B8A8CE61234567','d54fa59ad0d4c555e75c32d441eea48c');

/*Table structure for table `series` */

DROP TABLE IF EXISTS `series`;

CREATE TABLE `series` (
  `series_uid` varchar(128) NOT NULL,
  `body_part` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `image_count` int(11) DEFAULT NULL,
  `series_desc` varchar(128) DEFAULT NULL,
  `series_iuid` varchar(128) DEFAULT NULL,
  `series_no` varchar(128) DEFAULT NULL,
  `study_uid` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`series_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `series` */

/*Table structure for table `storage_info` */

DROP TABLE IF EXISTS `storage_info`;

CREATE TABLE `storage_info` (
  `storage_id` varchar(128) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `path` varchar(128) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`storage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `storage_info` */

insert  into `storage_info`(`storage_id`,`create_time`,`name`,`path`,`status`,`update_time`) values ('39232','2017-05-13 13:32:51','20170513','d:/dicom','0',NULL);
insert  into `storage_info`(`storage_id`,`create_time`,`name`,`path`,`status`,`update_time`) values ('67386','2017-05-13 13:34:19','20170523-3','d:/dicom','0',NULL);
insert  into `storage_info`(`storage_id`,`create_time`,`name`,`path`,`status`,`update_time`) values ('93866','2017-05-21 12:04:46','storage2','d:/dicom','1','2017-05-21 12:04:46');
insert  into `storage_info`(`storage_id`,`create_time`,`name`,`path`,`status`,`update_time`) values ('95759','2017-05-13 13:33:24','201705132','D:/haha','0',NULL);

/*Table structure for table `study` */

DROP TABLE IF EXISTS `study`;

CREATE TABLE `study` (
  `study_uid` varchar(128) NOT NULL,
  `access_no` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `inst_cnt` int(11) DEFAULT NULL,
  `modality` varchar(128) DEFAULT NULL,
  `pat_age` varchar(255) DEFAULT NULL,
  `pat_birth` datetime DEFAULT NULL,
  `pat_id` varchar(128) DEFAULT NULL,
  `pat_name` varchar(128) DEFAULT NULL,
  `pat_sex` varchar(128) DEFAULT NULL,
  `pat_size` float DEFAULT NULL,
  `pat_weight` float DEFAULT NULL,
  `status` varchar(8) DEFAULT NULL,
  `study_desc` varchar(128) DEFAULT NULL,
  `study_id` varchar(128) DEFAULT NULL,
  `study_iuid` varchar(128) DEFAULT NULL,
  `study_time` datetime DEFAULT NULL,
  `user_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`study_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `study` */

insert  into `study`(`study_uid`,`access_no`,`create_time`,`inst_cnt`,`modality`,`pat_age`,`pat_birth`,`pat_id`,`pat_name`,`pat_sex`,`pat_size`,`pat_weight`,`status`,`study_desc`,`study_id`,`study_iuid`,`study_time`,`user_id`) values ('d54fa59ad0d4c555e75c32d441eea48c',NULL,'2017-05-12 07:04:14',0,'CT',NULL,NULL,'NeuViz 128','ENV128','M',0,0,'1','Knee Plain','S-201510202637','1.2.156.14702.1.1005.128.0.20151020152317704289445316906672','2015-10-20 07:23:17',NULL);

/*Table structure for table `study_check_pos` */

DROP TABLE IF EXISTS `study_check_pos`;

CREATE TABLE `study_check_pos` (
  `study_cp_id` int(11) NOT NULL AUTO_INCREMENT,
  `check_item` varchar(256) DEFAULT NULL,
  `position` varchar(256) DEFAULT NULL,
  `sub_position` varchar(256) DEFAULT NULL,
  `studyinfo_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`study_cp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `study_check_pos` */

insert  into `study_check_pos`(`study_cp_id`,`check_item`,`position`,`sub_position`,`studyinfo_id`) values (7,'1','1',NULL,'312DDA20904B4D4185432E944B8A8CE6123');
insert  into `study_check_pos`(`study_cp_id`,`check_item`,`position`,`sub_position`,`studyinfo_id`) values (8,'2','2',NULL,'312DDA20904B4D4185432E944B8A8CE6123');
insert  into `study_check_pos`(`study_cp_id`,`check_item`,`position`,`sub_position`,`studyinfo_id`) values (9,'1','1',NULL,'312DDA20904B4D4185432E944B8A8CE61234567');
insert  into `study_check_pos`(`study_cp_id`,`check_item`,`position`,`sub_position`,`studyinfo_id`) values (10,'2','2',NULL,'312DDA20904B4D4185432E944B8A8CE61234567');
insert  into `study_check_pos`(`study_cp_id`,`check_item`,`position`,`sub_position`,`studyinfo_id`) values (11,'1','1',NULL,'312DDA20904B4D4185432E944B8A8CE61234567');
insert  into `study_check_pos`(`study_cp_id`,`check_item`,`position`,`sub_position`,`studyinfo_id`) values (12,'2','2',NULL,'312DDA20904B4D4185432E944B8A8CE61234567');

/*Table structure for table `study_info` */

DROP TABLE IF EXISTS `study_info`;

CREATE TABLE `study_info` (
  `studyinfo_id` varchar(64) NOT NULL,
  `abs_history` varchar(512) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `age_unit` varchar(8) DEFAULT NULL,
  `apply_dep_name` varchar(64) DEFAULT NULL,
  `apply_doc_name` varchar(64) DEFAULT NULL,
  `apply_time` datetime DEFAULT NULL,
  `clinical_manifest` varchar(3600) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `hosp_id` varchar(128) DEFAULT NULL,
  `is_available` varchar(4) DEFAULT NULL,
  `org_studyinfo_id` varchar(64) DEFAULT NULL,
  `photo_maker_id` varchar(128) DEFAULT NULL,
  `position_checkitem` varchar(128) DEFAULT NULL,
  `pre_diagnose` varchar(512) DEFAULT NULL,
  `rpt_status` varchar(4) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `study_demand` varchar(3600) DEFAULT NULL,
  `study_desc` varchar(3600) DEFAULT NULL,
  `trans_status` varchar(4) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `pat_id` varchar(64) DEFAULT NULL,
  `rpt_id` varchar(64) DEFAULT NULL,
  `device_type` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`studyinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `study_info` */

insert  into `study_info`(`studyinfo_id`,`abs_history`,`age`,`age_unit`,`apply_dep_name`,`apply_doc_name`,`apply_time`,`clinical_manifest`,`create_time`,`hosp_id`,`is_available`,`org_studyinfo_id`,`photo_maker_id`,`position_checkitem`,`pre_diagnose`,`rpt_status`,`status`,`study_demand`,`study_desc`,`trans_status`,`update_time`,`pat_id`,`rpt_id`,`device_type`) values ('312DDA20904B4D4185432E944B8A8CE61234567','abstractHistory',45,'Y','神经内科','张医生',NULL,'clinicalManifest','2017-05-12 06:08:22','312DDA20904B4D4185432E944B8A8CE6','1','1234567',NULL,'[,;头部,平扫;]','touten头疼',NULL,'0','studyDemand','studyDescription','1','2017-05-12 06:08:22','8B006028D2F3456FBF02C160644AB68B',NULL,'CT');

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` varchar(64) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `seq` tinyint(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `is_catagory` char(1) DEFAULT NULL COMMENT '是否作为分类菜单  Y , N',
  `is_delete` tinyint(1) NOT NULL COMMENT '软删除标识',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`parent_id`,`code`,`name`,`seq`,`type`,`is_catagory`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (17,'#','dict','数据字典',0,NULL,'Y',0,'2016-11-27 12:38:33',NULL,'2016-11-27 12:38:33',NULL,'');
insert  into `sys_dict`(`id`,`parent_id`,`code`,`name`,`seq`,`type`,`is_catagory`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (26,'17','test','测试',0,NULL,'Y',0,'2016-11-30 13:35:52',NULL,'2016-11-30 13:35:52',NULL,NULL);
insert  into `sys_dict`(`id`,`parent_id`,`code`,`name`,`seq`,`type`,`is_catagory`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (27,'17','sex','性别',0,NULL,'Y',0,'2016-11-30 13:40:10',NULL,'2016-11-30 13:40:10',NULL,NULL);
insert  into `sys_dict`(`id`,`parent_id`,`code`,`name`,`seq`,`type`,`is_catagory`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (28,'27','nanxing','男性',0,NULL,'N',0,'2016-11-30 13:42:16',NULL,'2016-12-04 12:24:54',NULL,NULL);
insert  into `sys_dict`(`id`,`parent_id`,`code`,`name`,`seq`,`type`,`is_catagory`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (29,'27','nvxing','女性',0,NULL,'N',0,'2016-12-04 12:24:11',NULL,'2016-12-04 12:24:11',NULL,NULL);
insert  into `sys_dict`(`id`,`parent_id`,`code`,`name`,`seq`,`type`,`is_catagory`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (30,'26','test1','test1',0,NULL,'Y',0,'2017-02-26 16:06:38',NULL,'2017-02-26 16:06:38',NULL,NULL);
insert  into `sys_dict`(`id`,`parent_id`,`code`,`name`,`seq`,`type`,`is_catagory`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (31,'30','aaa','aaa',0,NULL,'N',0,'2017-02-26 16:07:08',NULL,'2017-02-26 16:07:08',NULL,NULL);

/*Table structure for table `sys_login_log` */

DROP TABLE IF EXISTS `sys_login_log`;

CREATE TABLE `sys_login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_log_id` varchar(64) NOT NULL,
  `login_account` varchar(30) NOT NULL,
  `login_time` datetime NOT NULL,
  `login_ip` varchar(255) NOT NULL,
  `status` varchar(10) NOT NULL,
  `is_delete` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=678 DEFAULT CHARSET=utf8;

/*Data for the table `sys_login_log` */

insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (661,'-45898497714937788153411','admin','2017-05-03 02:33:35','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-03 02:33:35',NULL,'2017-05-03 02:33:35',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (662,'-45898497714937890072231','admin','2017-05-03 05:23:27','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-03 05:23:27',NULL,'2017-05-03 05:23:27',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (663,'-45898497714937985437913','admin','2017-05-03 08:02:24','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-03 08:02:24',NULL,'2017-05-03 08:02:24',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (664,'-45898497714938025169364','admin','2017-05-03 09:08:37','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-03 09:08:37',NULL,'2017-05-03 09:08:37',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (665,'-45898497714938212176761','admin','2017-05-03 14:20:18','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-03 14:20:18',NULL,'2017-05-03 14:20:18',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (666,'-93353004414942064318871','admin','2017-05-08 01:20:32','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-08 01:20:32',NULL,'2017-05-08 01:20:32',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (667,'-933530044149420724715414','admin2','2017-05-08 01:34:07','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-08 01:34:07',NULL,'2017-05-08 01:34:07',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (668,'-45898497714943082294021','admin','2017-05-09 05:37:09','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-09 05:37:09',NULL,'2017-05-09 05:37:09',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (669,'-45898497714943175494639','admin','2017-05-09 08:12:29','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-09 08:12:29',NULL,'2017-05-09 08:12:29',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (670,'-45898497714943788297991','admin','2017-05-10 01:13:50','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-10 01:13:50',NULL,'2017-05-10 01:13:50',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (671,'-45898497714944641451681','admin','2017-05-11 00:55:45','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-11 00:55:45',NULL,'2017-05-11 00:55:45',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (672,'-45898497714944666254671','admin','2017-05-11 01:37:05','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-11 01:37:05',NULL,'2017-05-11 01:37:05',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (673,'-45898497714945580857281','admin','2017-05-12 03:01:26','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-12 03:01:26',NULL,'2017-05-12 03:01:26',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (674,'-45898497714946820379001','admin','2017-05-13 13:27:18','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-13 13:27:18',NULL,'2017-05-13 13:27:18',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (675,'-45898497714953678473241','admin','2017-05-21 11:57:27','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-21 11:57:27',NULL,'2017-05-21 11:57:27',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (676,'-45898497714956258619731','admin','2017-05-24 11:37:42','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-24 11:37:42',NULL,'2017-05-24 11:37:42',NULL,NULL);
insert  into `sys_login_log`(`id`,`login_log_id`,`login_account`,`login_time`,`login_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (677,'-45898497714956261897991','admin','2017-05-24 11:43:10','0:0:0:0:0:0:0:1','登录成功',0,'2017-05-24 11:43:10',NULL,'2017-05-24 11:43:10',NULL,NULL);

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `menu_id` varchar(64) NOT NULL COMMENT '资源编号',
  `name` varchar(30) NOT NULL COMMENT '菜单名称',
  `url` varchar(30) DEFAULT NULL COMMENT '菜单url',
  `type` int(1) DEFAULT NULL COMMENT '菜单类型(0为一级菜单,2为二级菜单,3为按钮)',
  `icon` varchar(30) DEFAULT '' COMMENT '菜单图标',
  `is_show` int(1) NOT NULL COMMENT '是否显示(1为是，0为不是)',
  `seq` int(1) DEFAULT NULL COMMENT '菜单顺序',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '上级菜单ID',
  `parent_name` varchar(20) DEFAULT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '软删除标识',
  `create_by` varchar(64) DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_res_id` (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (1,'1','系统管理',NULL,0,'icon-desktop',1,2,'#',NULL,0,'0','2016-05-16 17:10:44','0','2016-06-02 21:01:12',NULL);
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (2,'2','用户管理','/user/listPage',0,'icon-user',1,2,'5','业务管理',0,'0','2016-05-06 14:34:37','0','2016-06-02 22:44:56','用户管理');
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (3,'3','角色管理','/role/listPage',0,'icon-magnet',1,3,'5','业务管理',0,'0','2016-05-06 14:35:24','0','2016-05-17 14:14:34','角色管理');
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (4,'4','菜单管理','/menu/listPage',0,'icon-sitemap',1,4,'1','系统管理',0,'0','2016-05-06 14:35:51','0','2016-05-15 21:23:15','菜单管理');
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (19,'5','业务管理',NULL,0,'icon-credit-card',1,1,'#',NULL,0,NULL,'2016-05-22 11:17:51',NULL,'2016-06-02 23:09:38',NULL);
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (38,'23','登录日志','/loginLog/listPage',0,'icon-tasks',1,NULL,'1','系统管理',0,NULL,'2016-06-26 16:07:57',NULL,'2016-06-26 16:07:57','登录日志');
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (39,'24','操作日志','/webLog/list',0,'icon-print',1,NULL,'1','系统管理',0,NULL,'2016-06-26 16:11:30',NULL,'2016-06-26 16:11:30',NULL);
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (41,'1478700606660','字典管理','/dict/list',0,'icon-screenshot',1,NULL,'1','系统管理',0,NULL,'2016-11-09 12:42:21',NULL,'2016-11-09 12:42:21','字典管理');
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (58,'58','医疗机构管理','/hospital/listPage',0,'icon-screenshot',1,NULL,'5','业务管理',0,NULL,'2017-03-21 13:47:15',NULL,'2017-03-21 13:47:15','');
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (59,'59','检查项管理','/checkitem/listPage',0,'icon-beer',1,NULL,'5','业务管理',0,NULL,'2017-03-25 11:07:50',NULL,'2017-03-25 11:07:50',NULL);
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (60,'60','检查部位管理','/positionType/listPage',0,'icon-book',1,NULL,'5','业务管理',0,NULL,'2017-03-25 11:09:06',NULL,'2017-03-25 11:09:06',NULL);
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (61,'61','设备类型管理','/deviceType/listPage',0,'icon-book',1,NULL,'5','业务管理',0,NULL,'2017-03-25 11:09:31',NULL,'2017-03-25 11:09:31',NULL);
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (62,'62','设备关联管理','/devicetypePC/listPage',0,'icon-book',1,NULL,'5','业务管理',0,'0','2017-04-05 20:44:42','0','2017-04-05 20:44:57',NULL);
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (63,'63','患者管理','/patlist/listPage',0,'icon-book',1,NULL,'5','业务管理',0,'0','2017-04-17 22:44:42','0','2017-04-17 22:44:57',NULL);
insert  into `sys_menu`(`id`,`menu_id`,`name`,`url`,`type`,`icon`,`is_show`,`seq`,`parent_id`,`parent_name`,`is_delete`,`create_by`,`create_time`,`update_by`,`update_time`,`remark`) values (65,'65','存储管理','/storage/listPage',0,'icon-hdd',1,NULL,'1','系统管理',0,'0','2017-05-12 10:13:42','0','2017-05-12 10:13:42',NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `name` varchar(32) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_id`,`name`) values (1,'ROLE_ADMIN','超级管理员');
insert  into `sys_role`(`id`,`role_id`,`name`) values (2,'ROLE_JUNIOR_DOC','一线医生');
insert  into `sys_role`(`id`,`role_id`,`name`) values (3,'ROLE_SENIOR_DOC','二线医生');

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `menu_id` varchar(64) NOT NULL COMMENT '资源编号',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '软删除标识',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT '0' COMMENT '创建人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT '0' COMMENT '更新人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`,`role_id`,`menu_id`),
  KEY `idx_role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1066 DEFAULT CHARSET=utf8 COMMENT='角色-资源表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (961,'ROLE_ADMIN','22',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (962,'ROLE_ADMIN','12',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (963,'ROLE_ADMIN','23',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (964,'ROLE_ADMIN','1479220072000',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (965,'ROLE_ADMIN','13',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (966,'ROLE_ADMIN','24',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (967,'ROLE_ADMIN','14',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (968,'ROLE_ADMIN','16',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (969,'ROLE_ADMIN','1480224173523',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (970,'ROLE_ADMIN','1479220122402',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (971,'ROLE_ADMIN','1479219411962',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (972,'ROLE_ADMIN','1478700606660',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (973,'ROLE_ADMIN','1',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (974,'ROLE_ADMIN','2',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (975,'ROLE_ADMIN','3',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (976,'ROLE_ADMIN','4',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (977,'ROLE_ADMIN','5',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (978,'ROLE_ADMIN','1480254855433',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (979,'ROLE_ADMIN','1480978838674',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (980,'ROLE_ADMIN','20',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (981,'ROLE_ADMIN','1479219651971',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (982,'ROLE_ADMIN','1479219802326',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (983,'ROLE_ADMIN','21',0,'2016-11-27 12:26:44',NULL,'2016-11-27 12:26:44',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (1011,'ROLE_ADMIN','58',0,'2017-03-25 11:09:57',NULL,'2017-03-25 11:09:57',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (1012,'ROLE_ADMIN','59',0,'2017-03-25 11:09:57',NULL,'2017-03-25 11:09:57',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (1022,'ROLE_ADMIN','61',0,'2017-03-25 11:09:57',NULL,'2017-03-25 11:09:57',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (1034,'ROLE_ADMIN','60',0,'2017-03-25 11:09:58',NULL,'2017-03-25 11:09:58',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (1059,'ROLE_ADMIN','62',0,'2017-04-05 12:49:55',NULL,'2017-04-05 12:49:55',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (1063,'ROLE_ADMIN','63',0,'2017-04-17 22:49:55',NULL,'2017-04-17 22:49:55',NULL,NULL);
insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (1065,'ROLE_ADMIN','65',0,'2017-05-12 12:49:55',NULL,'2017-05-12 12:49:55',NULL,NULL);

/*Table structure for table `sys_session` */

DROP TABLE IF EXISTS `sys_session`;

CREATE TABLE `sys_session` (
  `sessionid` varchar(100) NOT NULL,
  `session` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_session` */

insert  into `sys_session`(`sessionid`,`session`) values ('ef1b958c-cef9-44ce-96cc-4af08e717057','��\0sr\0*org.apache.shiro.session.mgt.SimpleSession���Ռbn\0\0xpw\0�t\0$ef1b958c-cef9-44ce-96cc-4af08e717057sr\0java.util.Datehj�KYt\0\0xpw\0\0\\��^xq\0~\0w\0\0\0\0\0w@\00:0:0:0:0:0:0:1sr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0shiroSavedRequestsr\0&org.apache.shiro.web.util.SavedRequest��<�y�ʺ\0L\0methodt\0Ljava/lang/String;L\0queryStringq\0~\0	L\0\nrequestURIq\0~\0	xpt\0GETpt\0/xx');
insert  into `sys_session`(`sessionid`,`session`) values ('68050dfb-6c03-432f-bb4d-ec7649f4964f','��\0sr\0*org.apache.shiro.session.mgt.SimpleSession���Ռbn\0\0xpw\0�t\0$68050dfb-6c03-432f-bb4d-ec7649f4964fsr\0java.util.Datehj�KYt\0\0xpw\0\0\\�ڶxsq\0~\0w\0\0\\\n�pxw\0\0\0\0\0w@\00:0:0:0:0:0:0:1sr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0	t\0currentUsersr\0org.cw.midc.entity.User/�NS�u�\0L\0accountt\0Ljava/lang/String;L\0birtht\0Ljava/util/Date;L\0emailq\0~\0\nL\0\nerrorCountt\0Ljava/lang/Integer;L\0isLockt\0Ljava/lang/Boolean;L\0loginIpq\0~\0\nL\0	loginTimeq\0~\0L\0mobileq\0~\0\nL\0passwordq\0~\0\nL\0sexq\0~\0L\0trueNameq\0~\0\nL\0userIdq\0~\0\nxpt\0adminsq\0~\0w\0\0T�?�xt\0\r123456@qq.comsr\0java.lang.Integer⠤���8\0I\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0sr\0java.lang.Boolean� r�՜��\0Z\0valuexp\0t\00:0:0:0:0:0:0:1pt\02017-05-12 03:01:25t\0@8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92pt\0admint\01t\0shiroSavedRequestsr\0&org.apache.shiro.web.util.SavedRequest��<�y�ʺ\0L\0methodq\0~\0\nL\0queryStringq\0~\0\nL\0\nrequestURIq\0~\0\nxpt\0GETpt\0/t\0roleIdt\0\nROLE_ADMINt\0rolessr\0java.util.ArrayListx����a�\0I\0sizexp\0\0\0w\0\0\0t\0\nROLE_ADMINxt\0roleMapsq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0t\0\nROLE_ADMINt\0超级管理员xt\0Porg.apache.shiro.subject.support.DefaultSubjectContext_AUTHENTICATED_SESSION_KEYsq\0~\0t\0userIdt\01t\0Morg.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEYsr\02org.apache.shiro.subject.SimplePrincipalCollection�X%ƣJ\0L\0realmPrincipalst\0Ljava/util/Map;xpsr\0java.util.LinkedHashMap4�N\\l��\0Z\0accessOrderxq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0t\0	UserRealmsr\0java.util.LinkedHashSet�l�Z��*\0\0xr\0java.util.HashSet�D�����4\0\0xpw\0\0\0?@\0\0\0\0\0t\0adminxx\0wq\0~\04xt\0accountt\0adminxx');
insert  into `sys_session`(`sessionid`,`session`) values ('ce2271a8-9f1e-4003-95ce-d975404d6064','��\0sr\0*org.apache.shiro.session.mgt.SimpleSession���Ռbn\0\0xpw\0�t\0$ce2271a8-9f1e-4003-95ce-d975404d6064sr\0java.util.Datehj�KYt\0\0xpw\0\0\\*�~�xq\0~\0w\0\0\0\0\0w@\00:0:0:0:0:0:0:1sr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0shiroSavedRequestsr\0&org.apache.shiro.web.util.SavedRequest��<�y�ʺ\0L\0methodt\0Ljava/lang/String;L\0queryStringq\0~\0	L\0\nrequestURIq\0~\0	xpt\0GETpt\0/xx');
insert  into `sys_session`(`sessionid`,`session`) values ('959f5089-baa7-4d64-b1f7-d83e5ef64a93','��\0sr\0*org.apache.shiro.session.mgt.SimpleSession���Ռbn\0\0xpw\0�t\0$959f5089-baa7-4d64-b1f7-d83e5ef64a93sr\0java.util.Datehj�KYt\0\0xpw\0\0\\*�Jxsq\0~\0w\0\0\\*�I�xw\0\0\0\0\0w@\00:0:0:0:0:0:0:1sr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0	t\0currentUsersr\0org.cw.midc.entity.User/�NS�u�\0L\0accountt\0Ljava/lang/String;L\0birtht\0Ljava/util/Date;L\0emailq\0~\0\nL\0\nerrorCountt\0Ljava/lang/Integer;L\0isLockt\0Ljava/lang/Boolean;L\0loginIpq\0~\0\nL\0	loginTimeq\0~\0L\0mobileq\0~\0\nL\0passwordq\0~\0\nL\0sexq\0~\0L\0trueNameq\0~\0\nL\0userIdq\0~\0\nxpt\0adminsq\0~\0w\0\0T�?�xt\0\r123456@qq.comsr\0java.lang.Integer⠤���8\0I\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0sr\0java.lang.Boolean� r�՜��\0Z\0valuexp\0t\00:0:0:0:0:0:0:1pt\02017-05-13 13:27:18t\0@8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92pt\0admint\01t\0shiroSavedRequestsr\0&org.apache.shiro.web.util.SavedRequest��<�y�ʺ\0L\0methodq\0~\0\nL\0queryStringq\0~\0\nL\0\nrequestURIq\0~\0\nxpt\0GETpt\0/t\0roleIdt\0\nROLE_ADMINt\0rolessr\0java.util.ArrayListx����a�\0I\0sizexp\0\0\0w\0\0\0t\0\nROLE_ADMINxt\0roleMapsq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0t\0\nROLE_ADMINt\0超级管理员xt\0Porg.apache.shiro.subject.support.DefaultSubjectContext_AUTHENTICATED_SESSION_KEYsq\0~\0t\0userIdt\01t\0Morg.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEYsr\02org.apache.shiro.subject.SimplePrincipalCollection�X%ƣJ\0L\0realmPrincipalst\0Ljava/util/Map;xpsr\0java.util.LinkedHashMap4�N\\l��\0Z\0accessOrderxq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0t\0	UserRealmsr\0java.util.LinkedHashSet�l�Z��*\0\0xr\0java.util.HashSet�D�����4\0\0xpw\0\0\0?@\0\0\0\0\0t\0adminxx\0wq\0~\04xt\0accountt\0adminxx');
insert  into `sys_session`(`sessionid`,`session`) values ('d059470a-ff69-4544-be54-29575c8b047d','��\0sr\0*org.apache.shiro.session.mgt.SimpleSession���Ռbn\0\0xpw\0�t\0$d059470a-ff69-4544-be54-29575c8b047dsr\0java.util.Datehj�KYt\0\0xpw\0\0\\:D��xsq\0~\0w\0\0\\:D��xw\0\0\0\0\0w@\00:0:0:0:0:0:0:1sr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0currentUsersr\0org.cw.midc.entity.User/�NS�u�\0L\0accountt\0Ljava/lang/String;L\0birtht\0Ljava/util/Date;L\0emailq\0~\0\nL\0\nerrorCountt\0Ljava/lang/Integer;L\0isLockt\0Ljava/lang/Boolean;L\0loginIpq\0~\0\nL\0	loginTimeq\0~\0L\0mobileq\0~\0\nL\0passwordq\0~\0\nL\0sexq\0~\0L\0trueNameq\0~\0\nL\0userIdq\0~\0\nxpt\0adminsq\0~\0w\0\0T�?�xt\0\r123456@qq.comsr\0java.lang.Integer⠤���8\0I\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0sr\0java.lang.Boolean� r�՜��\0Z\0valuexp\0t\00:0:0:0:0:0:0:1pt\02017-05-24 11:37:42t\0@8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92pt\0admint\01t\0roleIdt\0\nROLE_ADMINt\0rolessr\0java.util.ArrayListx����a�\0I\0sizexp\0\0\0w\0\0\0t\0\nROLE_ADMINxt\0roleMapsq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0t\0\nROLE_ADMINt\0超级管理员xt\0Porg.apache.shiro.subject.support.DefaultSubjectContext_AUTHENTICATED_SESSION_KEYsq\0~\0t\0userIdt\01t\0Morg.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEYsr\02org.apache.shiro.subject.SimplePrincipalCollection�X%ƣJ\0L\0realmPrincipalst\0Ljava/util/Map;xpsr\0java.util.LinkedHashMap4�N\\l��\0Z\0accessOrderxq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0t\0	UserRealmsr\0java.util.LinkedHashSet�l�Z��*\0\0xr\0java.util.HashSet�D�����4\0\0xpw\0\0\0?@\0\0\0\0\0t\0adminxx\0wq\0~\0/xt\0accountt\0adminxx');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) NOT NULL COMMENT '用户编号',
  `account` varchar(30) NOT NULL COMMENT '用户帐号',
  `true_name` varchar(10) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `birth` datetime DEFAULT NULL COMMENT '出生日期',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` char(11) DEFAULT NULL COMMENT '手机号码',
  `error_count` int(2) NOT NULL DEFAULT '0' COMMENT '当天登录错误次数',
  `is_lock` int(1) NOT NULL DEFAULT '0' COMMENT '用户是否锁定',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `login_ip` varchar(30) DEFAULT NULL COMMENT '用户登录IP地址',
  `is_delete` tinyint(1) NOT NULL COMMENT '软删除标识',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_idx` (`user_id`),
  UNIQUE KEY `account_idx` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`user_id`,`account`,`true_name`,`password`,`birth`,`sex`,`email`,`mobile`,`error_count`,`is_lock`,`login_time`,`login_ip`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (1,'1','admin','admin','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','2016-04-15 11:23:23',NULL,'123456@qq.com','13428281893',0,0,'2017-05-24 11:43:09','0:0:0:0:0:0:0:1',0,'2016-04-15 11:23:38',NULL,'2016-05-12 17:28:04',NULL,NULL);
insert  into `sys_user`(`id`,`user_id`,`account`,`true_name`,`password`,`birth`,`sex`,`email`,`mobile`,`error_count`,`is_lock`,`login_time`,`login_ip`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (66,'-45898497714937788461284','lis','李斯','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',NULL,NULL,NULL,'13333333333',0,0,'2017-05-03 05:44:40','0:0:0:0:0:0:0:1',0,'2017-05-03 02:34:06',NULL,'2017-05-03 02:34:06',NULL,NULL);
insert  into `sys_user`(`id`,`user_id`,`account`,`true_name`,`password`,`birth`,`sex`,`email`,`mobile`,`error_count`,`is_lock`,`login_time`,`login_ip`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (67,'-933530044149420722469311','admin2','管理员','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',NULL,NULL,'','13333333333',0,0,'2017-05-08 01:34:07','0:0:0:0:0:0:0:1',0,'2017-05-08 01:33:45',NULL,'2017-05-08 01:33:45',NULL,NULL);
insert  into `sys_user`(`id`,`user_id`,`account`,`true_name`,`password`,`birth`,`sex`,`email`,`mobile`,`error_count`,`is_lock`,`login_time`,`login_ip`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (68,'-458984977149431758457113','111111111111111111111111111111','1111111111','380b4863f69ebaacc794bfa1742a8a6ddc575e8cf0ded4341ab9da158881ea2d',NULL,NULL,'test@ne.com','13333333333',0,0,NULL,NULL,0,'2017-05-09 08:13:05',NULL,'2017-05-09 08:13:05',NULL,NULL);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(64) NOT NULL COMMENT '用户编号',
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '软删除标识',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT '0' COMMENT '创建人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT '0' COMMENT '更新人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='用户-角色表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (1,'1','ROLE_ADMIN',0,'2016-04-15 14:48:11','0','2016-04-15 14:48:13','0',NULL);
insert  into `sys_user_role`(`id`,`user_id`,`role_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (82,'-45898497714937788461284','ROLE_SENIOR_DOC',0,'2017-05-03 02:34:18',NULL,'2017-05-03 02:34:18',NULL,NULL);
insert  into `sys_user_role`(`id`,`user_id`,`role_id`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (83,'-933530044149420722469311','ROLE_ADMIN',0,'2017-05-08 01:33:56',NULL,'2017-05-08 01:33:56',NULL,NULL);

/*Table structure for table `sys_web_log` */

DROP TABLE IF EXISTS `sys_web_log`;

CREATE TABLE `sys_web_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `web_log_id` varchar(255) NOT NULL,
  `login_account` varchar(64) NOT NULL,
  `method` varchar(64) NOT NULL,
  `method_desc` varchar(100) DEFAULT NULL,
  `method_args` varchar(255) DEFAULT NULL,
  `operate_time` datetime NOT NULL,
  `operate_ip` varchar(64) NOT NULL,
  `status` varchar(4) DEFAULT NULL,
  `is_delete` int(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=344 DEFAULT CHARSET=utf8;

/*Data for the table `sys_web_log` */

insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (299,'-45898497714937788224262','admin','list','查询用户列表','[org.cw.midc.ParamFilter@6e7a1fbb]','2017-05-03 02:33:42','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:33:42',NULL,'2017-05-03 02:33:42',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (300,'-45898497714937788461193','admin','add','添加用户','[org.cw.midc.entity.User@724cc11a]','2017-05-03 02:34:06','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:34:06',NULL,'2017-05-03 02:34:06',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (301,'-45898497714937788502475','admin','list','查询用户列表','[org.cw.midc.ParamFilter@36054526]','2017-05-03 02:34:10','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:34:10',NULL,'2017-05-03 02:34:10',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (302,'-45898497714937788581666','admin','add','添加用户-角色','[-45898497714937788461284, [Ljava.lang.String;@214d17d7]','2017-05-03 02:34:18','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:34:18',NULL,'2017-05-03 02:34:18',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (303,'-45898497714937788633397','admin','list','查询医疗机构列表','[org.cw.midc.ParamFilter@703bb2db]','2017-05-03 02:34:23','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:34:23',NULL,'2017-05-03 02:34:23',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (304,'-45898497714937788975278','admin','add','添加医疗机构','[org.cw.midc.entity.Hospital@4a09cbc0]','2017-05-03 02:34:58','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:34:58',NULL,'2017-05-03 02:34:58',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (305,'-45898497714937788999429','admin','list','查询医疗机构列表','[org.cw.midc.ParamFilter@5ff95cae]','2017-05-03 02:35:00','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:35:00',NULL,'2017-05-03 02:35:00',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (306,'-458984977149377899439510','admin','add','添加医疗机构','[org.cw.midc.entity.Hospital@3ce0c0c8]','2017-05-03 02:36:34','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:36:34',NULL,'2017-05-03 02:36:34',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (307,'-458984977149377899637411','admin','list','查询医疗机构列表','[org.cw.midc.ParamFilter@c43197c]','2017-05-03 02:36:36','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:36:36',NULL,'2017-05-03 02:36:36',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (308,'-458984977149377903476612','admin','list','查询角色列表','[org.cw.midc.ParamFilter@2ac4ccda]','2017-05-03 02:37:15','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:37:15',NULL,'2017-05-03 02:37:15',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (309,'-458984977149377905380513','admin','list','查询医疗机构列表','[org.cw.midc.ParamFilter@73597f0a]','2017-05-03 02:37:34','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:37:34',NULL,'2017-05-03 02:37:34',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (310,'-458984977149377916373814','admin','list','查询用户列表','[org.cw.midc.ParamFilter@3c3be082]','2017-05-03 02:39:24','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:39:24',NULL,'2017-05-03 02:39:24',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (311,'-458984977149377924563515','admin','list','查询医疗机构列表','[org.cw.midc.ParamFilter@6f87b6eb]','2017-05-03 02:40:46','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 02:40:46',NULL,'2017-05-03 02:40:46',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (312,'-45898497714937892788392','admin','list','查询医疗机构列表','[org.cw.midc.ParamFilter@58b8dc8c]','2017-05-03 05:27:59','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 05:27:59',NULL,'2017-05-03 05:27:59',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (313,'-45898497714938212259292','admin','list','查询用户列表','[org.cw.midc.ParamFilter@34a74436]','2017-05-03 14:20:26','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 14:20:26',NULL,'2017-05-03 14:20:26',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (314,'-45898497714938212379513','admin','list','查询角色列表','[org.cw.midc.ParamFilter@4ae42056]','2017-05-03 14:20:38','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 14:20:38',NULL,'2017-05-03 14:20:38',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (315,'-45898497714938212458564','admin','list','查询医疗机构列表','[org.cw.midc.ParamFilter@30dbbd69]','2017-05-03 14:20:46','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 14:20:46',NULL,'2017-05-03 14:20:46',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (316,'-45898497714938212551575','admin','list','查询用户列表','[org.cw.midc.ParamFilter@6b670ef5]','2017-05-03 14:20:55','0:0:0:0:0:0:0:1','成功',0,'2017-05-03 14:20:55',NULL,'2017-05-03 14:20:55',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (317,'-93353004414942064403602','admin','list','查询用户列表','[org.cw.midc.ParamFilter@11120b01]','2017-05-08 01:20:40','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:20:40',NULL,'2017-05-08 01:20:40',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (318,'-93353004414942064443863','admin','list','查询角色列表','[org.cw.midc.ParamFilter@1c35066f]','2017-05-08 01:20:44','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:20:44',NULL,'2017-05-08 01:20:44',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (319,'-93353004414942064486904','admin','list','查询医疗机构列表','[org.cw.midc.ParamFilter@46c015e9]','2017-05-08 01:20:49','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:20:49',NULL,'2017-05-08 01:20:49',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (320,'-93353004414942064878045','admin','list','查询登录日志列表','[org.cw.midc.ParamFilter@12d2b816]','2017-05-08 01:21:28','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:21:28',NULL,'2017-05-08 01:21:28',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (321,'-93353004414942066122016','admin','list','查询登录日志列表','[org.cw.midc.ParamFilter@3ba87595]','2017-05-08 01:23:32','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:23:32',NULL,'2017-05-08 01:23:32',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (322,'-93353004414942071824497','admin','list','查询用户列表','[org.cw.midc.ParamFilter@5b08527d]','2017-05-08 01:33:02','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:33:02',NULL,'2017-05-08 01:33:02',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (323,'-93353004414942072015218','admin','add','添加用户','[org.cw.midc.entity.User@ba8b3d0]','2017-05-08 01:33:22','0:0:0:0:0:0:0:1','失败',0,'2017-05-08 01:33:22',NULL,'2017-05-08 01:33:22',NULL,'手机号码不能为空');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (324,'-93353004414942072180149','admin','add','添加用户','[org.cw.midc.entity.User@527291a5]','2017-05-08 01:33:38','0:0:0:0:0:0:0:1','失败',0,'2017-05-08 01:33:38',NULL,'2017-05-08 01:33:38',NULL,'手机号码格式不正确');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (325,'-933530044149420722468910','admin','add','添加用户','[org.cw.midc.entity.User@1c91bd48]','2017-05-08 01:33:45','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:33:45',NULL,'2017-05-08 01:33:45',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (326,'-933530044149420722665212','admin','list','查询用户列表','[org.cw.midc.ParamFilter@680b55b3]','2017-05-08 01:33:47','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:33:47',NULL,'2017-05-08 01:33:47',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (327,'-933530044149420723624013','admin','add','添加用户-角色','[-933530044149420722469311, [Ljava.lang.String;@7fee9fe6]','2017-05-08 01:33:56','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:33:56',NULL,'2017-05-08 01:33:56',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (328,'-933530044149420725006015','admin2','list','查询用户列表','[org.cw.midc.ParamFilter@48b6b4f0]','2017-05-08 01:34:10','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:34:10',NULL,'2017-05-08 01:34:10',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (329,'-933530044149420725133116','admin2','list','查询角色列表','[org.cw.midc.ParamFilter@163427da]','2017-05-08 01:34:11','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:34:11',NULL,'2017-05-08 01:34:11',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (330,'-933530044149420725232517','admin2','list','查询医疗机构列表','[org.cw.midc.ParamFilter@55928e50]','2017-05-08 01:34:12','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:34:12',NULL,'2017-05-08 01:34:12',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (331,'-933530044149420726278718','admin2','list','查询登录日志列表','[org.cw.midc.ParamFilter@35753e78]','2017-05-08 01:34:23','0:0:0:0:0:0:0:1','成功',0,'2017-05-08 01:34:23',NULL,'2017-05-08 01:34:23',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (332,'-45898497714943082349902','admin','list','查询用户列表','[org.cw.midc.ParamFilter@149e4d66]','2017-05-09 05:37:15','0:0:0:0:0:0:0:1','成功',0,'2017-05-09 05:37:15',NULL,'2017-05-09 05:37:15',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (333,'-45898497714943082428803','admin','list','查询医疗机构列表','[org.cw.midc.ParamFilter@7cb3dbe4]','2017-05-09 05:37:23','0:0:0:0:0:0:0:1','成功',0,'2017-05-09 05:37:23',NULL,'2017-05-09 05:37:23',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (334,'-45898497714943082479054','admin','list','查询用户列表','[org.cw.midc.ParamFilter@2f814f39]','2017-05-09 05:37:28','0:0:0:0:0:0:0:1','成功',0,'2017-05-09 05:37:28',NULL,'2017-05-09 05:37:28',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (335,'-45898497714943085589035','admin','list','查询登录日志列表','[org.cw.midc.ParamFilter@171c41b4]','2017-05-09 05:42:39','0:0:0:0:0:0:0:1','成功',0,'2017-05-09 05:42:39',NULL,'2017-05-09 05:42:39',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (336,'-45898497714943085651436','admin','list','查询用户列表','[org.cw.midc.ParamFilter@59c68309]','2017-05-09 05:42:45','0:0:0:0:0:0:0:1','成功',0,'2017-05-09 05:42:45',NULL,'2017-05-09 05:42:45',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (337,'-45898497714943085664937','admin','list','查询角色列表','[org.cw.midc.ParamFilter@3c4f2c58]','2017-05-09 05:42:46','0:0:0:0:0:0:0:1','成功',0,'2017-05-09 05:42:46',NULL,'2017-05-09 05:42:46',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (338,'-45898497714943085676228','admin','list','查询医疗机构列表','[org.cw.midc.ParamFilter@6501c6ac]','2017-05-09 05:42:48','0:0:0:0:0:0:0:1','成功',0,'2017-05-09 05:42:48',NULL,'2017-05-09 05:42:48',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (339,'-458984977149431755210010','admin','list','查询用户列表','[org.cw.midc.ParamFilter@4af6927d]','2017-05-09 08:12:32','0:0:0:0:0:0:0:1','成功',0,'2017-05-09 08:12:32',NULL,'2017-05-09 08:12:32',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (340,'-458984977149431757976911','admin','add','添加用户','[org.cw.midc.entity.User@59da49c6]','2017-05-09 08:13:00','0:0:0:0:0:0:0:1','失败',0,'2017-05-09 08:13:00',NULL,'2017-05-09 08:13:00',NULL,'手机号码格式不正确');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (341,'-458984977149431758456112','admin','add','添加用户','[org.cw.midc.entity.User@23f44647]','2017-05-09 08:13:05','0:0:0:0:0:0:0:1','成功',0,'2017-05-09 08:13:05',NULL,'2017-05-09 08:13:05',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (342,'-458984977149431758687014','admin','list','查询用户列表','[org.cw.midc.ParamFilter@1e505ec4]','2017-05-09 08:13:07','0:0:0:0:0:0:0:1','成功',0,'2017-05-09 08:13:07',NULL,'2017-05-09 08:13:07',NULL,'操作成功');
insert  into `sys_web_log`(`id`,`web_log_id`,`login_account`,`method`,`method_desc`,`method_args`,`operate_time`,`operate_ip`,`status`,`is_delete`,`create_time`,`create_by`,`update_time`,`update_by`,`remark`) values (343,'-45898497714953678553732','admin','list','查询用户列表','[org.cw.midc.ParamFilter@1d99d0f8]','2017-05-21 11:57:35','0:0:0:0:0:0:0:1','成功',0,'2017-05-21 11:57:35',NULL,'2017-05-21 11:57:35',NULL,'操作成功');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
