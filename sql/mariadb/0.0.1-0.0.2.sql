ALTER TABLE `t_crm_company`
	ADD COLUMN `user_id` VARCHAR(50) NULL DEFAULT NULL AFTER `staffs`,
	ADD COLUMN `user_name` VARCHAR(50) NULL DEFAULT NULL COMMENT '负责销售人员' AFTER `user_id`;