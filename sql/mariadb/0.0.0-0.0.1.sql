-- --------------------------------------------------------
-- 主机:                           10.180.120.63
-- 服务器版本:                        5.5.29-MariaDB-log - MariaDB Server, wsrep_23.7.3.rXXXX
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 crm 的数据库结构
DROP DATABASE IF EXISTS `crm`;
CREATE DATABASE IF NOT EXISTS `crm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `crm`;


-- 导出  表 crm.t_crm_activity 结构
DROP TABLE IF EXISTS `t_crm_activity`;
CREATE TABLE IF NOT EXISTS `t_crm_activity` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `company_id` bigint(20) DEFAULT NULL COMMENT '所属公司ID',
  `date` datetime DEFAULT NULL COMMENT '时间',
  `content` varchar(255) DEFAULT NULL COMMENT '跟进内容',
  `user_id` bigint(20) DEFAULT NULL COMMENT '填写人ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '填写人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  crm.t_crm_activity 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_crm_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crm_activity` ENABLE KEYS */;


-- 导出  表 crm.t_crm_attention 结构
DROP TABLE IF EXISTS `t_crm_attention`;
CREATE TABLE IF NOT EXISTS `t_crm_attention` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关注客户表';

-- 正在导出表  crm.t_crm_attention 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_crm_attention` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crm_attention` ENABLE KEYS */;


-- 导出  表 crm.t_crm_company 结构
DROP TABLE IF EXISTS `t_crm_company`;
CREATE TABLE IF NOT EXISTS `t_crm_company` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `code` varchar(50) DEFAULT NULL COMMENT '客户编码',
  `type` varchar(50) DEFAULT NULL COMMENT '客户类型 0潜在客户 1联系客户 2跟进客户 3合作客户 4VIP客户 5暂停客户',
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

-- 正在导出表  crm.t_crm_company 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_crm_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crm_company` ENABLE KEYS */;


-- 导出  表 crm.t_crm_connecter 结构
DROP TABLE IF EXISTS `t_crm_connecter`;
CREATE TABLE IF NOT EXISTS `t_crm_connecter` (
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

-- 正在导出表  crm.t_crm_connecter 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_crm_connecter` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crm_connecter` ENABLE KEYS */;


-- 导出  表 crm.t_crm_contact 结构
DROP TABLE IF EXISTS `t_crm_contact`;
CREATE TABLE IF NOT EXISTS `t_crm_contact` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `user_id` bigint(20) DEFAULT NULL COMMENT '销售ID',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司ID',
  `contact_date` datetime DEFAULT NULL COMMENT '需要联系时间',
  `content` varchar(255) DEFAULT NULL COMMENT '需要联系的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='crm使用人员待联系客户公司信息';

-- 正在导出表  crm.t_crm_contact 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_crm_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crm_contact` ENABLE KEYS */;


-- 导出  表 crm.t_crm_contract 结构
DROP TABLE IF EXISTS `t_crm_contract`;
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

-- 正在导出表  crm.t_crm_contract 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_crm_contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crm_contract` ENABLE KEYS */;


-- 导出  表 crm.t_crm_contract_ext 结构
DROP TABLE IF EXISTS `t_crm_contract_ext`;
CREATE TABLE IF NOT EXISTS `t_crm_contract_ext` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `contract_id` bigint(20) DEFAULT NULL,
  `dfile_id` varchar(255) DEFAULT NULL,
  `dfile_name` varchar(255) DEFAULT NULL,
  `dfile_size` varchar(50) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同扩展信息（附件什么的）';

-- 正在导出表  crm.t_crm_contract_ext 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_crm_contract_ext` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crm_contract_ext` ENABLE KEYS */;


-- 导出  表 crm.t_crm_customer_assign 结构
DROP TABLE IF EXISTS `t_crm_customer_assign`;
CREATE TABLE IF NOT EXISTS `t_crm_customer_assign` (
  `id` bigint(20) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  crm.t_crm_customer_assign 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_crm_customer_assign` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_crm_customer_assign` ENABLE KEYS */;


-- 导出  表 crm.t_crm_datadictionary 结构
DROP TABLE IF EXISTS `t_crm_datadictionary`;
CREATE TABLE IF NOT EXISTS `t_crm_datadictionary` (
  `id` bigint(20) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `value` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  crm.t_crm_datadictionary 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `t_crm_datadictionary` DISABLE KEYS */;
INSERT INTO `t_crm_datadictionary` (`id`, `type`, `name`, `value`) VALUES
	(1, 'customer_type', '潜在客户', '属于公司客户的范畴，对于公司产品有需求的可能性'),
	(2, 'customer_type', '联系客户', '属于公司要开发客户的范畴，业务人员和他们保持联系，但三个月内对方没有购买我公司产品的意向。'),
	(3, 'customer_type', '跟进客户', '客户方公司在最近三个月内对于我公司生产的产品有实质性的需求，需要相关业务人员对其进行密切关注，做到知己知彼，尽全力争取其合作的成功率。'),
	(4, 'customer_type', '合作客户', '客户已经和我们合作，但是合作的次数较少，成交的总金额较小的客户。'),
	(5, 'customer_type', 'VIP客户', '客户已经和我们合作，并且合作的次数≥3次并且成交的总金额大于200万元。'),
	(6, 'customer_type', '暂停客户', '有过联系或者有过合作，由于其它原因不能有进一步业务发展的客户。');
/*!40000 ALTER TABLE `t_crm_datadictionary` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
