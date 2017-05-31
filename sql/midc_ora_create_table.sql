
CREATE SEQUENCE "S_CHECKITEM"
/

CREATE SEQUENCE "S_DPC"
/

CREATE SEQUENCE "S_POSITIONTYPE"
/

CREATE SEQUENCE "S_STUDY_CHECK_POS"
/

CREATE SEQUENCE "S_SYS_DICT"
/

CREATE SEQUENCE "S_SYS_LOGIN_LOG"
/

CREATE SEQUENCE "S_SYS_MENU"
/

CREATE SEQUENCE "S_SYS_ROLE"
/

CREATE SEQUENCE "S_SYS_ROLE_MENU"
/

CREATE SEQUENCE "S_SYS_USER"
/

CREATE SEQUENCE "S_SYS_USER_ROLE"
/

CREATE SEQUENCE "S_SYS_WEB_LOG"
/

/*==============================================================*/
/* TABLE: "CHECKITEM"                                           */
/*==============================================================*/
CREATE TABLE "CHECKITEM"  (
   "CHECKITEM_ID"       NUMBER(6)                       NOT NULL,
   "CHECKITEM_NAME"     VARCHAR2(64)                   DEFAULT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "IS_AVAILABLE"       VARCHAR2(4)                    DEFAULT NULL,
   "OPER_ID"            VARCHAR2(32)                   DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   CONSTRAINT PK_CHECKITEM PRIMARY KEY ("CHECKITEM_ID")
)
/

/*==============================================================*/
/* TABLE: "DEVICE_TYPE"                                         */
/*==============================================================*/
CREATE TABLE "DEVICE_TYPE"  (
   "DEVICE_TYPE_ID"     VARCHAR2(32)                    NOT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "DEVICE_TYPE_NAME"   VARCHAR2(64)                   DEFAULT NULL,
   "IS_AVAILABLE"       VARCHAR2(4)                    DEFAULT NULL,
   "OPER_ID"            VARCHAR2(32)                   DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   CONSTRAINT PK_DEVICE_TYPE PRIMARY KEY ("DEVICE_TYPE_ID")
)
/

/*==============================================================*/
/* TABLE: "DEVICETYPE_POSITION_CHECKITEM"                       */
/*==============================================================*/
CREATE TABLE "DEVICETYPE_POSITION_CHECKITEM"  (
   "ID"                 NUMBER(6)                       NOT NULL,
   "CHECKITEM_ID"       INTEGER                        DEFAULT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "DEVICE_TYPE_ID"     VARCHAR2(255)                  DEFAULT NULL,
   "OPER_ID"            VARCHAR2(32)                   DEFAULT NULL,
   "POSITIONTYPE_ID"    INTEGER                        DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   "DEVICETYPENAME"     VARCHAR2(255)                  DEFAULT NULL,
   "CHECKITEMNAME"      VARCHAR2(255)                  DEFAULT NULL,
   "POSITIONTYPENAME"   VARCHAR2(255)                  DEFAULT NULL,
   CONSTRAINT PK_DEVICETYPE_POSITION_CHECKIT PRIMARY KEY ("ID")
)
/

/*==============================================================*/
/* TABLE: "FILE_INFO"                                           */
/*==============================================================*/
CREATE TABLE "FILE_INFO"  (
   "FILE_ID"            VARCHAR2(128)                   NOT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "FAILED_REASON"      VARCHAR2(256)                  DEFAULT NULL,
   "FILE_PATH"          VARCHAR2(128)                  DEFAULT NULL,
   "HOSPITAL_ID"        VARCHAR2(64)                   DEFAULT NULL,
   "MEDIA_ID"           VARCHAR2(64)                   DEFAULT NULL,
   "ORIG_FILE_NAME"     VARCHAR2(128)                  DEFAULT NULL,
   "STATUS"             VARCHAR2(4)                    DEFAULT NULL,
   "STUDY_INFO_ID"      VARCHAR2(64)                   DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   "USER_ID"            VARCHAR2(64)                   DEFAULT NULL,
   CONSTRAINT PK_FILE_INFO PRIMARY KEY ("FILE_ID")
)
/

