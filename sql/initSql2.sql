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

DROP TABLE IF EXISTS `media_info`;

CREATE TABLE `media_info` (
  `media_id` varchar(128) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `media_name` varchar(128) DEFAULT NULL,
  `path` varchar(128) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`media_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

DROP TABLE IF EXISTS `ris_pacs_rel`;

CREATE TABLE `ris_pacs_rel` (
  `study_info_id` varchar(64) NOT NULL,
  `study_uid` varchar(128) NOT NULL,
  PRIMARY KEY (`study_info_id`,`study_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

DROP TABLE IF EXISTS `study_check_pos`;

CREATE TABLE `study_check_pos` (
  `study_cp_id` int(11) NOT NULL AUTO_INCREMENT,
  `check_item` varchar(256) DEFAULT NULL,
  `position` varchar(256) DEFAULT NULL,
  `sub_position` varchar(256) DEFAULT NULL,
  `studyinfo_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`study_cp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


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


--

DROP TABLE IF EXISTS `checkitem`;
CREATE TABLE `checkitem` (
  `checkitem_id` int(11) NOT NULL AUTO_INCREMENT,
  `checkitem_name` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_available` varchar(4) DEFAULT NULL,
  `oper_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`checkitem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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


DROP TABLE IF EXISTS `positiontype`;
CREATE TABLE `positiontype` (
  `positiontype_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `is_available` varchar(4) DEFAULT NULL,
  `oper_id` varchar(32) DEFAULT NULL,
  `positiontype_name` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`positiontype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


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

