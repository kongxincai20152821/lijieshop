/*
Navicat MySQL Data Transfer

Source Server         : ssh1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : lijie_shop

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-03-24 11:21:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `ausername` varchar(50) NOT NULL,
  `apwd` varchar(50) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', '李杰', 'wzw2015578');

-- ----------------------------
-- Table structure for `admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_userrole` (`aid`),
  KEY `role_userrole` (`rid`),
  CONSTRAINT `admin_role` FOREIGN KEY (`aid`) REFERENCES `admin` (`admin_id`),
  CONSTRAINT `role_admin` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('1', '2', '1');

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goodsName` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `newPrice` int(11) NOT NULL,
  `introduce` varchar(255) NOT NULL,
  `logo_path` varchar(255) NOT NULL,
  PRIMARY KEY (`cid`),
  KEY `collection_user` (`user_id`),
  KEY `collection_goods` (`goods_id`),
  CONSTRAINT `collection_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `collection_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('1', '1', '1', '', '0', '0', '', '');
INSERT INTO `collection` VALUES ('3', '2', '1', '辣椒', '20', '10', '好辣', 'images/2.jpg');
INSERT INTO `collection` VALUES ('8', '2', '3', '小吃', '30', '10', '好香', 'images/2.jpg');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `publish_time` date NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_user` (`user_id`),
  KEY `comment_goods` (`goods_id`),
  CONSTRAINT `comment_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `comment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '2', '1', '111', '111', '2019-03-27');
INSERT INTO `comment` VALUES ('3', '1', '1', '222', '222', '2019-03-19');
INSERT INTO `comment` VALUES ('5', '2', '1', '333', '333', '2019-03-12');
INSERT INTO `comment` VALUES ('6', '2', '1', '111', '188888', '2019-03-24');

-- ----------------------------
-- Table structure for `discount`
-- ----------------------------
DROP TABLE IF EXISTS `discount`;
CREATE TABLE `discount` (
  `discount_id` int(11) NOT NULL AUTO_INCREMENT,
  `new_price` int(11) NOT NULL,
  `discount_number` int(5) NOT NULL,
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discount
-- ----------------------------
INSERT INTO `discount` VALUES ('1', '222', '8');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `ltype_id` int(11) NOT NULL,
  `goodsName` varchar(100) NOT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `newPrice` int(11) NOT NULL,
  `lnTime` date NOT NULL,
  `newGoods` int(1) NOT NULL,
  `sale` int(11) NOT NULL,
  `goods_total` int(11) NOT NULL,
  `state` int(1) NOT NULL,
  `type` int(1) NOT NULL,
  `logo_path` varchar(255) NOT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `goods_ltype` (`ltype_id`),
  KEY `goods_type` (`type`),
  CONSTRAINT `goods_ltype` FOREIGN KEY (`ltype_id`) REFERENCES `little_type` (`ltype_id`),
  CONSTRAINT `goods_type` FOREIGN KEY (`type`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '1', '辣椒', '好辣', '20', '10', '2019-03-14', '1', '20', '200', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('2', '1', '方便面', '好吃', '10', '5', '2019-03-15', '1', '10', '20', '1', '2', 'images/2.jpg');
INSERT INTO `goods` VALUES ('3', '1', '小吃', '好香', '30', '10', '2019-03-16', '1', '30', '50', '1', '3', 'images/2.jpg');
INSERT INTO `goods` VALUES ('4', '1', '饼干', '好吃', '12', '5', '2019-03-16', '1', '10', '300', '1', '4', 'images/2.jpg');
INSERT INTO `goods` VALUES ('7', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '5', 'images/2.jpg');
INSERT INTO `goods` VALUES ('8', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '6', 'images/2.jpg');
INSERT INTO `goods` VALUES ('9', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('10', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('11', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('12', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('13', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('14', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('15', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('16', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('17', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('18', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('19', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('20', '1', '111', '商品', '100', '50', '2019-03-16', '1', '20', '50', '1', '1', 'images/2.jpg');
INSERT INTO `goods` VALUES ('21', '1', '牛肉', '好吃', '10', '9', '2019-03-22', '1', '10', '20', '1', '1', 'images/1.jpg');

-- ----------------------------
-- Table structure for `goods_order`
-- ----------------------------
DROP TABLE IF EXISTS `goods_order`;
CREATE TABLE `goods_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `order_username` varchar(50) NOT NULL,
  `recevieName` varchar(50) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone` int(20) NOT NULL,
  `orderDate` date NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_user` (`user_id`),
  CONSTRAINT `order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_order
-- ----------------------------
INSERT INTO `goods_order` VALUES ('1', '1', 'ww', 'w', 'zz', '123', '2019-03-14', '111', '0');
INSERT INTO `goods_order` VALUES ('2', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-18', '', '0');
INSERT INTO `goods_order` VALUES ('3', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-18', '', '0');
INSERT INTO `goods_order` VALUES ('4', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-18', '', '0');
INSERT INTO `goods_order` VALUES ('5', '2', '通用商城订单', '1111', '1111', '11111111', '2019-03-18', '111', '0');
INSERT INTO `goods_order` VALUES ('6', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-18', '', '0');
INSERT INTO `goods_order` VALUES ('7', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-18', '', '0');
INSERT INTO `goods_order` VALUES ('8', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-19', '', '0');
INSERT INTO `goods_order` VALUES ('9', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-19', '', '0');
INSERT INTO `goods_order` VALUES ('10', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-19', '', '70');
INSERT INTO `goods_order` VALUES ('11', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-20', '', '70');
INSERT INTO `goods_order` VALUES ('12', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-21', '', '205');
INSERT INTO `goods_order` VALUES ('13', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-21', '', '255');
INSERT INTO `goods_order` VALUES ('14', '2', '通用商城订单', '1111', '1111', '1111', '2019-03-22', '', '255');

-- ----------------------------
-- Table structure for `little_type`
-- ----------------------------
DROP TABLE IF EXISTS `little_type`;
CREATE TABLE `little_type` (
  `ltype_id` int(11) NOT NULL AUTO_INCREMENT,
  `stype_id` int(11) NOT NULL,
  `ltype_name` varchar(50) NOT NULL,
  PRIMARY KEY (`ltype_id`),
  KEY `super_little` (`stype_id`),
  CONSTRAINT `super_little` FOREIGN KEY (`stype_id`) REFERENCES `super_type` (`stype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of little_type
-- ----------------------------
INSERT INTO `little_type` VALUES ('1', '3', '女装');
INSERT INTO `little_type` VALUES ('2', '3', '男装');
INSERT INTO `little_type` VALUES ('3', '2', '程序设计');
INSERT INTO `little_type` VALUES ('4', '2', '小说类');
INSERT INTO `little_type` VALUES ('5', '2', '心理学');
INSERT INTO `little_type` VALUES ('6', '2', '电子书');
INSERT INTO `little_type` VALUES ('7', '1', '洗衣机');
INSERT INTO `little_type` VALUES ('8', '1', '空调');
INSERT INTO `little_type` VALUES ('9', '4', '瓜子类');
INSERT INTO `little_type` VALUES ('10', '4', '牛奶');
INSERT INTO `little_type` VALUES ('11', '5', '电脑修理');
INSERT INTO `little_type` VALUES ('12', '5', '软件系统开发');
INSERT INTO `little_type` VALUES ('13', '5', '网站搭建');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `pcode` varchar(20) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `url` varchar(200) NOT NULL,
  `state` int(11) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('101', '01', '', '管理员管理', '', '1', '人员档案');
INSERT INTO `menu` VALUES ('102', '0101', '01', '管理员基本信息', 'admin.jsp', '1', '人员档案1');
INSERT INTO `menu` VALUES ('103', '0102', '01', '订单管理', 'order.jsp', '1', '人员档案');
INSERT INTO `menu` VALUES ('104', '0103', '01', '订单细节管理', 'order_detail.jsp', '1', '人员档案1');
INSERT INTO `menu` VALUES ('108', '02', '', '商品管理', '', '1', '人事调配');
INSERT INTO `menu` VALUES ('109', '0201', '02', '商品基本信息', 'goods.jsp', '1', '职称聘任管理1');
INSERT INTO `menu` VALUES ('110', '0202', '02', '商品打折管理', 'discount.jsp', '1', '教育培训');
INSERT INTO `menu` VALUES ('111', '0203', '02', '商品评论管理', 'comment.jsp', '1', '培训管理');
INSERT INTO `menu` VALUES ('114', '04', '', '商品分类管理', '', '1', '系统管理');
INSERT INTO `menu` VALUES ('115', '0401', '04', '商品大分类管理', 'super_type.jsp', '1', '用户管理');
INSERT INTO `menu` VALUES ('116', '0402', '04', '商品小分类管理', 'little_type.jsp', '1', '角色管理');
INSERT INTO `menu` VALUES ('125', '05', null, '用户管理', '', '1', '111');
INSERT INTO `menu` VALUES ('126', '0501', '05', '用户基本信息管理', 'user.jsp', '1', null);
INSERT INTO `menu` VALUES ('127', '0502', '05', '用户购物车管理', 'shop.jsp', '1', null);
INSERT INTO `menu` VALUES ('128', '0503', '05', '商品收藏夹管理', 'collection.jsp', '1', null);
INSERT INTO `menu` VALUES ('129', '0403', '04', '商品类型', 'type.jsp', '1', null);
INSERT INTO `menu` VALUES ('130', '0204', '02', '商品图片上传', 'upload.jsp', '1', null);

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderID` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_detail` (`orderID`),
  KEY `detail_goods` (`goods_id`),
  CONSTRAINT `detail_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `order_detail` FOREIGN KEY (`orderID`) REFERENCES `goods_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1', '1', '1', '111', '11');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '角色管理12');
INSERT INTO `role` VALUES ('2', '商店老板', '角色管理1');
INSERT INTO `role` VALUES ('3', '普通员工', '角色管理');

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rolemenu_role` (`rid`),
  KEY `rolemenu_menu` (`mid`),
  CONSTRAINT `menu` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`),
  CONSTRAINT `role` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '101');
INSERT INTO `role_menu` VALUES ('2', '1', '102');
INSERT INTO `role_menu` VALUES ('3', '1', '103');
INSERT INTO `role_menu` VALUES ('4', '1', '104');
INSERT INTO `role_menu` VALUES ('6', '1', '108');
INSERT INTO `role_menu` VALUES ('7', '1', '109');
INSERT INTO `role_menu` VALUES ('8', '1', '110');
INSERT INTO `role_menu` VALUES ('9', '1', '111');
INSERT INTO `role_menu` VALUES ('10', '1', '114');
INSERT INTO `role_menu` VALUES ('11', '1', '115');
INSERT INTO `role_menu` VALUES ('12', '1', '116');
INSERT INTO `role_menu` VALUES ('13', '1', '125');
INSERT INTO `role_menu` VALUES ('14', '1', '126');
INSERT INTO `role_menu` VALUES ('15', '1', '127');
INSERT INTO `role_menu` VALUES ('16', '1', '128');
INSERT INTO `role_menu` VALUES ('17', '1', '129');
INSERT INTO `role_menu` VALUES ('18', '1', '130');

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shop_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goodsName` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `logo_path` varchar(255) NOT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `shop_user` (`user_id`),
  KEY `shop_goods` (`goods_id`),
  CONSTRAINT `shop_goods` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `shop_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('38', '2', '1', '辣椒', '10', '4', 'images/2.jpg');
INSERT INTO `shop` VALUES ('39', '2', '2', '方便面', '5', '1', 'images/2.jpg');
INSERT INTO `shop` VALUES ('40', '2', '4', '饼干', '5', '1', 'images/2.jpg');
INSERT INTO `shop` VALUES ('43', '2', '2', '方便面', '5', '1', 'images/2.jpg');
INSERT INTO `shop` VALUES ('47', '2', '10', '111', '50', '1', 'images/2.jpg');
INSERT INTO `shop` VALUES ('50', '2', '9', '111', '50', '1', 'images/2.jpg');
INSERT INTO `shop` VALUES ('51', '2', '10', '111', '50', '1', 'images/2.jpg');
INSERT INTO `shop` VALUES ('52', '2', '12', '111', '50', '1', 'images/2.jpg');

-- ----------------------------
-- Table structure for `super_type`
-- ----------------------------
DROP TABLE IF EXISTS `super_type`;
CREATE TABLE `super_type` (
  `stype_id` int(11) NOT NULL AUTO_INCREMENT,
  `stype_name` varchar(50) NOT NULL,
  PRIMARY KEY (`stype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of super_type
-- ----------------------------
INSERT INTO `super_type` VALUES ('1', '电子类');
INSERT INTO `super_type` VALUES ('2', '图书类');
INSERT INTO `super_type` VALUES ('3', '服装类');
INSERT INTO `super_type` VALUES ('4', '食品类');
INSERT INTO `super_type` VALUES ('5', '生活服务类');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '热门商品');
INSERT INTO `type` VALUES ('2', '活动商品');
INSERT INTO `type` VALUES ('3', '今日推荐');
INSERT INTO `type` VALUES ('4', '猜你喜欢');
INSERT INTO `type` VALUES ('5', '二手');
INSERT INTO `type` VALUES ('6', '其他');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `trueName` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `postCode` int(30) NOT NULL,
  `IDcardNo` int(50) NOT NULL,
  `IDcardType` int(10) NOT NULL,
  `discount_id` int(11) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `phone` int(20) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `user_state` int(1) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_discount` (`discount_id`),
  CONSTRAINT `user_discount` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lijie', '李杰', 'wzw2015578', '麻城', '三河', '438300', '421181199', '1', '1', '1', '1363307', '111', '1');
INSERT INTO `user` VALUES ('2', 'lijie1', '1111', '1111', '1111', '1111', '1111', '1111', '1', '1', '0', '1111', '1160320205@qq.com', '1');
