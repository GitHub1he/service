/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : localhost:3306
 Source Schema         : gd

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : 65001

 Date: 28/01/2023 23:42:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_classes
-- ----------------------------
DROP TABLE IF EXISTS `t_classes`;
CREATE TABLE `t_classes`  (
  `classes_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classes_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `major_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`classes_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_college
-- ----------------------------
DROP TABLE IF EXISTS `t_college`;
CREATE TABLE `t_college`  (
  `college_id` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `college_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`college_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_graduation_qualification
-- ----------------------------
DROP TABLE IF EXISTS `t_graduation_qualification`;
CREATE TABLE `t_graduation_qualification`  (
  `studnet_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `studnet_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学名',
  `college_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院名称',
  `major_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业名称',
  `classes_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名称',
  `student_source` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生源情况',
  `total_credits` double(6, 2) NULL DEFAULT 0.00 COMMENT '总学分',
  `pub_ele_credit` double NULL DEFAULT 0 COMMENT '公共选修课学分',
  `pro_ele_credit` double(4, 2) NULL DEFAULT 0.00 COMMENT '专业选修课学分',
  `grade_point` double(4, 2) NULL DEFAULT 0.00 COMMENT '绩点',
  `chinese_qua` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '普通话证书',
  `computer_qua` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计算机证书',
  `zjg` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中级工',
  `arrears` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '欠费情况',
  `graduation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业证书',
  `graduation_qua` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业证书确认',
  `diploma` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学位证书',
  `diploma_qua` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学位证书确认',
  PRIMARY KEY (`studnet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_major
-- ----------------------------
DROP TABLE IF EXISTS `t_major`;
CREATE TABLE `t_major`  (
  `major_id` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `major_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `college_id` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`major_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `publisher` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `release_time` date NOT NULL,
  `caution_college` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `caution_major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `caution_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `caution_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_pub_ele_sprot_tea_program
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_ele_sprot_tea_program`;
CREATE TABLE `t_pub_ele_sprot_tea_program`  (
  `pestp_id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `major_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `learn_year` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `semeter` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_select` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_affiliation` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credit` double NOT NULL DEFAULT 0,
  `exam_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teach_college` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`pestp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_pub_ele_tea_program
-- ----------------------------
DROP TABLE IF EXISTS `t_pub_ele_tea_program`;
CREATE TABLE `t_pub_ele_tea_program`  (
  `petp_id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `learn_year` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `semeter` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` varchar(15) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `course_select` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程性质',
  `course_affiliation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程归属',
  `credit` double NOT NULL DEFAULT 0,
  `teach_college` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `exam_method` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`petp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_score
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score`  (
  `learn_year` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `semester` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `studnet_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_code` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `daily_score` double NULL DEFAULT 0,
  `last_score` double NOT NULL DEFAULT 0,
  `score` double NOT NULL DEFAULT 0,
  `notes` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit` double NOT NULL DEFAULT 0,
  `grade_point` double NOT NULL DEFAULT 0,
  `rebuild` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '重修预警',
  `cousre_select` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程选择'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_secondary_worker
-- ----------------------------
DROP TABLE IF EXISTS `t_secondary_worker`;
CREATE TABLE `t_secondary_worker`  (
  `student_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cert_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cert_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `get_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0000-00-00',
  `issuing_authority` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_stay_student
-- ----------------------------
DROP TABLE IF EXISTS `t_stay_student`;
CREATE TABLE `t_stay_student`  (
  `student_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `student_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `college_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `major_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `classes_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `failing_credit` double NULL DEFAULT NULL,
  `stay_condition` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `college_qua` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `education_office` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `studnet_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `student_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `student_sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `major_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `classes_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `year` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`studnet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_teaching_program
-- ----------------------------
DROP TABLE IF EXISTS `t_teaching_program`;
CREATE TABLE `t_teaching_program`  (
  `tp_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教学计划主键id',
  `major_id` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业代码',
  `major_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业名称',
  `learn_year` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学年',
  `semeter` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学期',
  `course_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `course_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程代码',
  `course_select` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程选择',
  `credit` double NOT NULL DEFAULT 0 COMMENT '学分',
  `exam_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考核方式',
  `teach_college` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开课学院'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_teaching_program_major_credit
-- ----------------------------
DROP TABLE IF EXISTS `t_teaching_program_major_credit`;
CREATE TABLE `t_teaching_program_major_credit`  (
  `tpm_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教学计划号 年级+专业代码',
  `major_id` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业',
  `grade` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年级',
  `sum_credit` double NOT NULL DEFAULT 0 COMMENT '总学分',
  `pub_ele_credit` double NOT NULL DEFAULT 0 COMMENT '公共选修课',
  `pub_gen_credit` double NOT NULL DEFAULT 0 COMMENT '公共通修课',
  `pro_bas_credit` double NOT NULL DEFAULT 0 COMMENT '专业基础课',
  `pro_core_credit` double NOT NULL DEFAULT 0 COMMENT '专业核心课',
  `pro_ele_credit` double NOT NULL DEFAULT 0 COMMENT '专业任选课',
  `pro_lim_credit` double NOT NULL DEFAULT 0 COMMENT '专业限选课',
  `pra_teaching_credit` double NOT NULL DEFAULT 0 COMMENT '实践教学环节',
  PRIMARY KEY (`tpm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_role` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户角色',
  `college_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `major_code` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `year` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_xfjg
-- ----------------------------
DROP TABLE IF EXISTS `t_xfjg`;
CREATE TABLE `t_xfjg`  (
  `jxjhh` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `zydm` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zymc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nj` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `ggxxkxf` double(4, 1) NOT NULL DEFAULT 0.0,
  `ggtxkxf` double(4, 1) NOT NULL DEFAULT 0.0,
  `zyjckxf` double(4, 1) NOT NULL DEFAULT 0.0,
  `zyhxkxf` double(4, 1) NULL DEFAULT NULL,
  `zyrxkxf` double(4, 1) NULL DEFAULT NULL,
  `zyxxkxf` double(4, 1) NULL DEFAULT NULL,
  `sjjxxf` double(4, 1) NULL DEFAULT NULL,
  PRIMARY KEY (`jxjhh`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