/*==============================================================*/
/* TABLE: "HOSPITAL"                                            */
/*==============================================================*/
CREATE TABLE "HOSPITAL"  (
   "HOSP_ID"            VARCHAR2(32)                    NOT NULL,
   "ADDRESS"            VARCHAR2(256)                  DEFAULT NULL,
   "CLIENT_ID"          VARCHAR2(32)                   DEFAULT NULL,
   "CLIENT_SECRET"      VARCHAR2(64)                   DEFAULT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "HOSP_NAME"          VARCHAR2(64)                   DEFAULT NULL,
   "IS_AVAILABLE"       VARCHAR2(4)                    DEFAULT NULL,
   "IS_CONNECTED"       VARCHAR2(4)                    DEFAULT NULL,
   "LAST_HB_TIME"       DATE                           DEFAULT NULL,
   "LATITUDE"           FLOAT                          DEFAULT NULL,
   "LONGITUDE"          FLOAT                          DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   CONSTRAINT PK_HOSPITAL PRIMARY KEY ("HOSP_ID")
)
/

/*==============================================================*/
/* TABLE: "INSTANCE"                                            */
/*==============================================================*/
CREATE TABLE "INSTANCE"  (
   "INSTANCE_UID"       VARCHAR2(128)                   NOT NULL,
   "ACQ_DATE_TIME"      DATE                           DEFAULT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "FILE_ID"            VARCHAR2(128)                  DEFAULT NULL,
   "INST_NO"            VARCHAR2(128)                  DEFAULT NULL,
   "SERIES_UID"         VARCHAR2(128)                  DEFAULT NULL,
   "SOP_IUID"           VARCHAR2(128)                  DEFAULT NULL,
   CONSTRAINT PK_INSTANCE PRIMARY KEY ("INSTANCE_UID")
)
/

/*==============================================================*/
/* TABLE: "MEDIA_INFO"                                          */
/*==============================================================*/
CREATE TABLE "MEDIA_INFO"  (
   "MEDIA_ID"           VARCHAR2(128)                   NOT NULL,
   "STORAGE_ID"         VARCHAR2(128)                   NOT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "MEDIA_NAME"         VARCHAR2(128)                  DEFAULT NULL,
   "PATH"               VARCHAR2(128)                  DEFAULT NULL,
   "STATUS"             VARCHAR2(4)                    DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   CONSTRAINT PK_MEDIA_INFO PRIMARY KEY ("MEDIA_ID")
)
/

/*==============================================================*/
/* TABLE: "OAUTH_ACCESS_TOKEN"                                  */
/*==============================================================*/
CREATE TABLE "OAUTH_ACCESS_TOKEN"  (
   "ACCESS_TOKEN"       VARCHAR2(32)                    NOT NULL,
   "CLIENT_ID"          VARCHAR2(32)                   DEFAULT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "REFRESH_TOKEN"      VARCHAR2(32)                   DEFAULT NULL,
   "REFRESH_TOKEN_EXPIRED_SECONDS" INTEGER                        DEFAULT NULL,
   "TOKEN_EXPIRED_SECONDS" INTEGER                        DEFAULT NULL,
   "TOKEN_TYPE"         VARCHAR2(255)                  DEFAULT NULL,
   CONSTRAINT PK_OAUTH_ACCESS_TOKEN PRIMARY KEY ("ACCESS_TOKEN")
)
/

/*==============================================================*/
/* TABLE: "PATIENT"                                             */
/*==============================================================*/
CREATE TABLE "PATIENT"  (
   "PAT_ID"             VARCHAR2(64)                    NOT NULL,
   "ADDRESS"            VARCHAR2(512)                  DEFAULT NULL,
   "BIRTHDAY"           DATE                           DEFAULT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "ID_NUMBER"          VARCHAR2(32)                   DEFAULT NULL,
   "NATIONALITY"        VARCHAR2(128)                  DEFAULT NULL,
   "OPER_ID"            VARCHAR2(64)                   DEFAULT NULL,
   "PAT_CARD_ID"        VARCHAR2(128)                  DEFAULT NULL,
   "PAT_NAME"           VARCHAR2(64)                    NOT NULL,
   "PAT_SPELL_NAME"     VARCHAR2(128)                  DEFAULT NULL,
   "PATIENT_TYPE"       VARCHAR2(4)                    DEFAULT NULL,
   "PHONE_NUMBER"       VARCHAR2(32)                   DEFAULT NULL,
   "SEX"                VARCHAR2(4)                    DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   CONSTRAINT PK_PATIENT PRIMARY KEY ("PAT_ID")
)
/

/*==============================================================*/
/* TABLE: "POSITIONTYPE"                                        */
/*==============================================================*/
CREATE TABLE "POSITIONTYPE"  (
   "POSITIONTYPE_ID"    NUMBER(6)                       NOT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "IS_AVAILABLE"       VARCHAR2(4)                    DEFAULT NULL,
   "OPER_ID"            VARCHAR2(32)                   DEFAULT NULL,
   "POSITIONTYPE_NAME"  VARCHAR2(64)                   DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   CONSTRAINT PK_POSITIONTYPE PRIMARY KEY ("POSITIONTYPE_ID")
)
/

