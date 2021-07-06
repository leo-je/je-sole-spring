/*
 Navicat Premium Data Transfer

 Source Server         : localhost_docker_13306
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:13306
 Source Schema         : je

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 25/09/2020 21:33:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_task_info
-- ----------------------------
DROP TABLE IF EXISTS `t_task_info`;
CREATE TABLE `t_task_info` (
  `id` varchar(64) NOT NULL,
  `job_name` varchar(255) DEFAULT NULL COMMENT '任务名',
  `description` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `cron_expression` varchar(255) DEFAULT NULL COMMENT 'cron表达式',
  `bean_class` varchar(255) DEFAULT NULL COMMENT '任务执行时调用哪个类的方法 包名+类名',
  `job_status` varchar(255) DEFAULT NULL COMMENT '任务状态',
  `job_group` varchar(255) DEFAULT NULL COMMENT '任务分组',
  `create_user` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_info
-- ----------------------------
BEGIN;
INSERT INTO `t_task_info` VALUES ('27', 'helloword', '跑批配置测试', '0/10 * * * * ?', 'com.je.cloud.quartz.task.HelloWorldJob', '1', 'group', 'zhangzhuo', '2018-06-29 23:31:42', 'zhangzhuo', '2018-06-29 23:31:42');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
