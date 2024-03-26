# DDL
DROP DATABASE IF EXISTS `team3_community_1`;

CREATE DATABASE IF NOT EXISTS `team3_community_1`;

USE `team3_community_1`;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)	PRIMARY KEY,
	`me_ms_state`	varchar(8)	NOT NULL,
	`me_pw`	varchar(15)	NOT NULL,
	`me_email`	varchar(20)	NOT NULL,
	`me_name`	varchar(15)	NOT NULL,
	`me_phone`	varchar(13)	NOT NULL,
	`me_authority`	varchar(5)	NOT NULL DEFAULT 'WUSER',
	`me_fail_count`	int	NOT NULL default 0,
	`me_stop`	datetime	
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
	`bo_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`bo_ca_num`	int	NOT NULL,
	`bo_name`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
	`po_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`po_bo_num`	int	NOT NULL,
	`po_me_id`	varchar(15)	NOT NULL,
	`po_title`		text	NOT NULL,
	`po_content`	text	NOT NULL,
	`po_view`	int	NOT NULL DEFAULT 0,
	`po_date`	datetime	NOT NULL,
	`po_report_count`	int	NOT NULL DEFAULT 0,
	`po_temp`	int	NOT NULL DEFAULT 0,
	`po_notice`	int	NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS `File`;

CREATE TABLE `File` (
	`fi_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`fi_po_num`	int	NOT NULL,
	`fi_name`	varchar(250)	NOT NULL,
	`fi_ori_name`	varchar(50)	NOT NULL
);

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
	`re_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`re_me_id`	varchar(15)	NOT NULL,
	`re_rt_name`	varchar(15)	NOT NULL,
	`re_table`	varchar(10)	NOT NULL,
	`re_content`	text	NOT NULL,
	`re_state`	varchar(8)	NOT NULL DEFAULT '신고접수',
	`re_target`	int	NOT NULL
);

DROP TABLE IF EXISTS `member_state`;

CREATE TABLE `member_state` (
	`ms_state`	varchar(8)	PRIMARY KEY
);

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
	`rc_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`rc_po_num`	int	NOT NULL,
	`rc_me_id`	varchar(15)	NOT NULL,
	`rc_state`	varchar(5)	NOT NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`cm_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`cm_po_num`	int	NOT NULL,
	`cm_me_id`	varchar(15)	NOT NULL,
	`cm_content`	text	NOT NULL
);

DROP TABLE IF EXISTS `report_type`;

CREATE TABLE `report_type` (
	`rt_name`	varchar(15)	PRIMARY KEY
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`ca_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`ca_name`	varchar(15)	NOT NULL
);

ALTER TABLE `member` ADD CONSTRAINT `FK_member_state_TO_member_1` FOREIGN KEY (
	`me_ms_state`
)
REFERENCES `member_state` (
	`ms_state`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_category_TO_board_1` FOREIGN KEY (
	`bo_ca_num`
)
REFERENCES `category` (
	`ca_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_board_TO_post_1` FOREIGN KEY (
	`po_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_member_TO_post_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `File` ADD CONSTRAINT `FK_post_TO_File_1` FOREIGN KEY (
	`fi_po_num`
)
REFERENCES `post` (
	`po_num`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_member_TO_report_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_report_type_TO_report_1` FOREIGN KEY (
	`re_rt_name`
)
REFERENCES `report_type` (
	`rt_name`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_post_TO_recommend_1` FOREIGN KEY (
	`rc_po_num`
)
REFERENCES `post` (
	`po_num`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_member_TO_recommend_1` FOREIGN KEY (
	`rc_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_post_TO_comment_1` FOREIGN KEY (
	`cm_po_num`
)
REFERENCES `post` (
	`po_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`cm_me_id`
)
REFERENCES `member` (
	`me_id`
);