/*
 Navicat Premium Data Transfer

 Source Server         : docker-13306
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 127.0.0.1:13306
 Source Schema         : je

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 28/09/2020 00:00:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_tasks_process_info
-- ----------------------------
DROP TABLE IF EXISTS `t_tasks_process_info`;
CREATE TABLE `t_tasks_process_info` (
  `id` varchar(64) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `process_name` varchar(255) DEFAULT NULL,
  `param` varchar(500) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_tasks_process_info
-- ----------------------------
BEGIN;
INSERT INTO `t_tasks_process_info` VALUES ('C0B6FDC3FF5811EAB8BB0242AC110002', '程序2', 'process_2', NULL, '程序2介绍信息', '2020-09-25 17:58:44', '2020-09-25 17:58:44');
INSERT INTO `t_tasks_process_info` VALUES ('D669DFFEFF5211EAB8BB0242AC110002', '程序1', 'process_1', NULL, '程序1介绍', '2020-09-25 17:16:23', '2020-09-25 17:16:23');
INSERT INTO `t_tasks_process_info` VALUES ('DC673107FF5811EAB8BB0242AC110002', '程序3', 'process_3', NULL, '程序3介绍信息', '2020-09-25 17:59:30', '2020-09-25 17:59:30');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
