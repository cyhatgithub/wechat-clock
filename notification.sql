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

 Date: 09/25/2019 16:36:22 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `course`
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', '2019-09-09 08:45:00', '2019-09-09 10:20:00', '中国特色社会主义理论与实践研究（研）', '张兆鑫', '南B101', '2019-09-09 00:00:00', '2019-11-04 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('2', '2019-08-27 08:45:00', '2019-08-27 10:20:00', '医学文献检索（研）', '崔元璐', '北C101', '2019-08-27 00:00:00', '2019-10-22 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('3', '2019-09-11 08:45:00', '2019-09-11 10:20:00', '中医科研思路与方法（研）', '徐宗佩', '北C102', '2019-09-11 00:00:00', '2019-09-18 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('4', '2019-09-12 08:45:00', '2019-09-12 10:20:00', '硕士英语（研）', '张瑾', '南B101', '2019-09-12 00:00:00', '2019-11-07 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('5', '2019-09-13 08:45:00', '2019-09-13 10:20:00', '医学统计学（研）', '步怀恩', '北C102', '2019-09-13 00:00:00', '2019-11-08 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('6', '2019-09-09 10:35:00', '2019-09-09 12:10:00', '中国特色社会主义理论与实践研究（研）', '张兆鑫', '南B101', '2019-09-09 00:00:00', '2019-11-04 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('8', '2019-08-27 10:35:00', '2019-08-27 12:10:00', '医学文献检索（研）', '崔元璐', '北C101', '2019-08-27 00:00:00', '2019-10-22 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('9', '2019-09-11 10:35:00', '2019-09-11 12:10:00', '中医科研思路与方法（研）', '徐宗佩', '北C102', '2019-09-11 00:00:00', '2019-09-18 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('10', '2019-09-12 10:35:00', '2019-09-12 12:10:00', '硕士英语（研）', '张瑾', '南B101', '2019-09-12 00:00:00', '2019-11-07 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('11', '2019-09-13 10:35:00', '2019-09-13 12:10:00', '医学统计学（研）', '步怀恩', '北C102', '2019-09-13 00:00:00', '2019-11-08 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('12', '2019-11-22 08:45:00', '2019-11-22 10:20:00', '医学统计学（研）', '步怀恩', '公共计算机教室（A211）', '2019-11-22 00:00:00', '2020-01-10 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('13', '2019-11-22 10:35:00', '2019-11-22 12:10:00', '医学统计学（研）', '步怀恩', '公共计算机教室（A211）', '2019-11-22 00:00:00', '2020-01-10 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪'), ('14', '2019-09-25 18:15:00', '2019-09-25 19:50:00', '中医科研思路与方法（研）', '徐宗佩', '北C102', '2019-09-25 00:00:00', '2019-12-04 23:59:59', '0', 'oGNmS5xfeCmqTY-8EqQZ7KbmZd08', '陈英豪');
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