/*==============================================================*/
/* TABLE: "REPORT"                                              */
/*==============================================================*/
CREATE TABLE "REPORT"  (
   "RPT_ID"             VARCHAR2(64)                    NOT NULL,
   "ADVICE"             VARCHAR2(4000)                 DEFAULT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "DIAGNOSIS"          VARCHAR2(4000)                 DEFAULT NULL,
   "D_DOC_ID"           VARCHAR2(64)                   DEFAULT NULL,
   "J_DOC_ID"           VARCHAR2(64)                   DEFAULT NULL,
   "S_DOC_ID"           VARCHAR2(64)                   DEFAULT NULL,
   "STATUS"             VARCHAR2(4)                    DEFAULT NULL,
   "STUDYINFO_ID"       VARCHAR2(128)                  DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   "DESCRIPTION"        VARCHAR2(4000)                 DEFAULT NULL,
   "DEVICE_TYPE"        VARCHAR2(64)                   DEFAULT NULL,
   CONSTRAINT PK_REPORT PRIMARY KEY ("RPT_ID")
)
/

/*==============================================================*/
/* TABLE: "RIS_PACS_REL"                                        */
/*==============================================================*/
CREATE TABLE "RIS_PACS_REL"  (
   "STUDY_INFO_ID"      VARCHAR2(64)                    NOT NULL,
   "STUDY_UID"          VARCHAR2(128)                   NOT NULL,
   CONSTRAINT PK_RIS_PACS_REL PRIMARY KEY ("STUDY_INFO_ID", "STUDY_UID")
)
/

/*==============================================================*/
/* TABLE: "SERIES"                                              */
/*==============================================================*/
CREATE TABLE "SERIES"  (
   "SERIES_UID"         VARCHAR2(128)                   NOT NULL,
   "BODY_PART"          VARCHAR2(128)                  DEFAULT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "IMAGE_COUNT"        INTEGER                        DEFAULT NULL,
   "SERIES_DESC"        VARCHAR2(128)                  DEFAULT NULL,
   "SERIES_IUID"        VARCHAR2(128)                  DEFAULT NULL,
   "SERIES_NO"          VARCHAR2(128)                  DEFAULT NULL,
   "STUDY_UID"          VARCHAR2(128)                  DEFAULT NULL,
   CONSTRAINT PK_SERIES PRIMARY KEY ("SERIES_UID")
)
/

/*==============================================================*/
/* TABLE: "STORAGE_INFO"                                        */
/*==============================================================*/
CREATE TABLE "STORAGE_INFO"  (
   "STORAGE_ID"         VARCHAR2(128)                   NOT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "NAME"               VARCHAR2(128)                  DEFAULT NULL,
   "PATH"               VARCHAR2(128)                  DEFAULT NULL,
   "STATUS"             VARCHAR2(4)                    DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   CONSTRAINT PK_STORAGE_INFO PRIMARY KEY ("STORAGE_ID")
)
/

/*==============================================================*/
/* TABLE: "STUDY"                                               */
/*==============================================================*/
CREATE TABLE "STUDY"  (
   "STUDY_UID"          VARCHAR2(128)                   NOT NULL,
   "ACCESS_NO"          VARCHAR2(128)                  DEFAULT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "INST_CNT"           INTEGER                        DEFAULT NULL,
   "MODALITY"           VARCHAR2(128)                  DEFAULT NULL,
   "PAT_AGE"            VARCHAR2(255)                  DEFAULT NULL,
   "PAT_BIRTH"          DATE                           DEFAULT NULL,
   "PAT_ID"             VARCHAR2(128)                  DEFAULT NULL,
   "PAT_NAME"           VARCHAR2(128)                  DEFAULT NULL,
   "PAT_SEX"            VARCHAR2(128)                  DEFAULT NULL,
   "PAT_SIZE"           FLOAT                          DEFAULT NULL,
   "PAT_WEIGHT"         FLOAT                          DEFAULT NULL,
   "STATUS"             VARCHAR2(8)                    DEFAULT NULL,
   "STUDY_DESC"         VARCHAR2(128)                  DEFAULT NULL,
   "STUDY_ID"           VARCHAR2(128)                  DEFAULT NULL,
   "STUDY_IUID"         VARCHAR2(128)                  DEFAULT NULL,
   "STUDY_TIME"         DATE                           DEFAULT NULL,
   "USER_ID"            VARCHAR2(128)                  DEFAULT NULL,
   CONSTRAINT PK_STUDY PRIMARY KEY ("STUDY_UID")
)
/

