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

 Date: 28/09/2020 00:00:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_tasks_task
-- ----------------------------
DROP TABLE IF EXISTS `t_tasks_task`;
CREATE TABLE `t_tasks_task` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `process_list` varchar(2000) DEFAULT NULL COMMENT '程序队列',
  `type` varchar(2) DEFAULT NULL COMMENT '类型：1-即时任务 2-周期任务 3-定时任务',
  `status` varchar(2) DEFAULT NULL COMMENT '状态',
  `param` varchar(500) DEFAULT NULL COMMENT '参数',
  `info` varchar(255) DEFAULT NULL COMMENT '简介',
  `current_task_order` int(3) DEFAULT NULL COMMENT '当前任务标号',
  `end_time` datetime DEFAULT NULL COMMENT '任务结束时间',
  `start_time` datetime DEFAULT NULL COMMENT '任务开始时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `run_version` varchar(64) DEFAULT NULL COMMENT '运行版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_tasks_task
-- ----------------------------
BEGIN;
INSERT INTO `t_tasks_task` VALUES ('D9DB110EDCD64AB78377B77BE961173F', '测试任务2', '[{\"order\":0,\"status\":\"2\",\"runId\":\"ABBD7426563D4BE3AB0DD19A6744C360\",\"id\":\"C0B6FDC3FF5811EAB8BB0242AC110002\",\"name\":\"程序2\",\"processName\":\"process_2\",\"info\":\"程序2介绍信息\",\"createTime\":\"Sep 26, 2020 1:58:44 AM\",\"updateTime\":\"Sep 26, 2020 1:58:44 AM\"},{\"order\":1,\"status\":\"2\",\"runId\":\"8BE03D70DAE74ECBBC962B5083B60FFD\",\"id\":\"D669DFFEFF5211EAB8BB0242AC110002\",\"name\":\"程序1\",\"processName\":\"process_1\",\"info\":\"程序1介绍\",\"createTime\":\"Sep 26, 2020 1:16:23 AM\",\"updateTime\":\"Sep 26, 2020 1:16:23 AM\"},{\"order\":2,\"status\":\"1\",\"runId\":\"4E813A281A5246E585B725CBBEC682A8\",\"afterFail\":\"3\",\"id\":\"DC673107FF5811EAB8BB0242AC110002\",\"name\":\"程序3\",\"processName\":\"process_3\",\"info\":\"程序3介绍信息\",\"createTime\":\"Sep 26, 2020 1:59:30 AM\",\"updateTime\":\"Sep 26, 2020 1:59:30 AM\"}]', '1', '1', NULL, '测试任务简介', 2, '2020-09-26 08:14:20', '2020-09-26 08:16:44', '2020-09-25 19:59:33', '2020-09-26 08:47:40', 'v.20200926161643');
INSERT INTO `t_tasks_task` VALUES ('E6E2F52497E242F7A2F2802F1885514C', '测试任务3', '[{\"order\":0,\"status\":\"2\",\"runId\":\"1E032F91C459425AB4476C54A5B145DC\",\"id\":\"C0B6FDC3FF5811EAB8BB0242AC110002\",\"name\":\"程序2\",\"processName\":\"process_2\",\"info\":\"程序2介绍信息\",\"createTime\":\"Sep 26, 2020 1:58:44 AM\",\"updateTime\":\"Sep 26, 2020 1:58:44 AM\"},{\"order\":1,\"status\":\"1\",\"runId\":\"1098515A7D7F495CB6F6C91F471B56C9\",\"id\":\"DC673107FF5811EAB8BB0242AC110002\",\"name\":\"程序3\",\"processName\":\"process_3\",\"info\":\"程序3介绍信息\",\"createTime\":\"Sep 26, 2020 1:59:30 AM\",\"updateTime\":\"Sep 26, 2020 1:59:30 AM\"},{\"order\":2,\"status\":\"0\",\"id\":\"D669DFFEFF5211EAB8BB0242AC110002\",\"name\":\"程序1\",\"processName\":\"process_1\",\"info\":\"程序1介绍\",\"createTime\":\"Sep 26, 2020 1:16:23 AM\",\"updateTime\":\"Sep 26, 2020 1:16:23 AM\"},{\"order\":3,\"status\":\"0\",\"id\":\"DC673107FF5811EAB8BB0242AC110002\",\"name\":\"程序3\",\"processName\":\"process_3\",\"info\":\"程序3介绍信息\",\"createTime\":\"Sep 26, 2020 1:59:30 AM\",\"updateTime\":\"Sep 26, 2020 1:59:30 AM\"},{\"order\":4,\"status\":\"0\",\"id\":\"C0B6FDC3FF5811EAB8BB0242AC110002\",\"name\":\"程序2\",\"processName\":\"process_2\",\"info\":\"程序2介绍信息\",\"createTime\":\"Sep 26, 2020 1:58:44 AM\",\"updateTime\":\"Sep 26, 2020 1:58:44 AM\"}]', '1', '1', NULL, 'info', 1, NULL, '2020-09-26 08:43:19', '2020-09-26 08:42:54', '2020-09-26 08:47:40', 'v.20200926164319');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
