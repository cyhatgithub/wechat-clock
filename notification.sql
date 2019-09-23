/*
 Navicat MySQL Data Transfer

 Source Server         : 172_16_132_128
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : 172.16.132.128
 Source Database       : notification

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : utf-8

 Date: 09/23/2019 19:24:25 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_time` datetime DEFAULT NULL COMMENT '上课时间（年月日是第一次上课的时间，用来计算星期几）',
  `end_time` datetime DEFAULT NULL COMMENT '下课时间（年月日是第一次上课的时间，用来计算星期几）',
  `course_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `teacher` varchar(255) DEFAULT NULL COMMENT '上课老师',
  `classroom` varchar(255) DEFAULT NULL COMMENT '上课教室',
  `begin_time` datetime DEFAULT NULL COMMENT '课程开始时间',
  `finish_time` datetime DEFAULT NULL COMMENT '课程结束时间',
  `isSingle` varchar(255) DEFAULT NULL COMMENT '是否单周上课',
  `user_open_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `course`
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', '2019-09-20 08:00:00', '2019-09-20 10:00:00', '中国历史', '李三', '四教4211', '2019-09-01 11:23:31', '2019-12-31 11:23:50', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('2', '2019-09-23 18:24:00', '2019-09-23 18:10:00', '西方政治', '张四', '三教3211', '2019-09-01 11:23:31', '2019-12-31 11:23:50', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('3', '2019-09-20 10:10:00', '2019-09-23 10:38:43', '体育', '王五', '二教2411', '2019-09-23 10:38:23', '2019-09-23 10:38:20', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `birthday` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

SET FOREIGN_KEY_CHECKS = 1;