/*==============================================================*/
/* TABLE: "STUDY_CHECK_POS"                                     */
/*==============================================================*/
CREATE TABLE "STUDY_CHECK_POS"  (
   "STUDY_CP_ID"        NUMBER(6)                       NOT NULL,
   "CHECK_ITEM"         VARCHAR2(256)                  DEFAULT NULL,
   "POSITION"           VARCHAR2(256)                  DEFAULT NULL,
   "SUB_POSITION"       VARCHAR2(256)                  DEFAULT NULL,
   "STUDYINFO_ID"       VARCHAR2(64)                   DEFAULT NULL,
   CONSTRAINT PK_STUDY_CHECK_POS PRIMARY KEY ("STUDY_CP_ID")
)
/

/*==============================================================*/
/* TABLE: "STUDY_INFO"                                          */
/*==============================================================*/
CREATE TABLE "STUDY_INFO"  (
   "STUDYINFO_ID"       VARCHAR2(64)                    NOT NULL,
   "ABS_HISTORY"        VARCHAR2(512)                  DEFAULT NULL,
   "AGE"                INTEGER                        DEFAULT NULL,
   "AGE_UNIT"           VARCHAR2(8)                    DEFAULT NULL,
   "APPLY_DEP_NAME"     VARCHAR2(64)                   DEFAULT NULL,
   "APPLY_DOC_NAME"     VARCHAR2(64)                   DEFAULT NULL,
   "APPLY_TIME"         DATE                           DEFAULT NULL,
   "CLINICAL_MANIFEST"  VARCHAR2(3600)                 DEFAULT NULL,
   "CREATE_TIME"        DATE                           DEFAULT NULL,
   "HOSP_ID"            VARCHAR2(128)                  DEFAULT NULL,
   "IS_AVAILABLE"       VARCHAR2(4)                    DEFAULT NULL,
   "ORG_STUDYINFO_ID"   VARCHAR2(64)                   DEFAULT NULL,
   "PHOTO_MAKER_ID"     VARCHAR2(128)                  DEFAULT NULL,
   "POSITION_CHECKITEM" VARCHAR2(128)                  DEFAULT NULL,
   "PRE_DIAGNOSE"       VARCHAR2(512)                  DEFAULT NULL,
   "RPT_STATUS"         VARCHAR2(4)                    DEFAULT NULL,
   "STATUS"             VARCHAR2(4)                    DEFAULT NULL,
   "STUDY_DEMAND"       VARCHAR2(3600)                 DEFAULT NULL,
   "STUDY_DESC"         VARCHAR2(3600)                 DEFAULT NULL,
   "TRANS_STATUS"       VARCHAR2(4)                    DEFAULT NULL,
   "UPDATE_TIME"        DATE                           DEFAULT NULL,
   "PAT_ID"             VARCHAR2(64)                   DEFAULT NULL,
   "RPT_ID"             VARCHAR2(64)                   DEFAULT NULL,
   "DEVICE_TYPE"        VARCHAR2(64)                   DEFAULT NULL,
   CONSTRAINT PK_STUDY_INFO PRIMARY KEY ("STUDYINFO_ID")
)
/

/*==============================================================*/
/* TABLE: "SYS_DICT"                                            */
/*==============================================================*/
CREATE TABLE "SYS_DICT"  (
   "ID"                 NUMBER(6)                       NOT NULL,
   "PARENT_ID"          VARCHAR2(64)                   DEFAULT NULL,
   "CODE"               VARCHAR2(255)                  DEFAULT NULL,
   "NAME"               VARCHAR2(255)                  DEFAULT NULL,
   "SEQ"                SMALLINT                       DEFAULT NULL,
   "TYPE"               VARCHAR2(255)                  DEFAULT NULL,
   "IS_CATAGORY"        CHAR(1)                        DEFAULT NULL,
   "IS_DELETE"          SMALLINT                        NOT NULL,
   "CREATE_TIME"        DATE                            NOT NULL,
   "CREATE_BY"          VARCHAR2(64)                   DEFAULT NULL,
   "UPDATE_TIME"        DATE                            NOT NULL,
   "UPDATE_BY"          VARCHAR2(64)                   DEFAULT NULL,
   "REMARK"             VARCHAR2(100)                  DEFAULT NULL,
   CONSTRAINT PK_SYS_DICT PRIMARY KEY ("ID")
)
/

COMMENT ON COLUMN "SYS_DICT"."IS_CATAGORY" IS
'是否作为分类菜单  Y , N'
/

