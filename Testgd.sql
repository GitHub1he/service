/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : localhost:3306
 Source Schema         : testgd

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : 65001

 Date: 17/02/2023 12:15:42
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
  `year` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`classes_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_classes
-- ----------------------------
INSERT INTO `t_classes` VALUES ('07111204', '财教1204', '0715', '2012');
INSERT INTO `t_classes` VALUES ('07111205', '财教1205', '0715', '2012');
INSERT INTO `t_classes` VALUES ('07111304', '财教1304', '0711', '2013');
INSERT INTO `t_classes` VALUES ('07111305', '财教1305', '0711', '2013');
INSERT INTO `t_classes` VALUES ('07111306', '财教1306', '0715', '2013');
INSERT INTO `t_classes` VALUES ('07111307', '财教1307', '0715', '2013');
INSERT INTO `t_classes` VALUES ('07111403', '财教1403', '0711', '2014');
INSERT INTO `t_classes` VALUES ('07111404', '财教1404', '0711', '2014');
INSERT INTO `t_classes` VALUES ('07111503', '财教1503', '0711', '2015');
INSERT INTO `t_classes` VALUES ('07111504', '财教1504', '0711', '2015');
INSERT INTO `t_classes` VALUES ('07111603', '财教1603', '0711', '2016');
INSERT INTO `t_classes` VALUES ('07111604', '财教1604', '0711', '2016');
INSERT INTO `t_classes` VALUES ('07111703', '财教1703', '0711', '2017');
INSERT INTO `t_classes` VALUES ('07111704', '财教1704', '0711', '2017');
INSERT INTO `t_classes` VALUES ('07111705', '财教1705', '0711', '2017');
INSERT INTO `t_classes` VALUES ('07111803', '财教1803', '0711', '2018');
INSERT INTO `t_classes` VALUES ('07111804', '财教1804', '0711', '2018');
INSERT INTO `t_classes` VALUES ('07131201', '国贸1201', '0713', '2012');
INSERT INTO `t_classes` VALUES ('07131202', '国贸1202', '0713', '2012');
INSERT INTO `t_classes` VALUES ('07131203', '国贸1203', '0713', '2012');
INSERT INTO `t_classes` VALUES ('07131204', '国贸1204', '0716', '2012');
INSERT INTO `t_classes` VALUES ('07131205', '国贸1205', '0716', '2012');
INSERT INTO `t_classes` VALUES ('07131301', '国贸1301', '0713', '2013');
INSERT INTO `t_classes` VALUES ('07131302', '国贸1302', '0713', '2013');
INSERT INTO `t_classes` VALUES ('07131303', '国贸1303(金融)', '0717', '2013');
INSERT INTO `t_classes` VALUES ('07131304', '国贸1304(金融)', '0717', '2013');
INSERT INTO `t_classes` VALUES ('07131401', '国贸1401', '0713', '2014');
INSERT INTO `t_classes` VALUES ('07131402', '国贸1402', '0713', '2014');
INSERT INTO `t_classes` VALUES ('07131403', '国贸1403(金融)', '0717', '2014');
INSERT INTO `t_classes` VALUES ('07131404', '国贸1404(金融)', '0717', '2014');
INSERT INTO `t_classes` VALUES ('07131501', '国贸1501', '0713', '2015');
INSERT INTO `t_classes` VALUES ('07131502', '国贸1502', '0713', '2015');
INSERT INTO `t_classes` VALUES ('07131503', '国贸1503(金融)', '0717', '2015');
INSERT INTO `t_classes` VALUES ('07131504', '国贸1504(金融)', '0717', '2015');
INSERT INTO `t_classes` VALUES ('07131505', '国贸1505(金融)', '0717', '2015');
INSERT INTO `t_classes` VALUES ('07131601', '国贸1601', '0713', '2016');
INSERT INTO `t_classes` VALUES ('07131602', '国贸1602', '0713', '2016');
INSERT INTO `t_classes` VALUES ('07131603', '国贸1603', '0713', '2016');
INSERT INTO `t_classes` VALUES ('07131604', '国贸1604', '0713', '2016');
INSERT INTO `t_classes` VALUES ('07131701', '国贸1701', '0713', '2017');
INSERT INTO `t_classes` VALUES ('07131702', '国贸1702', '0713', '2017');
INSERT INTO `t_classes` VALUES ('07131703', '国贸1703', '0713', '2017');
INSERT INTO `t_classes` VALUES ('07131801', '国贸1801', '0713', '2018');
INSERT INTO `t_classes` VALUES ('07131802', '国贸1802', '0713', '2018');
INSERT INTO `t_classes` VALUES ('07141201', '财管1201', '0714', '2012');
INSERT INTO `t_classes` VALUES ('07141202', '财管1202', '0714', '2012');
INSERT INTO `t_classes` VALUES ('07141203', '财管1203', '0714', '2012');
INSERT INTO `t_classes` VALUES ('07141301', '财管1301', '0714', '2013');
INSERT INTO `t_classes` VALUES ('07141302', '财管1302', '0714', '2013');
INSERT INTO `t_classes` VALUES ('07141303', '财管1303', '0714', '2013');
INSERT INTO `t_classes` VALUES ('07141401', '财管1401', '0714', '2014');
INSERT INTO `t_classes` VALUES ('07141402', '财管1402', '0714', '2014');
INSERT INTO `t_classes` VALUES ('07141403', '财管1403', '0714', '2014');
INSERT INTO `t_classes` VALUES ('07141404', '财管1404', '0714', '2014');
INSERT INTO `t_classes` VALUES ('07141501', '财管1501', '0714', '2015');
INSERT INTO `t_classes` VALUES ('07141502', '财管1502', '0714', '2015');
INSERT INTO `t_classes` VALUES ('07141503', '财管1503', '0714', '2015');
INSERT INTO `t_classes` VALUES ('07141504', '财管1504', '0714', '2015');
INSERT INTO `t_classes` VALUES ('07141601', '财管1601', '0714', '2016');
INSERT INTO `t_classes` VALUES ('07141602', '财管1602', '0714', '2016');
INSERT INTO `t_classes` VALUES ('07141603', '财管1603', '0714', '2016');
INSERT INTO `t_classes` VALUES ('07141604', '财管1604', '0714', '2016');
INSERT INTO `t_classes` VALUES ('07141605', '财管1605', '0714', '2016');
INSERT INTO `t_classes` VALUES ('07141701', '财管1701', '0714', '2017');
INSERT INTO `t_classes` VALUES ('07141702', '财管1702', '0714', '2017');
INSERT INTO `t_classes` VALUES ('07141703', '财管1703', '0714', '2017');
INSERT INTO `t_classes` VALUES ('07141704', '财管1704', '0714', '2017');
INSERT INTO `t_classes` VALUES ('07141801', '财管1801', '0714', '2018');
INSERT INTO `t_classes` VALUES ('07141802', '财管1802', '0714', '2018');
INSERT INTO `t_classes` VALUES ('07141803', '财管1803', '0714', '2018');
INSERT INTO `t_classes` VALUES ('07181701', '农村区域发展1701', '0718', '2017');
INSERT INTO `t_classes` VALUES ('07181702', '农村区域发展1702', '0718', '2017');
INSERT INTO `t_classes` VALUES ('07181801', '农村区域发展1801', '0718', '2018');
INSERT INTO `t_classes` VALUES ('07181802', '农村区域发展1802', '0718', '2018');
INSERT INTO `t_classes` VALUES ('07191801', '电子商务1801', '0719', '2018');
INSERT INTO `t_classes` VALUES ('07191802', '电子商务1802', '0719', '2018');
INSERT INTO `t_classes` VALUES ('07271301', '保险专1301', '0727', '2013');
INSERT INTO `t_classes` VALUES ('07291301', '电子商务专1301', '0729', '2013');
INSERT INTO `t_classes` VALUES ('07291302', '电子商务专1302', '0729', '2013');
INSERT INTO `t_classes` VALUES ('07291401', '电子商务专1401', '0729', '2014');
INSERT INTO `t_classes` VALUES ('07291402', '电子商务专1402', '0729', '2014');
INSERT INTO `t_classes` VALUES ('07291403', '电子商务专1403', '0729', '2014');
INSERT INTO `t_classes` VALUES ('07291404', '电子商务专1404', '0729', '2014');
INSERT INTO `t_classes` VALUES ('07291501', '电子商务专1501', '0729', '2015');
INSERT INTO `t_classes` VALUES ('07291502', '电子商务专1502', '0729', '2015');
INSERT INTO `t_classes` VALUES ('07291503', '电子商务专1503', '0729', '2015');
INSERT INTO `t_classes` VALUES ('07291601', '电子商务专1601', '0729', '2016');
INSERT INTO `t_classes` VALUES ('07291602', '电子商务专1602', '0729', '2016');
INSERT INTO `t_classes` VALUES ('07291603', '电子商务专1603', '0729', '2016');
INSERT INTO `t_classes` VALUES ('07291701', '电子商务专1701', '0729', '2017');
INSERT INTO `t_classes` VALUES ('07291702', '电子商务专1702', '0729', '2017');
INSERT INTO `t_classes` VALUES ('07611201', '财教1201', '0761', '2012');
INSERT INTO `t_classes` VALUES ('07611202', '财教1202', '0761', '2012');
INSERT INTO `t_classes` VALUES ('07611203', '财教1203', '0761', '2012');
INSERT INTO `t_classes` VALUES ('07611301', '财教1301(对口)', '0761', '2013');
INSERT INTO `t_classes` VALUES ('07611302', '财教1302(对口)', '0761', '2013');
INSERT INTO `t_classes` VALUES ('07611303', '财教1303(对口)', '0761', '2013');
INSERT INTO `t_classes` VALUES ('07611401', '财教1401(对口)', '0761', '2014');
INSERT INTO `t_classes` VALUES ('07611402', '财教1402(对口)', '0761', '2014');
INSERT INTO `t_classes` VALUES ('07611501', '财教1501(对口)', '0761', '2015');
INSERT INTO `t_classes` VALUES ('07611502', '财教1502(对口)', '0761', '2015');
INSERT INTO `t_classes` VALUES ('07611601', '财教1601(对口)', '0761', '2016');
INSERT INTO `t_classes` VALUES ('07611602', '财教1602(对口)', '0761', '2016');
INSERT INTO `t_classes` VALUES ('07611701', '财教1701(对口)', '0761', '2017');
INSERT INTO `t_classes` VALUES ('07611702', '财教1702(对口)', '0761', '2017');
INSERT INTO `t_classes` VALUES ('07611801', '财教1801(对口)', '0761', '2018');
INSERT INTO `t_classes` VALUES ('07611802', '财教1802(对口)', '0761', '2018');
INSERT INTO `t_classes` VALUES ('07621401', '保险1401(对口)', '0762', '2014');
INSERT INTO `t_classes` VALUES ('07621402', '保险1402(对口)', '0762', '2014');
INSERT INTO `t_classes` VALUES ('07621501', '保险1501(对口)', '0762', '2015');
INSERT INTO `t_classes` VALUES ('07621502', '保险1502(对口)', '0762', '2015');
INSERT INTO `t_classes` VALUES ('07621601', '保险1601(对口)', '0762', '2016');
INSERT INTO `t_classes` VALUES ('07621602', '保险1602(对口)', '0762', '2016');
INSERT INTO `t_classes` VALUES ('07621603', '保险1603(对口)', '0762', '2016');
INSERT INTO `t_classes` VALUES ('07621701', '保险1701(对口)', '0762', '2017');
INSERT INTO `t_classes` VALUES ('07621702', '保险1702(对口)', '0762', '2017');
INSERT INTO `t_classes` VALUES ('07621703', '保险1703(对口)', '0762', '2017');
INSERT INTO `t_classes` VALUES ('07621801', '保险1801(对口)', '0762', '2018');
INSERT INTO `t_classes` VALUES ('07621802', '保险1802(对口)', '0762', '2018');
INSERT INTO `t_classes` VALUES ('07621803', '保险1803(对口)', '0762', '2018');
INSERT INTO `t_classes` VALUES ('09111204', '计算机1204', '0911', '2012');
INSERT INTO `t_classes` VALUES ('09111205', '计算机1205', '0911', '2012');
INSERT INTO `t_classes` VALUES ('09111305', '计算机1305', '0911', '2013');
INSERT INTO `t_classes` VALUES ('09111306', '计算机1306', '0911', '2013');
INSERT INTO `t_classes` VALUES ('09111307', '计算机1307', '0911', '2013');
INSERT INTO `t_classes` VALUES ('09111405', '计算机1405', '0911', '2014');
INSERT INTO `t_classes` VALUES ('09111406', '计算机1406', '0911', '2014');
INSERT INTO `t_classes` VALUES ('09111505', '计算机1505', '0911', '2015');
INSERT INTO `t_classes` VALUES ('09111506', '计算机1506', '0911', '2015');
INSERT INTO `t_classes` VALUES ('09111605', '计算机1605', '0911', '2016');
INSERT INTO `t_classes` VALUES ('09111606', '计算机1606', '0911', '2016');
INSERT INTO `t_classes` VALUES ('09111705', '计算机1705', '0911', '2017');
INSERT INTO `t_classes` VALUES ('09111706', '计算机1706', '0911', '2017');
INSERT INTO `t_classes` VALUES ('09111803', '计算机1803', '0911', '2018');
INSERT INTO `t_classes` VALUES ('09111804', '计算机1804', '0911', '2018');
INSERT INTO `t_classes` VALUES ('09111805', '计算机1805', '0911', '2018');
INSERT INTO `t_classes` VALUES ('09111806', '计算机1806', '0911', '2018');
INSERT INTO `t_classes` VALUES ('09131201', '网络1201', '0913', '2012');
INSERT INTO `t_classes` VALUES ('09131202', '网络1202', '0913', '2012');
INSERT INTO `t_classes` VALUES ('09131203', '网络1203', '0913', '2012');
INSERT INTO `t_classes` VALUES ('09131301', '网络1301', '0913', '2013');
INSERT INTO `t_classes` VALUES ('09131302', '网络1302', '0913', '2013');
INSERT INTO `t_classes` VALUES ('09131303', '网络1303', '0913', '2013');
INSERT INTO `t_classes` VALUES ('09131304', '网络1304', '0913', '2013');
INSERT INTO `t_classes` VALUES ('09131401', '网络1401', '0913', '2014');
INSERT INTO `t_classes` VALUES ('09131402', '网络1402', '0913', '2014');
INSERT INTO `t_classes` VALUES ('09131403', '网络1403', '0913', '2014');
INSERT INTO `t_classes` VALUES ('09131404', '网络1404', '0913', '2014');
INSERT INTO `t_classes` VALUES ('09131501', '网络1501', '0913', '2015');
INSERT INTO `t_classes` VALUES ('09131502', '网络1502', '0913', '2015');
INSERT INTO `t_classes` VALUES ('09131503', '网络1503', '0913', '2015');
INSERT INTO `t_classes` VALUES ('09131504', '网络1504', '0913', '2015');
INSERT INTO `t_classes` VALUES ('09131603', '网络1603', '0913', '2016');
INSERT INTO `t_classes` VALUES ('09131604', '网络1604', '0913', '2016');
INSERT INTO `t_classes` VALUES ('09131703', '网络1703', '0913', '2017');
INSERT INTO `t_classes` VALUES ('09131704', '网络1704', '0913', '2017');
INSERT INTO `t_classes` VALUES ('09131804', '网络1804', '0913', '2018');
INSERT INTO `t_classes` VALUES ('09131805', '网络1805', '0913', '2018');
INSERT INTO `t_classes` VALUES ('09141401', '物联网1401', '0914', '2014');
INSERT INTO `t_classes` VALUES ('09141402', '物联网1402', '0914', '2014');
INSERT INTO `t_classes` VALUES ('09141501', '物联网1501', '0914', '2015');
INSERT INTO `t_classes` VALUES ('09141502', '物联网1502', '0914', '2015');
INSERT INTO `t_classes` VALUES ('09141601', '物联网1601', '0914', '2016');
INSERT INTO `t_classes` VALUES ('09141602', '物联网1602', '0914', '2016');
INSERT INTO `t_classes` VALUES ('09141701', '物联网1701', '0914', '2017');
INSERT INTO `t_classes` VALUES ('09141702', '物联网1702', '0914', '2017');
INSERT INTO `t_classes` VALUES ('09141801', '物联网1801', '0914', '2018');
INSERT INTO `t_classes` VALUES ('09141802', '物联网1802', '0914', '2018');
INSERT INTO `t_classes` VALUES ('09151601', '应用统计1601', '0915', '2016');
INSERT INTO `t_classes` VALUES ('09151602', '应用统计1602', '0915', '2016');
INSERT INTO `t_classes` VALUES ('09151701', '应用统计1701', '0915', '2017');
INSERT INTO `t_classes` VALUES ('09151702', '应用统计1702', '0915', '2017');
INSERT INTO `t_classes` VALUES ('09151801', '应用统计1801', '0915', '2018');
INSERT INTO `t_classes` VALUES ('09151802', '应用统计1802', '0915', '2018');
INSERT INTO `t_classes` VALUES ('09161701', '数字媒体1701', '0916', '2017');
INSERT INTO `t_classes` VALUES ('09161702', '数字媒体1702', '0916', '2017');
INSERT INTO `t_classes` VALUES ('09161801', '数字媒体1801', '0916', '2018');
INSERT INTO `t_classes` VALUES ('09161802', '数字媒体1802', '0916', '2018');
INSERT INTO `t_classes` VALUES ('09221301', '网络专1301', '0922', '2013');
INSERT INTO `t_classes` VALUES ('09221401', '网络专1401', '0922', '2014');
INSERT INTO `t_classes` VALUES ('09221402', '网络专1402', '0922', '2014');
INSERT INTO `t_classes` VALUES ('09231301', '计算机专1301', '0923', '2013');
INSERT INTO `t_classes` VALUES ('09231401', '计算机专1401', '0923', '2014');
INSERT INTO `t_classes` VALUES ('09231402', '计算机专1402', '0923', '2014');
INSERT INTO `t_classes` VALUES ('09231501', '计算机专1501', '0923', '2015');
INSERT INTO `t_classes` VALUES ('09231502', '计算机专1502', '0923', '2015');
INSERT INTO `t_classes` VALUES ('09231601', '计算机专1601', '0923', '2016');
INSERT INTO `t_classes` VALUES ('09231602', '计算机专1602', '0923', '2016');
INSERT INTO `t_classes` VALUES ('09241301', '图形图像制作专1301', '0924', '2013');
INSERT INTO `t_classes` VALUES ('09241302', '图形图像制作专1302', '0924', '2013');
INSERT INTO `t_classes` VALUES ('09241401', '图形图像制作专1401', '0924', '2014');
INSERT INTO `t_classes` VALUES ('09241402', '图形图像制作专1402', '0924', '2014');
INSERT INTO `t_classes` VALUES ('09241501', '图形图像制作专1501', '0924', '2015');
INSERT INTO `t_classes` VALUES ('09241502', '图形图像制作专1502', '0924', '2015');
INSERT INTO `t_classes` VALUES ('09251301', '物联网专1301', '0925', '2013');
INSERT INTO `t_classes` VALUES ('09251302', '物联网专1302', '0925', '2013');
INSERT INTO `t_classes` VALUES ('09251401', '物联网专1401', '0925', '2014');
INSERT INTO `t_classes` VALUES ('09251402', '物联网专1402', '0925', '2014');
INSERT INTO `t_classes` VALUES ('09251501', '物联网专1501', '0925', '2015');
INSERT INTO `t_classes` VALUES ('09251502', '物联网专1502', '0925', '2015');
INSERT INTO `t_classes` VALUES ('09261601', '数字媒体专1601', '0926', '2016');
INSERT INTO `t_classes` VALUES ('09261602', '数字媒体专1602', '0926', '2016');
INSERT INTO `t_classes` VALUES ('09511607', '计算机接本1607', '0951', '2016');
INSERT INTO `t_classes` VALUES ('09511707', '计算机接本1707', '0951', '2017');
INSERT INTO `t_classes` VALUES ('09611201', '计算机1201', '0961', '2012');
INSERT INTO `t_classes` VALUES ('09611202', '计算机1202', '0961', '2012');
INSERT INTO `t_classes` VALUES ('09611203', '计算机1203', '0961', '2012');
INSERT INTO `t_classes` VALUES ('09611301', '计算机1301(对口)', '0961', '2013');
INSERT INTO `t_classes` VALUES ('09611302', '计算机1302(对口)', '0961', '2013');
INSERT INTO `t_classes` VALUES ('09611303', '计算机1303(对口)', '0961', '2013');
INSERT INTO `t_classes` VALUES ('09611304', '计算机1304(对口)', '0961', '2013');
INSERT INTO `t_classes` VALUES ('09611401', '计算机1401(对口)', '0961', '2014');
INSERT INTO `t_classes` VALUES ('09611402', '计算机1402(对口)', '0961', '2014');
INSERT INTO `t_classes` VALUES ('09611403', '计算机1403(对口)', '0961', '2014');
INSERT INTO `t_classes` VALUES ('09611404', '计算机1404(对口)', '0961', '2014');
INSERT INTO `t_classes` VALUES ('09611501', '计算机1501(对口)', '0961', '2015');
INSERT INTO `t_classes` VALUES ('09611502', '计算机1502(对口)', '0961', '2015');
INSERT INTO `t_classes` VALUES ('09611503', '计算机1503(对口)', '0961', '2015');
INSERT INTO `t_classes` VALUES ('09611504', '计算机1504(对口)', '0961', '2015');
INSERT INTO `t_classes` VALUES ('09611601', '计算机1601(对口)', '0961', '2016');
INSERT INTO `t_classes` VALUES ('09611602', '计算机1602(对口)', '0961', '2016');
INSERT INTO `t_classes` VALUES ('09611603', '计算机1603(对口)', '0961', '2016');
INSERT INTO `t_classes` VALUES ('09611604', '计算机1604(对口)', '0961', '2016');
INSERT INTO `t_classes` VALUES ('09611701', '计算机1701(对口)', '0961', '2017');
INSERT INTO `t_classes` VALUES ('09611702', '计算机1702(对口)', '0961', '2017');
INSERT INTO `t_classes` VALUES ('09611703', '计算机1703(对口)', '0961', '2017');
INSERT INTO `t_classes` VALUES ('09611704', '计算机1704(对口)', '0961', '2017');
INSERT INTO `t_classes` VALUES ('09611801', '计算机1801(对口)', '0961', '2018');
INSERT INTO `t_classes` VALUES ('09611802', '计算机1802(对口)', '0961', '2018');
INSERT INTO `t_classes` VALUES ('09611901', '计算机1901(对口)', '0961', '2019');
INSERT INTO `t_classes` VALUES ('09611902', '计算机1902(对口)', '0961', '2019');
INSERT INTO `t_classes` VALUES ('09611903', '计算机1903(对口)', '0961', '2019');
INSERT INTO `t_classes` VALUES ('09631601', '网络1601(对口)', '0963', '2016');
INSERT INTO `t_classes` VALUES ('09631602', '网络1602(对口)', '0963', '2016');
INSERT INTO `t_classes` VALUES ('09631701', '网络1701(对口)', '0963', '2017');
INSERT INTO `t_classes` VALUES ('09631702', '网络1702(对口)', '0963', '2017');
INSERT INTO `t_classes` VALUES ('09631801', '网络1801(对口)', '0963', '2018');
INSERT INTO `t_classes` VALUES ('09631802', '网络1802(对口)', '0963', '2018');
INSERT INTO `t_classes` VALUES ('09631803', '网络1803(对口)', '0963', '2018');

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
-- Records of t_college
-- ----------------------------
INSERT INTO `t_college` VALUES ('01', '农学与生物科技学院');
INSERT INTO `t_college` VALUES ('02', '园艺科技学院');
INSERT INTO `t_college` VALUES ('03', '动物科技学院');
INSERT INTO `t_college` VALUES ('04', '机电工程学院');
INSERT INTO `t_college` VALUES ('05', '城市建设学院');
INSERT INTO `t_college` VALUES ('06', '食品科技学院暨葡萄酒学院');
INSERT INTO `t_college` VALUES ('07', '财经学院');
INSERT INTO `t_college` VALUES ('08', '工商管理学院');
INSERT INTO `t_college` VALUES ('09', '数学与信息科技学院');
INSERT INTO `t_college` VALUES ('10', '化学工程学院');
INSERT INTO `t_college` VALUES ('11', '物理系');
INSERT INTO `t_college` VALUES ('12', '文法学院');
INSERT INTO `t_college` VALUES ('13', '外国语学院');
INSERT INTO `t_college` VALUES ('14', '体育系');
INSERT INTO `t_college` VALUES ('15', '思想政治理论教学部');
INSERT INTO `t_college` VALUES ('16', '教务处');
INSERT INTO `t_college` VALUES ('17', '其他非教学部门');
INSERT INTO `t_college` VALUES ('18', '艺术学院');
INSERT INTO `t_college` VALUES ('19', '教育学院');
INSERT INTO `t_college` VALUES ('99', '其它');

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
-- Records of t_major
-- ----------------------------
INSERT INTO `t_major` VALUES ('0110', '植物生产类', '01');
INSERT INTO `t_major` VALUES ('0111', '农学', '01');
INSERT INTO `t_major` VALUES ('0112', '植物保护', '01');
INSERT INTO `t_major` VALUES ('0113', '植物科学与技术', '01');
INSERT INTO `t_major` VALUES ('0114', '农业资源与环境', '01');
INSERT INTO `t_major` VALUES ('0160', '植物生产类[对口]', '01');
INSERT INTO `t_major` VALUES ('0161', '农学[对口]', '01');
INSERT INTO `t_major` VALUES ('0162', '植物保护[对口]', '01');
INSERT INTO `t_major` VALUES ('0163', '植物科学与技术[对口]', '01');
INSERT INTO `t_major` VALUES ('0211', '园艺', '02');
INSERT INTO `t_major` VALUES ('0212', '园林', '02');
INSERT INTO `t_major` VALUES ('0214', '设施农业科学与工程', '02');
INSERT INTO `t_major` VALUES ('0215', '风景园林', '02');
INSERT INTO `t_major` VALUES ('0222', '园艺技术', '02');
INSERT INTO `t_major` VALUES ('0224', '园林技术', '02');
INSERT INTO `t_major` VALUES ('0251', '园艺[接本]', '02');
INSERT INTO `t_major` VALUES ('0252', '园林[接本]', '02');
INSERT INTO `t_major` VALUES ('0261', '园艺[对口]', '02');
INSERT INTO `t_major` VALUES ('0263', '设施农业科学与工程[对口]', '02');
INSERT INTO `t_major` VALUES ('0311', '动物科学', '03');
INSERT INTO `t_major` VALUES ('0312', '动物医学', '03');
INSERT INTO `t_major` VALUES ('0313', '水产养殖教育', '03');
INSERT INTO `t_major` VALUES ('0314', '水产养殖学', '03');
INSERT INTO `t_major` VALUES ('0321', '畜牧兽医', '03');
INSERT INTO `t_major` VALUES ('0352', '动物医学[接本]', '03');
INSERT INTO `t_major` VALUES ('0361', '动物科学[对口]', '03');
INSERT INTO `t_major` VALUES ('0362', '动物医学[对口]', '03');
INSERT INTO `t_major` VALUES ('0363', '水产养殖学[对口]', '03');
INSERT INTO `t_major` VALUES ('0411', '农业机械化及其自动化', '04');
INSERT INTO `t_major` VALUES ('0412', '机械设计制造及其自动化', '04');
INSERT INTO `t_major` VALUES ('0413', '电气工程及其自动化', '04');
INSERT INTO `t_major` VALUES ('0414', '电子信息工程', '04');
INSERT INTO `t_major` VALUES ('0415', '自动化', '04');
INSERT INTO `t_major` VALUES ('0421', '应用电子技术', '04');
INSERT INTO `t_major` VALUES ('0425', '机械设计与制造', '04');
INSERT INTO `t_major` VALUES ('0426', '电气自动化技术', '04');
INSERT INTO `t_major` VALUES ('0427', '汽车检测与维修技术', '04');
INSERT INTO `t_major` VALUES ('0452', '机械设计制造及其自动化[接本]', '04');
INSERT INTO `t_major` VALUES ('0453', '电气工程及其自动化[接本]', '04');
INSERT INTO `t_major` VALUES ('0511', '土木工程', '05');
INSERT INTO `t_major` VALUES ('0512', '工程管理', '05');
INSERT INTO `t_major` VALUES ('0513', '城市规划', '05');
INSERT INTO `t_major` VALUES ('0514', '城乡规划', '05');
INSERT INTO `t_major` VALUES ('0515', '土木工程[试点]', '05');
INSERT INTO `t_major` VALUES ('0516', '工程造价', '05');
INSERT INTO `t_major` VALUES ('0524', '建筑装饰工程技术', '05');
INSERT INTO `t_major` VALUES ('0525', '工程造价[专科]', '05');
INSERT INTO `t_major` VALUES ('0526', '建筑工程管理', '05');
INSERT INTO `t_major` VALUES ('0527', '建设工程管理', '05');
INSERT INTO `t_major` VALUES ('0551', '土木工程[接本]', '05');
INSERT INTO `t_major` VALUES ('0552', '工程管理[接本]', '05');
INSERT INTO `t_major` VALUES ('0611', '食品科学与工程', '06');
INSERT INTO `t_major` VALUES ('0612', '食品质量与安全', '06');
INSERT INTO `t_major` VALUES ('0613', '酿酒工程', '06');
INSERT INTO `t_major` VALUES ('0614', '生物工程', '06');
INSERT INTO `t_major` VALUES ('0615', '海洋资源开发技术', '06');
INSERT INTO `t_major` VALUES ('0651', '食品科学与工程[接本]', '06');
INSERT INTO `t_major` VALUES ('0711', '财务会计教育', '07');
INSERT INTO `t_major` VALUES ('0713', '国际经济与贸易', '07');
INSERT INTO `t_major` VALUES ('0714', '财务管理', '07');
INSERT INTO `t_major` VALUES ('0715', '财务会计教育[审计方向]', '07');
INSERT INTO `t_major` VALUES ('0716', '国际经济与贸易[贸易经济方向]', '07');
INSERT INTO `t_major` VALUES ('0717', '国际经济与贸易[国际金融方向]', '07');
INSERT INTO `t_major` VALUES ('0718', '农村区域发展', '07');
INSERT INTO `t_major` VALUES ('0719', '电子商务', '07');
INSERT INTO `t_major` VALUES ('0726', '审计实务', '07');
INSERT INTO `t_major` VALUES ('0727', '保险实务', '07');
INSERT INTO `t_major` VALUES ('0728', '会计电算化', '07');
INSERT INTO `t_major` VALUES ('0729', '电子商务[专科]', '07');
INSERT INTO `t_major` VALUES ('0751', '财务会计教育[接本]', '07');
INSERT INTO `t_major` VALUES ('0753', '国际经济与贸易[接本]', '07');
INSERT INTO `t_major` VALUES ('0761', '财务会计教育[对口]', '07');
INSERT INTO `t_major` VALUES ('0762', '保险学[对口]', '07');
INSERT INTO `t_major` VALUES ('0810', '工商管理类', '08');
INSERT INTO `t_major` VALUES ('0811', '信息管理与信息系统', '08');
INSERT INTO `t_major` VALUES ('0812', '人力资源管理', '08');
INSERT INTO `t_major` VALUES ('0813', '市场营销', '08');
INSERT INTO `t_major` VALUES ('0814', '旅游管理', '08');
INSERT INTO `t_major` VALUES ('0815', '物流管理', '08');
INSERT INTO `t_major` VALUES ('0824', '会计与统计核算', '08');
INSERT INTO `t_major` VALUES ('0826', '物流管理[专科]', '08');
INSERT INTO `t_major` VALUES ('0827', '旅游管理[专科]', '08');
INSERT INTO `t_major` VALUES ('0828', '酒店管理', '08');
INSERT INTO `t_major` VALUES ('0829', '统计与会计核算', '08');
INSERT INTO `t_major` VALUES ('0851', '信息管理与信息系统[接本]', '08');
INSERT INTO `t_major` VALUES ('0852', '人力资源管理[接本]', '08');
INSERT INTO `t_major` VALUES ('0853', '市场营销[专科]', '08');
INSERT INTO `t_major` VALUES ('0854', '旅游管理[接本]', '08');
INSERT INTO `t_major` VALUES ('0911', '计算机科学与技术', '09');
INSERT INTO `t_major` VALUES ('0913', '网络工程', '09');
INSERT INTO `t_major` VALUES ('0914', '物联网工程', '09');
INSERT INTO `t_major` VALUES ('0915', '应用统计学', '09');
INSERT INTO `t_major` VALUES ('0916', '数字媒体技术', '09');
INSERT INTO `t_major` VALUES ('0921', '计算机应用与维护', '09');
INSERT INTO `t_major` VALUES ('0922', '计算机网络技术', '09');
INSERT INTO `t_major` VALUES ('0923', '计算机应用技术', '09');
INSERT INTO `t_major` VALUES ('0924', '图形图像制作', '09');
INSERT INTO `t_major` VALUES ('0925', '物联网应用技术', '09');
INSERT INTO `t_major` VALUES ('0926', '数字媒体应用技术[图形图像制作]', '09');
INSERT INTO `t_major` VALUES ('0951', '计算机科学与技术[接本]', '09');
INSERT INTO `t_major` VALUES ('0961', '计算机科学与技术[对口]', '09');
INSERT INTO `t_major` VALUES ('0963', '网络工程[对口]', '09');
INSERT INTO `t_major` VALUES ('1011', '应用化学', '10');
INSERT INTO `t_major` VALUES ('1012', '化学', '10');
INSERT INTO `t_major` VALUES ('1013', '化学工程与工艺', '10');
INSERT INTO `t_major` VALUES ('1052', '化学[接本]', '10');
INSERT INTO `t_major` VALUES ('1111', '数学与应用数学', '11');
INSERT INTO `t_major` VALUES ('1112', '物理学', '11');
INSERT INTO `t_major` VALUES ('1113', '材料物理', '11');
INSERT INTO `t_major` VALUES ('1114', '物理学[试点]', '11');
INSERT INTO `t_major` VALUES ('1115', '微电子科学与工程', '11');
INSERT INTO `t_major` VALUES ('1211', '汉语言文学', '12');
INSERT INTO `t_major` VALUES ('1212', '对外汉语', '12');
INSERT INTO `t_major` VALUES ('1213', '汉语国际教育', '12');
INSERT INTO `t_major` VALUES ('1214', '秘书学', '12');
INSERT INTO `t_major` VALUES ('1215', '社会工作', '12');
INSERT INTO `t_major` VALUES ('1223', '文秘', '12');
INSERT INTO `t_major` VALUES ('1251', '汉语言文学[接本]', '12');
INSERT INTO `t_major` VALUES ('1311', '英语', '13');
INSERT INTO `t_major` VALUES ('1312', '意大利语', '13');
INSERT INTO `t_major` VALUES ('1313', '西班牙语', '13');
INSERT INTO `t_major` VALUES ('1320', '语言类', '13');
INSERT INTO `t_major` VALUES ('1321', '旅游英语', '13');
INSERT INTO `t_major` VALUES ('1322', '应用日语', '13');
INSERT INTO `t_major` VALUES ('1323', '商务英语', '13');
INSERT INTO `t_major` VALUES ('1324', '应用英语', '13');
INSERT INTO `t_major` VALUES ('1351', '英语[接本]', '13');
INSERT INTO `t_major` VALUES ('1411', '体育教育', '14');
INSERT INTO `t_major` VALUES ('1412', '运动康复', '14');
INSERT INTO `t_major` VALUES ('1413', '体育教育[保健方向]', '14');
INSERT INTO `t_major` VALUES ('1414', '休闲体育', '14');
INSERT INTO `t_major` VALUES ('1421', '体育保健', '14');
INSERT INTO `t_major` VALUES ('1422', '运动训练', '14');
INSERT INTO `t_major` VALUES ('1423', '体育保健与康复', '14');
INSERT INTO `t_major` VALUES ('1431', '体育教育[专科]', '14');
INSERT INTO `t_major` VALUES ('1451', '体育教育[接本]', '14');
INSERT INTO `t_major` VALUES ('1452', '运动康复[接本]', '14');
INSERT INTO `t_major` VALUES ('1453', '体育教育[保健方向]接本', '14');
INSERT INTO `t_major` VALUES ('1511', '法学', '15');
INSERT INTO `t_major` VALUES ('1522', '法律事务', '15');
INSERT INTO `t_major` VALUES ('1523', '社区管理与服务', '15');
INSERT INTO `t_major` VALUES ('1551', '法学[接本]', '15');
INSERT INTO `t_major` VALUES ('1610', '生物科学类', '16');
INSERT INTO `t_major` VALUES ('1611', '生物技术', '16');
INSERT INTO `t_major` VALUES ('1612', '生物科学', '16');
INSERT INTO `t_major` VALUES ('1811', '艺术设计', '18');
INSERT INTO `t_major` VALUES ('1812', '音乐学', '18');
INSERT INTO `t_major` VALUES ('1813', '美术学', '18');
INSERT INTO `t_major` VALUES ('1814', '视觉传达设计', '18');
INSERT INTO `t_major` VALUES ('1815', '环境设计', '18');
INSERT INTO `t_major` VALUES ('1816', '艺术设计[视觉传达]', '18');
INSERT INTO `t_major` VALUES ('1817', '艺术设计[环境艺术]', '18');
INSERT INTO `t_major` VALUES ('1818', '艺术设计[公共艺术]', '18');
INSERT INTO `t_major` VALUES ('1819', '舞蹈表演', '18');
INSERT INTO `t_major` VALUES ('1823', '动漫设计与制作', '18');
INSERT INTO `t_major` VALUES ('1824', '动漫制作技术', '18');
INSERT INTO `t_major` VALUES ('1832', '音乐教育', '18');
INSERT INTO `t_major` VALUES ('1833', '美术教育', '18');
INSERT INTO `t_major` VALUES ('1851', '艺术设计[接本]', '18');
INSERT INTO `t_major` VALUES ('1852', '音乐学[接本]', '18');
INSERT INTO `t_major` VALUES ('1853', '美术学[接本]', '18');
INSERT INTO `t_major` VALUES ('1854', '舞蹈表演[接本]', '18');
INSERT INTO `t_major` VALUES ('1910', '教育学类', '19');
INSERT INTO `t_major` VALUES ('1911', '教育技术学', '19');
INSERT INTO `t_major` VALUES ('1913', '学前教育', '19');
INSERT INTO `t_major` VALUES ('1914', '应用心理学', '19');
INSERT INTO `t_major` VALUES ('1915', '小学教育[文科方向]', '19');
INSERT INTO `t_major` VALUES ('1916', '小学教育[理科方向]', '19');
INSERT INTO `t_major` VALUES ('1917', '科学教育', '19');
INSERT INTO `t_major` VALUES ('1922', '计算机多媒体技术', '19');
INSERT INTO `t_major` VALUES ('1923', '数字媒体应用技术[多媒体技术]', '19');
INSERT INTO `t_major` VALUES ('1951', '教育技术学[接本]', '19');
INSERT INTO `t_major` VALUES ('1952', '小学教育[接本]', '19');
INSERT INTO `t_major` VALUES ('1963', '学前教育[对口]', '19');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `message_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `notice_id` int(11) NULL DEFAULT NULL,
  `student_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `publisher` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `release_time` date NULL DEFAULT NULL,
  `isAck` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `ack_time` datetime NULL DEFAULT NULL,
  `message_type` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '消息类型，0 是信息 1 是提醒',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 244 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES (1, 47, '0114120103', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (2, 47, '0114120116', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (3, 47, '0212130211', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (4, 47, '0711130510', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (5, 47, '0711130511', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (6, 47, '0711130515', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (7, 47, '0711130516', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (8, 47, '0711140429', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (9, 47, '0711140430', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (10, 47, '0713140223', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (11, 47, '0714120231', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (12, 47, '0714120232', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (13, 47, '0714130209', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (14, 47, '0714130210', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (15, 47, '0714130217', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (16, 47, '0714130218', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (17, 47, '0714130219', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (18, 47, '0714140126', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (19, 47, '0714140127', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (20, 47, '0714140132', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (21, 47, '0714140133', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (22, 47, '0714140202', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (23, 47, '0714140203', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (24, 47, '0714140208', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (25, 47, '0714140209', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (26, 47, '0714150221', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (27, 47, '0714150228', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (28, 47, '0714150230', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (29, 47, '0761120113', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (30, 47, '0761120114', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (31, 47, '0761120226', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (32, 47, '0761120227', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (33, 47, '0761130204', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (34, 47, '0761130205', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (35, 47, '0761130329', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (36, 47, '0761130330', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (37, 47, '0762150218', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (38, 47, '0814140118', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (39, 47, '0913140101', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (40, 47, '0913140102', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (41, 47, '0961180101', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (42, 47, '0961180102', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (43, 47, '1011130311', '0', '信息更新', '请尽快查看', '2023-02-10', '0', NULL, '0');
INSERT INTO `t_message` VALUES (44, 48, '0114120103', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (45, 48, '0114120116', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (46, 48, '0212130211', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (47, 48, '0711130510', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (48, 48, '0711130511', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (49, 48, '0711130515', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (50, 48, '0711130516', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (51, 48, '0711140429', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (52, 48, '0711140430', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (53, 48, '0713140223', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (54, 48, '0714120231', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (55, 48, '0714120232', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (56, 48, '0714130209', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (57, 48, '0714130210', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (58, 48, '0714130217', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (59, 48, '0714130218', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (60, 48, '0714130219', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (61, 48, '0714140126', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (62, 48, '0714140127', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (63, 48, '0714140132', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (64, 48, '0714140133', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (65, 48, '0714140202', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (66, 48, '0714140203', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (67, 48, '0714140208', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (68, 48, '0714140209', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (69, 48, '0714150221', '0', '更新no', '农公司给', '2023-02-10', '1', '2023-02-14 15:00:31', '0');
INSERT INTO `t_message` VALUES (70, 48, '0714150228', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (71, 48, '0714150230', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (72, 48, '0761120113', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (73, 48, '0761120114', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (74, 48, '0761120226', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (75, 48, '0761120227', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (76, 48, '0761130204', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (77, 48, '0761130205', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (78, 48, '0761130329', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (79, 48, '0761130330', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (80, 48, '0762150218', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (81, 48, '0814140118', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (82, 48, '0913140101', '0', '更新no', '农公司给', '2023-02-10', '0', '2023-02-14 23:12:27', '0');
INSERT INTO `t_message` VALUES (83, 48, '0913140102', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (84, 48, '0961180101', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (85, 48, '0961180102', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (86, 48, '1011130311', '0', '更新no', '农公司给', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (87, 51, '0961180101', '1', '1234', '12341234', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (88, 51, '0961180102', '1', '1234', '12341234', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (89, 78, '0961180101', '1', '行了', '玩', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (90, 78, '0961180102', '1', '行了', '玩', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (91, 81, '0961180102', '2', 'josoajg', 'asdfjaspdijgjag', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (92, 81, '0961180101', '2', 'josoajg', 'asdfjaspdijgjag', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (93, 82, '0913140102', '2', 'ceshi', 'chengongle', '2023-02-10', '1', NULL, '0');
INSERT INTO `t_message` VALUES (94, 83, '0913140101', '1', '测试', '832就老怕四大金刚', '2023-02-11', '1', NULL, '0');
INSERT INTO `t_message` VALUES (95, 83, '0913140102', '1', '测试', '832就老怕四大金刚', '2023-02-11', '1', NULL, '0');
INSERT INTO `t_message` VALUES (96, 83, '0961180101', '1', '测试', '832就老怕四大金刚', '2023-02-11', '1', NULL, '0');
INSERT INTO `t_message` VALUES (97, 83, '0961180102', '1', '测试', '832就老怕四大金刚', '2023-02-11', '1', NULL, '0');
INSERT INTO `t_message` VALUES (98, 85, '0913140101', '1', '1231', '341234', '2023-02-11', '0', NULL, '0');
INSERT INTO `t_message` VALUES (99, 85, '0913140102', '1', '1231', '341234', '2023-02-11', '0', NULL, '0');
INSERT INTO `t_message` VALUES (100, 69, '0913140101', '1', '测试', '测试内容，下礼拜考试', '2023-02-12', '0', '2023-02-13 00:58:35', '0');
INSERT INTO `t_message` VALUES (101, 69, '0913140102', '1', '测试', '测试内容，下礼拜考试', '2023-02-12', '1', NULL, '0');
INSERT INTO `t_message` VALUES (102, 69, '0961180101', '1', '测试', '测试内容，下礼拜考试', '2023-02-12', '1', NULL, '0');
INSERT INTO `t_message` VALUES (103, 69, '0961180102', '1', '测试', '测试内容，下礼拜考试', '2023-02-12', '1', NULL, '0');
INSERT INTO `t_message` VALUES (198, NULL, '0714150221', '0', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (199, NULL, '0714150228', '0', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (200, NULL, '0761130329', '0', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (201, NULL, '0761130330', '0', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (202, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (203, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (204, NULL, '0913140102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (205, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (206, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (207, NULL, '0961180102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (208, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (209, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (210, NULL, '0913140102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (211, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (212, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (213, NULL, '0961180102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (214, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (215, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (216, NULL, '0913140102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (217, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (218, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (219, NULL, '0961180102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (220, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (221, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (222, NULL, '0913140102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (223, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (224, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (225, NULL, '0961180102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (226, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (227, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (228, NULL, '0913140102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (229, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (230, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (231, NULL, '0961180102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (232, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (233, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (234, NULL, '0913140102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (235, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (236, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (237, NULL, '0961180102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (238, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (239, NULL, '0913140101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (240, NULL, '0913140102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (241, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为形势与政策1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (242, NULL, '0961180101', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为高等数学I1', '2023-02-14', '1', NULL, '1');
INSERT INTO `t_message` VALUES (243, NULL, '0961180102', '1', '重修课程提醒', '有重修预警,请尽快查看 科目为英语', '2023-02-14', '1', NULL, '1');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `urole` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publisher` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `release_time` date NOT NULL,
  `caution_college` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `caution_major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `caution_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `caution_year` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `caution_student` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isAck` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (34, '1', 'geng', '123123', '啊发顺丰大多数', '2023-02-10', '数学与信息科技学院', '网络工程', '网络1203', '2014', '', NULL);
INSERT INTO `t_notice` VALUES (35, '1', 'geng', '12312', '3123123', '2023-02-10', '数学与信息科技学院', '计算机科学与技术', '计算机1204', '2012', '', NULL);
INSERT INTO `t_notice` VALUES (36, '1', 'geng', '123', '123132', '2023-02-10', '数学与信息科技学院', '计算机科学与技术', '计算机1204', '', '', NULL);
INSERT INTO `t_notice` VALUES (37, '1', 'geng', '123123', '123123123', '2023-02-10', '数学与信息科技学院', '', '', '', '', NULL);
INSERT INTO `t_notice` VALUES (38, '1', 'geng', '123123', '123123123', '2023-02-10', '数学与信息科技学院', '计算机科学与技术', '计算机1204', '', '', NULL);
INSERT INTO `t_notice` VALUES (39, '1', 'geng', '213', '发送到发斯蒂芬', '2023-02-10', '数学与信息科技学院', '网络工程', '网络1201', '', '', NULL);
INSERT INTO `t_notice` VALUES (40, '1', 'geng', '123123', '123123213', '2023-02-10', '数学与信息科技学院', '网络工程', '网络1201', '2012', '', NULL);
INSERT INTO `t_notice` VALUES (41, '0', 'admin', '123123', 'goangaljaspdjifaskdjfpasdifjoasnglkjdafspdingl;aksjdfpasjidogaspdjfiaslng', '2023-02-10', '', '', '', '', '', NULL);
INSERT INTO `t_notice` VALUES (42, '2', 'bzr', '12312', '3123123', '2023-02-10', '数学与信息科技学院', '网络工程', '网络1201', '', 'asdfsaf,1231231,123123,123123,123123123', NULL);
INSERT INTO `t_notice` VALUES (43, '2', 'bzr', '漂酿噶几了', '私立的foe激发司空见惯吉林科技gapiOS宫颈癌昆仑神宫你', '2023-02-10', '数学与信息科技学院', '网络工程', '网络1202', '', '1234234,12341234,1234,1234,123421,3412,34122342134', NULL);
INSERT INTO `t_notice` VALUES (44, '2', 'bzr', '412341234', '12341234', '2023-02-10', '数学与信息科技学院', '网络工程', '', '', '', NULL);
INSERT INTO `t_notice` VALUES (45, '2', 'bzr', '123132', '阿萨德发顺丰的', '2023-02-10', '数学与信息科技学院', '网络工程', '', '', '123123', NULL);
INSERT INTO `t_notice` VALUES (46, '2', 'bzr', '123123', '12313123', '2023-02-10', '数学与信息科技学院', '网络工程', '网络1201', '', '1231231', '0');
INSERT INTO `t_notice` VALUES (47, '0', 'admin', '信息更新', '请尽快查看', '2023-02-10', '', '', '', '', '', '0');
INSERT INTO `t_notice` VALUES (48, '0', 'admin', '更新no', '农公司给', '2023-02-10', '', '', '', '', '', '1');
INSERT INTO `t_notice` VALUES (49, '1', 'geng', '1234', '12341234', '2023-02-10', '数学与信息科技学院', '计算机科学与技术', '', '', '', '1');
INSERT INTO `t_notice` VALUES (50, '1', 'geng', '1234', '12341234', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (51, '1', 'geng', '1234', '12341234', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (52, '1', 'geng', 'haoho', 'hohjlsdpfigjsdofgdgdf', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (53, '1', 'geng', 'z中国', '忘不了', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (54, '1', 'geng', 'z中国', '忘不了', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (55, '1', 'geng', 'z中国', '忘不了', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (56, '1', 'geng', '哈哈哈哈', '忘不了', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (57, '1', 'geng', '哈哈哈哈', '忘不了', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (58, '1', 'geng', '哈哈哈哈', '忘不了', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (59, '1', 'geng', '1233241234', '123123123123123', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (60, '1', 'geng', '123040324', '你还', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (61, '1', 'geng', '123040324', '你还', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (62, '1', 'geng', '测试', '你还', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (63, '1', 'geng', '不好', '玩', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (64, '1', 'geng', '最后一次', '玩', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (65, '1', 'geng', '一次', '玩', '2023-02-10', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (67, '1', 'geng', '一次', '玩', '2023-02-10', '数学与信息科技学院', '计算机科学与技术', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (68, '1', 'geng', '搞不明白了', '玩', '2023-02-10', '数学与信息科技学院', '计算机科学与技术', '计算机1801(对口)', '', '', '1');
INSERT INTO `t_notice` VALUES (69, '1', 'geng', '测试', '测试内容，下礼拜考试', '2023-02-12', '数学与信息科技学院', '', '', '', '', '1');

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
  `petp_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_pub_ele_tea_program
