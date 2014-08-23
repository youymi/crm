-- --------------------------------------------------------
-- 主机:                           10.180.128.208
-- 服务器版本:                        5.5.38-MariaDB - MariaDB Server
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 crm 的数据库结构
CREATE DATABASE IF NOT EXISTS `crm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `crm`;


-- 导出  表 crm.t_crm_activity 结构
CREATE TABLE IF NOT EXISTS `t_crm_activity` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `company_id` bigint(20) DEFAULT NULL COMMENT '所属公司ID',
  `date` datetime DEFAULT NULL COMMENT '时间',
  `content` varchar(255) DEFAULT NULL COMMENT '跟进内容',
  `user_id` bigint(20) DEFAULT NULL COMMENT '填写人ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '填写人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 crm.t_crm_attention 结构
CREATE TABLE IF NOT EXISTS `t_crm_attention` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `contact_date` datetime DEFAULT NULL COMMENT '需要联系时间',
  `content` varchar(255) DEFAULT NULL COMMENT '需要联系的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关注客户表';

-- 数据导出被取消选择。


-- 导出  表 crm.t_crm_company 结构
CREATE TABLE IF NOT EXISTS `t_crm_company` (
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户的公司信息';

-- 数据导出被取消选择。


-- 导出  表 crm.t_crm_contact 结构
CREATE TABLE IF NOT EXISTS `t_crm_contact` (
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

-- 数据导出被取消选择。


-- 导出  表 crm.t_crm_contract 结构
CREATE TABLE IF NOT EXISTS `t_crm_contract` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司ID',
  `code` varchar(50) DEFAULT NULL COMMENT '合同编码',
  `name` varchar(255) DEFAULT NULL COMMENT '合同名称',
  `money` varchar(20) DEFAULT NULL COMMENT '合同金额',
  `sign_date` datetime DEFAULT NULL COMMENT '签订日期',
  `user_id` bigint(20) DEFAULT NULL COMMENT '销售（签订人）',
  `collect_date` datetime DEFAULT NULL COMMENT '收款时间',
  `detail` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户公司合同信息';

-- 数据导出被取消选择。


-- 导出  表 crm.t_crm_contract_ext 结构
CREATE TABLE IF NOT EXISTS `t_crm_contract_ext` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `contract_id` bigint(20) DEFAULT NULL,
  `dfile_id` varchar(255) DEFAULT NULL,
  `dfile_name` varchar(255) DEFAULT NULL,
  `dfile_size` varchar(50) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同扩展信息（附件什么的）';

-- 数据导出被取消选择。


-- 导出  表 crm.t_crm_customer_assign 结构
CREATE TABLE IF NOT EXISTS `t_crm_customer_assign` (
  `id` bigint(20) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 crm.t_crm_datadictionary 结构
CREATE TABLE IF NOT EXISTS `t_crm_datadictionary` (
  `id` bigint(20) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `value` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 crm.t_crm_tocontactor 结构
CREATE TABLE IF NOT EXISTS `t_crm_tocontactor` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) DEFAULT NULL COMMENT '销售ID',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司ID',
  `contact_date` datetime DEFAULT NULL COMMENT '需要联系时间',
  `content` varchar(255) DEFAULT NULL COMMENT '需要联系的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='crm使用人员待联系客户公司信息';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