COMMENT ON COLUMN "SYS_DICT"."IS_DELETE" IS
'软删除标识'
/

COMMENT ON COLUMN "SYS_DICT"."CREATE_TIME" IS
'创建时间'
/

COMMENT ON COLUMN "SYS_DICT"."CREATE_BY" IS
'创建人'
/

COMMENT ON COLUMN "SYS_DICT"."UPDATE_TIME" IS
'更新时间'
/

COMMENT ON COLUMN "SYS_DICT"."UPDATE_BY" IS
'更新人'
/

COMMENT ON COLUMN "SYS_DICT"."REMARK" IS
'备注'
/

/*==============================================================*/
/* TABLE: "SYS_LOGIN_LOG"                                       */
/*==============================================================*/
CREATE TABLE "SYS_LOGIN_LOG"  (
   "ID"                 NUMBER(6)                       NOT NULL,
   "LOGIN_LOG_ID"       VARCHAR2(64)                    NOT NULL,
   "LOGIN_ACCOUNT"      VARCHAR2(30)                    NOT NULL,
   "LOGIN_TIME"         DATE                            NOT NULL,
   "LOGIN_IP"           VARCHAR2(255)                   NOT NULL,
   "STATUS"             VARCHAR2(32)                    NOT NULL,
   "IS_DELETE"          INTEGER                         NOT NULL,
   "CREATE_TIME"        DATE                            NOT NULL,
   "CREATE_BY"          VARCHAR2(255)                  DEFAULT NULL,
   "UPDATE_TIME"        DATE                            NOT NULL,
   "UPDATE_BY"          VARCHAR2(255)                  DEFAULT NULL,
   "REMARK"             VARCHAR2(255)                  DEFAULT NULL,
   CONSTRAINT PK_SYS_LOGIN_LOG PRIMARY KEY ("ID")
)
/

/*==============================================================*/
/* TABLE: "SYS_MENU"                                            */
/*==============================================================*/
CREATE TABLE "SYS_MENU"  (
   "ID"                 NUMBER(6)                       NOT NULL,
   "MENU_ID"            VARCHAR2(64)                    NOT NULL,
   "NAME"               VARCHAR2(30)                    NOT NULL,
   "URL"                VARCHAR2(30)                   DEFAULT NULL,
   "TYPE"               INTEGER                        DEFAULT NULL,
   "ICON"               VARCHAR2(30)                   DEFAULT '',
   "IS_SHOW"            INTEGER                         NOT NULL,
   "SEQ"                INTEGER                        DEFAULT NULL,
   "PARENT_ID"          VARCHAR2(64)                   DEFAULT '0',
   "PARENT_NAME"        VARCHAR2(20)                   DEFAULT NULL,
   "IS_DELETE"          SMALLINT                       DEFAULT 0 NOT NULL,
   "CREATE_BY"          VARCHAR2(64)                   DEFAULT '0',
   "CREATE_TIME"        DATE                            NOT NULL,
   "UPDATE_BY"          VARCHAR2(64)                   DEFAULT '0',
   "UPDATE_TIME"        DATE                            NOT NULL,
   "REMARK"             VARCHAR2(255)                  DEFAULT NULL,
   CONSTRAINT PK_SYS_MENU PRIMARY KEY ("ID")
)
/

COMMENT ON COLUMN "SYS_MENU"."MENU_ID" IS
'资源编号'
/

COMMENT ON COLUMN "SYS_MENU"."NAME" IS
'菜单名称'
/

COMMENT ON COLUMN "SYS_MENU"."URL" IS
'菜单URL'
/

COMMENT ON COLUMN "SYS_MENU"."TYPE" IS
'菜单类型(0为一级菜单,2为二级菜单,3为按钮)'
/

COMMENT ON COLUMN "SYS_MENU"."ICON" IS
'菜单图标'
/

COMMENT ON COLUMN "SYS_MENU"."IS_SHOW" IS
'是否显示(1为是，0为不是)'
/

COMMENT ON COLUMN "SYS_MENU"."SEQ" IS
'菜单顺序'
/

COMMENT ON COLUMN "SYS_MENU"."PARENT_ID" IS
'上级菜单ID'
/

COMMENT ON COLUMN "SYS_MENU"."IS_DELETE" IS
'软删除标识'
/

COMMENT ON COLUMN "SYS_MENU"."CREATE_BY" IS
'创建人'
/

COMMENT ON COLUMN "SYS_MENU"."CREATE_TIME" IS
'创建时间'
/

COMMENT ON COLUMN "SYS_MENU"."UPDATE_BY" IS
'更新人'
/