-- ----------------------------
INSERT INTO `t_pub_ele_tea_program` VALUES ('111', '2016', '1', '你好中国', 'GXK01', '公共选修课', '人文', 1.5, '财经学院', '论文');

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
  `cousre_select` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程选择',
  `makeup` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '补考'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_score
-- ----------------------------
INSERT INTO `t_score` VALUES ('2014-2015', '1', '0913140101', '巴兴福1', '革命传统教育', 'BS150010', 0, 0, 80, NULL, 1, 3, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2014-2015', '1', '0913140101', '巴兴福1', '形势与政策1', 'BS150351', 0, 0, 90, NULL, 0.5, 4, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2014-2015', '1', '0913140101', '巴兴福1', '高等数学I1', 'BL110011', 0, 0, 67, NULL, 4, 1, '1', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2014-2015', '1', '0913140101', '巴兴福1', '高等数学I1', 'BL110011', 0, 0, 35, NULL, 4, 0, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2014-2015', '1', '0913140102', '刘川', '革命传统教育', 'BS150010', 0, 0, 80, NULL, 1, 3, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2014-2015', '1', '0913140102', '刘川', '形势与政策1', 'BS150351', 0, 0, 78, NULL, 0.5, 2, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2014-2015', '1', '0913140102', '刘川', '线性代数', 'BL110012', 0, 0, 65, NULL, 4, 1, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2014-2015', '1', '0913140102', '刘川', '高等数学I1', 'BL110011', 0, 0, 45, NULL, 4, 0, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2016-2017', '2', '0913140102', '刘川', '英语', 'BL11244', 0, 0, 35, NULL, 4, 0, '0', '公共通修课', '0');
INSERT INTO `t_score` VALUES ('2015-2016', '1', '0714150221', '王倩倩', '革命传统教育', 'BS150010', 0, 0, 80, NULL, 1, 3, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2015-2016', '1', '0714150221', '王倩倩', '形势与政策1', 'BS150351', 0, 0, 70, NULL, 0.5, 4, '0', '实践教学环节', '1');
INSERT INTO `t_score` VALUES ('2015-2016', '1', '0714150221', '王倩倩', '高等数学I1', 'BL110011', 0, 0, 67, NULL, 4, 1, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2015-2016', '1', '0714150221', '王倩倩', '高等数学I1', 'BL110011', 0, 0, 35, NULL, 4, 0, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2016-2017', '2', '0714150221', '王倩倩', '英语', 'BL11244', 0, 0, 35, NULL, 4, 1, '1', '公共通修课', '0');
INSERT INTO `t_score` VALUES ('2015-2016', '1', '0714150228', '张秀玉', '革命传统教育', 'BS150010', 0, 0, 80, NULL, 1, 3, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2015-2016', '1', '0714150228', '张秀玉', '形势与政策1', 'BS150351', 0, 0, 78, NULL, 0.5, 2, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2015-2016', '1', '0714150228', '张秀玉', '线性代数', 'BL110012', 0, 0, 65, NULL, 4, 1, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2015-2016', '1', '0714150228', '张秀玉', '高等数学I1', 'BL110011', 0, 0, 45, NULL, 4, 0, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2016-2017', '2', '0714150228', '张秀玉', '英语', 'BL11244', 0, 0, 35, NULL, 4, 0, '0', '公共通修课', '0');
INSERT INTO `t_score` VALUES ('2013-2014', '1', '0761130329', '朱珂', '革命传统教育', 'BS150010', 0, 0, 80, NULL, 1, 3, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2013-2014', '1', '0761130329', '朱珂', '形势与政策1', 'BS150351', 0, 0, 70, NULL, 0.5, 4, '0', '实践教学环节', '1');
INSERT INTO `t_score` VALUES ('2013-2014', '1', '0761130329', '朱珂', '高等数学I1', 'BL110011', 0, 0, 67, NULL, 4, 1, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2013-2014', '1', '0761130329', '朱珂', '高等数学I1', 'BL110011', 0, 0, 35, NULL, 4, 0, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2014-2015', '2', '0761130329', '朱珂', '英语', 'BL11244', 0, 0, 35, NULL, 4, 1, '1', '公共通修课', '0');
INSERT INTO `t_score` VALUES ('2013-2014', '1', '0761130330', '宗学慧', '革命传统教育', 'BS150010', 0, 0, 80, NULL, 1, 3, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2013-2014', '1', '0761130330', '宗学慧', '形势与政策1', 'BS150351', 0, 0, 78, NULL, 0.5, 2, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2013-2014', '1', '0761130330', '宗学慧', '线性代数', 'BL110012', 0, 0, 65, NULL, 4, 1, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2013-2014', '1', '0761130330', '宗学慧', '高等数学I1', 'BL110011', 0, 0, 45, NULL, 4, 0, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2014-2015', '2', '0761130330', '宗学慧', '英语', 'BL11244', 0, 0, 35, NULL, 4, 0, '0', '公共通修课', '0');
INSERT INTO `t_score` VALUES ('2018-2019', '1', '0961180101', '高兴', '革命传统教育', 'BS150010', 0, 0, 80, NULL, 1, 3, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2018-2019', '1', '0961180101', '高兴', '形势与政策1', 'BS150351', 0, 0, 55, NULL, 0.5, 4, '0', '实践教学环节', '1');
INSERT INTO `t_score` VALUES ('2018-2019', '1', '0961180101', '高兴', '高等数学I1', 'BL110011', 0, 0, 67, NULL, 4, 1, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2018-2019', '1', '0961180101', '高兴', '高等数学I1', 'BL110011', 0, 0, 35, NULL, 4, 0, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2019-2020', '2', '0961180101', '高兴', '英语', 'BL11244', 0, 0, 32, NULL, 4, 1, '1', '公共通修课', '0');
INSERT INTO `t_score` VALUES ('2018-2019', '1', '0961180102', '康子', '革命传统教育', 'BS150010', 0, 0, 80, NULL, 1, 3, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2018-2019', '1', '0961180102', '康子', '形势与政策1', 'BS150351', 0, 0, 78, NULL, 0.5, 2, '0', '实践教学环节', '0');
INSERT INTO `t_score` VALUES ('2018-2019', '1', '0961180102', '康子', '线性代数', 'BL110012', 0, 0, 65, NULL, 4, 1, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2018-2019', '1', '0961180102', '康子', '高等数学I1', 'BL110011', 0, 0, 45, NULL, 4, 0, '0', '专业基础课程', '0');
INSERT INTO `t_score` VALUES ('2019-2020', '2', '0961180102', '康子', '英语', 'BL11244', 0, 0, 30, NULL, 4, 0, '0', '公共通修课', '0');

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
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('0114120103', '崔冰馨', '女', '财经学院', '财务管理', '财管1203', '2012-09-10');
INSERT INTO `t_student` VALUES ('0114120116', '任瑞泽', '男', '财经学院', '财务管理', '财管1203', '2012-09-10');
INSERT INTO `t_student` VALUES ('0212130211', '刘雨明', '女', '财经学院', '财务会计教育', '财教1304', '2013-09-10');
INSERT INTO `t_student` VALUES ('0711130510', '胡丹', '女', '财经学院', '财务会计教育', '财教1305', '2013-09-10');
INSERT INTO `t_student` VALUES ('0711130511', '黄小伶', '女', '财经学院', '财务会计教育', '财教1305', '2013-09-10');
INSERT INTO `t_student` VALUES ('0711130515', '李汝雨', '女', '财经学院', '财务会计教育', '财教1305', '2013-09-10');
INSERT INTO `t_student` VALUES ('0711130516', '李艳玲', '女', '财经学院', '财务会计教育', '财教1305', '2013-09-10');
INSERT INTO `t_student` VALUES ('0711140429', '郑志城', '男', '财经学院', '财务会计教育', '财教1404', '2014-09-10');
INSERT INTO `t_student` VALUES ('0711140430', '左明卉', '女', '财经学院', '财务会计教育', '财教1404', '2014-09-10');
INSERT INTO `t_student` VALUES ('0713140223', '王梦颖', '女', '财经学院', '财务管理', '财管1403', '2014-09-10');
INSERT INTO `t_student` VALUES ('0714120231', '郑金尧', '男', '财经学院', '财务管理', '财管1202', '2012-09-10');
INSERT INTO `t_student` VALUES ('0714120232', '佟年', '女', '财经学院', '财务管理', '财管1202', '2012-09-10');
INSERT INTO `t_student` VALUES ('0714130209', '兰志慧', '女', '财经学院', '财务管理', '财管1302', '2013-09-10');
INSERT INTO `t_student` VALUES ('0714130210', '李小敏', '女', '财经学院', '财务管理', '财管1302', '2013-09-10');
INSERT INTO `t_student` VALUES ('0714130217', '邵卓胥', '男', '财经学院', '财务管理', '财管1402', '2013-09-10');
INSERT INTO `t_student` VALUES ('0714130218', '苏诗语', '女', '财经学院', '财务管理', '财管1302', '2013-09-10');
INSERT INTO `t_student` VALUES ('0714130219', '苏婷婷', '女', '财经学院', '财务管理', '财管1302', '2013-09-10');
INSERT INTO `t_student` VALUES ('0714140126', '张榕', '女', '财经学院', '财务管理', '财管1401', '2014-09-10');
INSERT INTO `t_student` VALUES ('0714140127', '张妍', '女', '财经学院', '财务管理', '财管1401', '2014-09-10');
INSERT INTO `t_student` VALUES ('0714140132', '朱少帆', '男', '财经学院', '财务管理', '财管1401', '2014-09-10');
INSERT INTO `t_student` VALUES ('0714140133', '薛凯丽', '女', '财经学院', '财务管理', '财管1401', '2014-09-10');
INSERT INTO `t_student` VALUES ('0714140202', '戴航', '男', '财经学院', '财务管理', '财管1402', '2014-09-10');
INSERT INTO `t_student` VALUES ('0714140203', '丁晗悦', '女', '财经学院', '财务管理', '财管1402', '2014-09-10');
INSERT INTO `t_student` VALUES ('0714140208', '韩凯', '女', '财经学院', '财务管理', '财管1402', '2014-09-10');
INSERT INTO `t_student` VALUES ('0714140209', '康婷', '女', '财经学院', '财务管理', '财管1402', '2014-09-10');
INSERT INTO `t_student` VALUES ('0714150221', '王倩倩', '女', '财经学院', '财务管理', '财管1502', '2015-09-10');
INSERT INTO `t_student` VALUES ('0714150228', '张秀玉', '女', '财经学院', '财务管理', '财管1502', '2015-09-10');
INSERT INTO `t_student` VALUES ('0714150230', '赵梦蝶', '女', '财经学院', '财务管理', '财管1502', '2015-09-10');
INSERT INTO `t_student` VALUES ('0761120113', '彭艳丽', '女', '财经学院', '财务会计教育[对口]', '财教1201', '2012-09-10');
INSERT INTO `t_student` VALUES ('0761120114', '齐红娜', '女', '财经学院', '财务会计教育[对口]', '财教1201', '2012-09-10');
INSERT INTO `t_student` VALUES ('0761120226', '张雪', '女', '财经学院', '财务会计教育[对口]', '财教1202', '2012-09-10');
INSERT INTO `t_student` VALUES ('0761120227', '张雪娟', '女', '财经学院', '财务会计教育[对口]', '财教1202', '2012-09-10');
INSERT INTO `t_student` VALUES ('0761130204', '崔志红', '女', '财经学院', '财务会计教育[对口]', '财教1302(对口)', '2013-09-10');
INSERT INTO `t_student` VALUES ('0761130205', '邓雪', '女', '财经学院', '财务会计教育[对口]', '财教1302(对口)', '2013-09-10');
INSERT INTO `t_student` VALUES ('0761130329', '朱珂', '女', '财经学院', '财务会计教育[对口]', '财教1303(对口)', '2013-09-10');
INSERT INTO `t_student` VALUES ('0761130330', '宗学慧', '女', '财经学院', '财务会计教育[对口]', '财教1303(对口)', '2013-09-10');
INSERT INTO `t_student` VALUES ('0762150218', '王丽萍', '女', '财经学院', '保险学[对口]', '保险1502(对口)', '2015-09-10 00:00:00');
INSERT INTO `t_student` VALUES ('0814140118', '孙佳琦', '女', '财经学院', '财务管理', '财管1404', '2014-09-10');
INSERT INTO `t_student` VALUES ('0913140101', '巴兴福1', '男', '数学与信息科技学院', '网络工程', '网络1401', '2014-09-10 00:00:00');
INSERT INTO `t_student` VALUES ('0913140102', '刘川', '男', '数学与信息科技学院', '网络工程', '网络1401', '2014-09-10 00:00:00');
INSERT INTO `t_student` VALUES ('0961180101', '高兴', '男', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '2018-09-10 00:00:00');
INSERT INTO `t_student` VALUES ('0961180102', '康子', '男', '数学与信息科技学院', '计算机科学与技术[对口]', '计算机1801(对口)', '2018-09-10 00:00:00');
INSERT INTO `t_student` VALUES ('1011130311', '李梦迪', '女', '财经学院', '财务管理', '财管1303', '2013-09-10');

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
  `teach_college` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开课学院',
  PRIMARY KEY (`tp_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_teaching_program
-- ----------------------------
INSERT INTO `t_teaching_program` VALUES ('20140913', '0913', '网络工程', '2016-2017', '2', '英语', 'BL11244', '公共通修课程', 4, '必修', '外国语学院');

-- ----------------------------
-- Table structure for t_teaching_program_major_credit
-- ----------------------------
DROP TABLE IF EXISTS `t_teaching_program_major_credit`;
CREATE TABLE `t_teaching_program_major_credit`  (
  `tpm_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教学计划号 年级+专业代码',
  `major_id` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业',
  `year` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年级',
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
-- Records of t_teaching_program_major_credit
-- ----------------------------
INSERT INTO `t_teaching_program_major_credit` VALUES ('20140913', '0913', '2014', 154.75, 7, 44.5, 46.5, 17.25, 6.5, 5, 28);
INSERT INTO `t_teaching_program_major_credit` VALUES ('20150913', '0913', '2015', 164.75, 7, 44.5, 46.5, 17.25, 6.5, 10, 28);
INSERT INTO `t_teaching_program_major_credit` VALUES ('20160711', '0711', '2016', 4, 0, 0, 2, 0, 0, 0, 2);
INSERT INTO `t_teaching_program_major_credit` VALUES ('20160913', '0913', '2016', 153.75, 8, 44.5, 46.5, 17.25, 6.5, 6, 29);

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'test', NULL, 'test', '0', '', '0', NULL);
INSERT INTO `t_user` VALUES (2, 'geng', NULL, 'geng', '1', '09', '09', NULL);
INSERT INTO `t_user` VALUES (3, '0913140101', '巴兴福', '0913140101', '3', '09', '0913', '2014');
INSERT INTO `t_user` VALUES (4, 'admin', NULL, 'admin', '0', '00', '00', NULL);
INSERT INTO `t_user` VALUES (5, 'bzr', NULL, 'bzr', '2', '09', '0913', '2014');
INSERT INTO `t_user` VALUES (6, '0714150221', '王倩倩', '0714150221', '3', '07', '0714', '2015');

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

-- ----------------------------
-- View structure for courseinfo
-- ----------------------------
DROP VIEW IF EXISTS `courseinfo`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `courseinfo` AS SELECT
t_student.studnet_id,
t_score.learn_year,
t_score.semester,
t_student.student_name,
t_score.course_name,
t_score.course_code,
t_score.score,
t_score.credit,
t_score.`rebuild`,
t_score.cousre_select,
t_score.makeup,
t_student.`year`,
t_classes.classes_name,
t_college.college_name,
t_major.major_name,
t_score.notes
FROM
t_student
LEFT JOIN t_score ON t_student.studnet_id = t_score.student_id
LEFT JOIN t_classes ON t_classes.classes_name = t_student.classes_name
LEFT JOIN t_college ON t_college.college_name = t_student.college_name
LEFT JOIN t_major ON t_major.major_name = t_student.major_name ;

SET FOREIGN_KEY_CHECKS = 1;
