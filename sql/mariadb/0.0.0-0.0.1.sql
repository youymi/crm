/*
Navicat MariaDB Data Transfer

Source Server         : 10.180.120.63
Source Server Version : 50538
Source Host           : 10.180.120.63:3308
Source Database       : crm

Target Server Type    : MariaDB
Target Server Version : 50538
File Encoding         : 65001

Date: 2014-08-28 10:05:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_crm_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_activity`;
CREATE TABLE `t_crm_activity` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `company_id` bigint(20) DEFAULT NULL COMMENT '所属公司ID',
  `date` datetime DEFAULT NULL COMMENT '时间',
  `content` varchar(255) DEFAULT NULL COMMENT '跟进内容',
  `user_id` bigint(20) DEFAULT NULL COMMENT '填写人ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '填写人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_crm_attention
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_attention`;
CREATE TABLE `t_crm_attention` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `contact_date` datetime DEFAULT NULL COMMENT '需要联系时间',
  `content` varchar(255) DEFAULT NULL COMMENT '需要联系的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关注客户表';

-- ----------------------------
-- Table structure for t_crm_company
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_company`;
CREATE TABLE `t_crm_company` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `code` varchar(50) DEFAULT NULL COMMENT '客户编码',
  `type` varchar(50) DEFAULT '0' COMMENT '客户类型 0潜在客户 1联系客户 2跟进客户 3合作客户 4VIP客户 5暂停客户',
  `name` varchar(255) DEFAULT NULL COMMENT '客户名称',
  `region` varchar(50) DEFAULT NULL COMMENT '区域',
  `trade` varchar(20) DEFAULT NULL COMMENT '行业',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话',
  `fax` varchar(15) DEFAULT NULL COMMENT '传真',
  `address` varchar(255) DEFAULT NULL COMMENT '客户地址',
  `url` varchar(255) DEFAULT NULL COMMENT '网址',
  `business` varchar(20) DEFAULT NULL COMMENT '主营业务',
  `staffs` int(10) DEFAULT NULL COMMENT '职工数',
  `user_id` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL COMMENT '负责销售人员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户的公司信息';

-- ----------------------------
-- Table structure for t_crm_contact
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_contact`;
CREATE TABLE `t_crm_contact` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `company_id` bigint(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '客户公司联系人姓名',
  `position` varchar(50) DEFAULT NULL COMMENT '客户公司联系人职位',
  `phone` varchar(15) DEFAULT NULL COMMENT '客户公司联系人电话',
  `email` varchar(50) DEFAULT NULL COMMENT '客户公司联系人邮件',
  `remark` varchar(255) DEFAULT NULL COMMENT '客户公司联系人说明',
  `level` char(1) DEFAULT NULL COMMENT '客户公司联系人级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户公司联系人';

-- ----------------------------
-- Table structure for t_crm_contract
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_contract`;
CREATE TABLE `t_crm_contract` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司ID',
  `code` varchar(50) DEFAULT NULL COMMENT '合同编码',
  `name` varchar(255) DEFAULT NULL COMMENT '合同名称',
  `money` varchar(20) DEFAULT NULL COMMENT '合同金额',
  `sign_date` datetime DEFAULT NULL COMMENT '签订日期',
  `user_id` bigint(20) DEFAULT NULL COMMENT '销售（签订人）',
  `user_name` varchar(50) DEFAULT NULL,
  `collect_date` datetime DEFAULT NULL COMMENT '收款时间',
  `detail` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户公司合同信息';

-- ----------------------------
-- Table structure for t_crm_contract_ext
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_contract_ext`;
CREATE TABLE `t_crm_contract_ext` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `contract_id` bigint(20) DEFAULT NULL,
  `dfile_id` varchar(255) DEFAULT NULL,
  `dfile_name` varchar(255) DEFAULT NULL,
  `dfile_size` varchar(50) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同扩展信息（附件什么的）';

-- ----------------------------
-- Table structure for t_crm_customer_assign
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_customer_assign`;
CREATE TABLE `t_crm_customer_assign` (
  `id` bigint(20) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_crm_datadictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_datadictionary`;
CREATE TABLE `t_crm_datadictionary` (
  `id` bigint(20) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `value` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_crm_tocontactor
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_tocontactor`;
CREATE TABLE `t_crm_tocontactor` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) DEFAULT NULL COMMENT '销售ID',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司ID',
  `contact_date` datetime DEFAULT NULL COMMENT '需要联系时间',
  `content` varchar(255) DEFAULT NULL COMMENT '需要联系的内容',
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='crm使用人员待联系客户公司信息';