COMMENT ON COLUMN "SYS_MENU"."UPDATE_TIME" IS
'更新时间'
/

COMMENT ON COLUMN "SYS_MENU"."REMARK" IS
'备注'
/

/*==============================================================*/
/* TABLE: "SYS_ROLE"                                            */
/*==============================================================*/
CREATE TABLE "SYS_ROLE"  (
   "ID"                 NUMBER(6)                       NOT NULL,
   "ROLE_ID"            VARCHAR2(64)                    NOT NULL,
   "NAME"               VARCHAR2(32)                    NOT NULL
)
/

COMMENT ON COLUMN "SYS_ROLE"."ID" IS
'角色ID'
/

COMMENT ON COLUMN "SYS_ROLE"."ROLE_ID" IS
'角色编号'
/

COMMENT ON COLUMN "SYS_ROLE"."NAME" IS
'角色名称'
/

/*==============================================================*/
/* TABLE: "SYS_ROLE_MENU"                                       */
/*==============================================================*/
CREATE TABLE "SYS_ROLE_MENU"  (
   "ID"                 NUMBER(6)                       NOT NULL,
   "ROLE_ID"            VARCHAR2(64)                    NOT NULL,
   "MENU_ID"            VARCHAR2(64)                    NOT NULL,
   "IS_DELETE"          INTEGER                        DEFAULT 0 NOT NULL,
   "CREATE_TIME"        DATE                            NOT NULL,
   "CREATE_BY"          VARCHAR2(64)                   DEFAULT '0',
   "UPDATE_TIME"        DATE                            NOT NULL,
   "UPDATE_BY"          VARCHAR2(64)                   DEFAULT '0',
   "REMARK"             VARCHAR2(255)                  DEFAULT NULL,
   CONSTRAINT PK_SYS_ROLE_MENU PRIMARY KEY ("ID", "ROLE_ID", "MENU_ID")
)
/

COMMENT ON COLUMN "SYS_ROLE_MENU"."ID" IS
'主键'
/

COMMENT ON COLUMN "SYS_ROLE_MENU"."ROLE_ID" IS
'角色编号'
/

COMMENT ON COLUMN "SYS_ROLE_MENU"."MENU_ID" IS
'资源编号'
/

COMMENT ON COLUMN "SYS_ROLE_MENU"."IS_DELETE" IS
'软删除标识'
/

COMMENT ON COLUMN "SYS_ROLE_MENU"."CREATE_TIME" IS
'创建时间'
/

COMMENT ON COLUMN "SYS_ROLE_MENU"."CREATE_BY" IS
'创建人'
/

COMMENT ON COLUMN "SYS_ROLE_MENU"."UPDATE_TIME" IS
'更新时间'
/

COMMENT ON COLUMN "SYS_ROLE_MENU"."UPDATE_BY" IS
'更新人'
/

COMMENT ON COLUMN "SYS_ROLE_MENU"."REMARK" IS
'备注信息'
/

/*==============================================================*/
/* TABLE: "SYS_SESSION"                                         */
/*==============================================================*/
CREATE TABLE "SYS_SESSION"  (
   "SESSIONID"          VARCHAR2(100)                   NOT NULL,
   "SESSIONDATA"            BLOB
)
/

/*==============================================================*/
/* TABLE: "SYS_USER"                                            */
/*==============================================================*/
CREATE TABLE "SYS_USER"  (
   "ID"                 NUMBER(6)                       NOT NULL,
   "USER_ID"            VARCHAR2(64)                    NOT NULL,
   "ACCOUNT"            VARCHAR2(30)                    NOT NULL,
   "TRUE_NAME"          VARCHAR2(10)                   DEFAULT NULL,
   "PASSWORD"           VARCHAR2(100)                   NOT NULL,
   "BIRTH"              DATE                           DEFAULT NULL,
   "SEX"                VARCHAR2(30)                       DEFAULT NULL,
   "EMAIL"              VARCHAR2(30)                   DEFAULT NULL,
   "MOBILE"             CHAR(11)                       DEFAULT NULL,
   "ERROR_COUNT"        INTEGER                        DEFAULT 0 NOT NULL,
   "IS_LOCK"            INTEGER                        DEFAULT 0 NOT NULL,
   "LOGIN_TIME"         DATE                           DEFAULT NULL,
   "LOGIN_IP"           VARCHAR2(30)                   DEFAULT NULL,
   "IS_DELETE"          SMALLINT                        NOT NULL,
   "CREATE_TIME"        DATE                            NOT NULL,
   "CREATE_BY"          VARCHAR2(64)                   DEFAULT NULL,
   "UPDATE_TIME"        DATE                            NOT NULL,
   "UPDATE_BY"          VARCHAR2(64)                   DEFAULT NULL,
   "REMARK"             VARCHAR2(100)                  DEFAULT NULL,
   CONSTRAINT PK_SYS_USER PRIMARY KEY ("ID")
)
/

COMMENT ON COLUMN "SYS_USER"."USER_ID" IS
'用户编号'
/

COMMENT ON COLUMN "SYS_USER"."ACCOUNT" IS
'用户帐号'
/

COMMENT ON COLUMN "SYS_USER"."TRUE_NAME" IS
'真实姓名'
/

COMMENT ON COLUMN "SYS_USER"."PASSWORD" IS
'密码'
/

COMMENT ON COLUMN "SYS_USER"."BIRTH" IS
'出生日期'
/

COMMENT ON COLUMN "SYS_USER"."SEX" IS
'性别'
/

COMMENT ON COLUMN "SYS_USER"."EMAIL" IS
'电子邮箱'
/

COMMENT ON COLUMN "SYS_USER"."MOBILE" IS
'手机号码'
/

COMMENT ON COLUMN "SYS_USER"."ERROR_COUNT" IS
'当天登录错误次数'
/

COMMENT ON COLUMN "SYS_USER"."IS_LOCK" IS
'用户是否锁定'
/

COMMENT ON COLUMN "SYS_USER"."LOGIN_TIME" IS
'登录时间'
/

COMMENT ON COLUMN "SYS_USER"."LOGIN_IP" IS
'用户登录IP地址'
/

COMMENT ON COLUMN "SYS_USER"."IS_DELETE" IS
'软删除标识'
/

COMMENT ON COLUMN "SYS_USER"."CREATE_TIME" IS
'创建时间'
/

COMMENT ON COLUMN "SYS_USER"."CREATE_BY" IS
'创建人'
/

COMMENT ON COLUMN "SYS_USER"."UPDATE_TIME" IS
'更新时间'
/

COMMENT ON COLUMN "SYS_USER"."UPDATE_BY" IS
'更新人'
/

COMMENT ON COLUMN "SYS_USER"."REMARK" IS
'备注'
/

/*==============================================================*/
/* TABLE: "SYS_USER_ROLE"                                       */
/*==============================================================*/
CREATE TABLE "SYS_USER_ROLE"  (
   "ID"                 NUMBER(6)                       NOT NULL,
   "USER_ID"            VARCHAR2(64)                    NOT NULL,
   "ROLE_ID"            VARCHAR2(64)                    NOT NULL,
   "IS_DELETE"          SMALLINT                       DEFAULT 0 NOT NULL,
   "CREATE_TIME"        DATE                            NOT NULL,
   "CREATE_BY"          VARCHAR2(64)                   DEFAULT '0',
   "UPDATE_TIME"        DATE                            NOT NULL,
   "UPDATE_BY"          VARCHAR2(64)                   DEFAULT '0',
   "REMARK"             VARCHAR2(255)                  DEFAULT NULL,
   CONSTRAINT PK_SYS_USER_ROLE PRIMARY KEY ("ID")
)
/

COMMENT ON COLUMN "SYS_USER_ROLE"."ID" IS
'主键ID'
/

COMMENT ON COLUMN "SYS_USER_ROLE"."USER_ID" IS
'用户编号'
/

COMMENT ON COLUMN "SYS_USER_ROLE"."ROLE_ID" IS
'角色编号'
/

COMMENT ON COLUMN "SYS_USER_ROLE"."IS_DELETE" IS
'软删除标识'
/

COMMENT ON COLUMN "SYS_USER_ROLE"."CREATE_TIME" IS
'创建时间'
/

COMMENT ON COLUMN "SYS_USER_ROLE"."CREATE_BY" IS
'创建人'
/

COMMENT ON COLUMN "SYS_USER_ROLE"."UPDATE_TIME" IS
'更新时间'
/

COMMENT ON COLUMN "SYS_USER_ROLE"."UPDATE_BY" IS
'更新人'
/

COMMENT ON COLUMN "SYS_USER_ROLE"."REMARK" IS
'备注'
/

/*==============================================================*/
/* TABLE: "SYS_WEB_LOG"                                         */
/*==============================================================*/
CREATE TABLE "SYS_WEB_LOG"  (
   "ID"                 NUMBER(6)                       NOT NULL,
   "WEB_LOG_ID"         VARCHAR2(255)                   NOT NULL,
   "LOGIN_ACCOUNT"      VARCHAR2(64)                    NOT NULL,
   "METHOD"             VARCHAR2(64)                    NOT NULL,
   "METHOD_DESC"        VARCHAR2(100)                  DEFAULT NULL,
   "METHOD_ARGS"        VARCHAR2(255)                  DEFAULT NULL,
   "OPERATE_TIME"       DATE                            NOT NULL,
   "OPERATE_IP"         VARCHAR2(64)                    NOT NULL,
   "STATUS"             VARCHAR2(32)                    DEFAULT NULL,
   "IS_DELETE"          INTEGER                         NOT NULL,
   "CREATE_TIME"        DATE                            NOT NULL,
   "CREATE_BY"          VARCHAR2(64)                   DEFAULT NULL,
   "UPDATE_TIME"        DATE                            NOT NULL,
   "UPDATE_BY"          VARCHAR2(64)                   DEFAULT NULL,
   "REMARK"             VARCHAR2(1024)                  DEFAULT NULL,
   CONSTRAINT PK_SYS_WEB_LOG PRIMARY KEY ("ID")
)
/


CREATE TRIGGER "TIB_CHECKITEM" BEFORE INSERT
ON "CHECKITEM" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""CHECKITEM_ID"" USES SEQUENCE S_CHECKITEM
    SELECT S_CHECKITEM.NEXTVAL INTO :NEW."CHECKITEM_ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_DEVICETYPE_POSITION_CHECKI" BEFORE INSERT
ON "DEVICETYPE_POSITION_CHECKITEM" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""ID"" USES SEQUENCE S_DPC
    SELECT S_DPC.NEXTVAL INTO :NEW."ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_POSITIONTYPE" BEFORE INSERT
ON "POSITIONTYPE" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""POSITIONTYPE_ID"" USES SEQUENCE S_POSITIONTYPE
    SELECT S_POSITIONTYPE.NEXTVAL INTO :NEW."POSITIONTYPE_ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_STUDY_CHECK_POS" BEFORE INSERT
ON "STUDY_CHECK_POS" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""STUDY_CP_ID"" USES SEQUENCE S_STUDY_CHECK_POS
    SELECT S_STUDY_CHECK_POS.NEXTVAL INTO :NEW."STUDY_CP_ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_SYS_DICT" BEFORE INSERT
ON "SYS_DICT" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""ID"" USES SEQUENCE S_SYS_DICT
    SELECT S_SYS_DICT.NEXTVAL INTO :NEW."ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_SYS_LOGIN_LOG" BEFORE INSERT
ON "SYS_LOGIN_LOG" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""ID"" USES SEQUENCE S_SYS_LOGIN_LOG
    SELECT S_SYS_LOGIN_LOG.NEXTVAL INTO :NEW."ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_SYS_MENU" BEFORE INSERT
ON "SYS_MENU" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""ID"" USES SEQUENCE S_SYS_MENU
    SELECT S_SYS_MENU.NEXTVAL INTO :NEW."ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_SYS_ROLE" BEFORE INSERT
ON "SYS_ROLE" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""ID"" USES SEQUENCE S_SYS_ROLE
    SELECT S_SYS_ROLE.NEXTVAL INTO :NEW."ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_SYS_ROLE_MENU" BEFORE INSERT
ON "SYS_ROLE_MENU" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""ID"" USES SEQUENCE S_SYS_ROLE_MENU
    SELECT S_SYS_ROLE_MENU.NEXTVAL INTO :NEW."ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_SYS_USER" BEFORE INSERT
ON "SYS_USER" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""ID"" USES SEQUENCE S_SYS_USER
    SELECT S_SYS_USER.NEXTVAL INTO :NEW."ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_SYS_USER_ROLE" BEFORE INSERT
ON "SYS_USER_ROLE" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""ID"" USES SEQUENCE S_SYS_USER_ROLE
    SELECT S_SYS_USER_ROLE.NEXTVAL INTO :NEW."ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/


CREATE TRIGGER "TIB_SYS_WEB_LOG" BEFORE INSERT
ON "SYS_WEB_LOG" FOR EACH ROW
DECLARE
    INTEGRITY_ERROR  EXCEPTION;
    ERRNO            INTEGER;
    ERRMSG           CHAR(200);
    DUMMY            INTEGER;
    FOUND            BOOLEAN;

BEGIN
    --  COLUMN ""ID"" USES SEQUENCE S_SYS_WEB_LOG
    SELECT S_SYS_WEB_LOG.NEXTVAL INTO :NEW."ID" FROM DUAL;

--  ERRORS HANDLING
EXCEPTION
    WHEN INTEGRITY_ERROR THEN
       RAISE_APPLICATION_ERROR(ERRNO, ERRMSG);
END;
/

