package edu.hevttc.workbench.course.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.operations.Or;
import edu.hevttc.basic.mapper.MajorMapper;
import edu.hevttc.basic.mapper.TeachingProgramMapper;
import edu.hevttc.commons.PageBean;
import edu.hevttc.domain.Major;
import edu.hevttc.domain.TeachingProgram;
import edu.hevttc.util.RQUtil;
import edu.hevttc.util.UrlEncode;
import edu.hevttc.workbench.course.struct.vo.CourseInfoVo;
import edu.hevttc.workbench.course.struct.vo.RebuildInfoVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.workbench.course.mapper.CourseInfoMapper;
import edu.hevttc.workbench.course.domain.CourseInfo;
import edu.hevttc.workbench.course.service.CourseInfoService;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.lang.model.element.VariableElement;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CourseInfoServiceImpl extends ServiceImpl<CourseInfoMapper, CourseInfo> implements CourseInfoService {
    @Resource
    private CourseInfoMapper courseInfoMapper;
    @Resource
    private TeachingProgramMapper teachingProgramMapper;
    @Resource
    private MajorMapper majorMapper;

    @Override
    public PageBean loadCourseInfoPage(Integer pageNum, Integer pageSize, CourseInfo courseInfo) {
        final Page<CourseInfo> courseInfoPage = courseInfoMapper.selectPage(new Page<>().of(pageNum, pageSize), new LambdaQueryWrapper<CourseInfo>()
                .like(StringUtils.hasText(courseInfo.getCollegeName()), CourseInfo::getCollegeName, courseInfo.getCollegeName())
                .eq(StringUtils.hasText(courseInfo.getMajorName()), CourseInfo::getMajorName, courseInfo.getMajorName())
                .eq(StringUtils.hasText(courseInfo.getClassesName()), CourseInfo::getClassesName, courseInfo.getClassesName())
                .like(StringUtils.hasText(courseInfo.getLearnYear()), CourseInfo::getLearnYear, courseInfo.getLearnYear())
                .like(StringUtils.hasText(courseInfo.getSemester()), CourseInfo::getSemester, courseInfo.getSemester())
                .likeRight(StringUtils.hasText(courseInfo.getYear()), CourseInfo::getYear, courseInfo.getYear())
                .eq(StringUtils.hasText(courseInfo.getStudnetId()), CourseInfo::getStudnetId, courseInfo.getStudnetId())
                .lt(CourseInfo::getScore, 60).orderByAsc(CourseInfo::getStudnetId));
        List<CourseInfo> records = courseInfoPage.getRecords();
        Integer totalNum = Math.toIntExact(courseInfoMapper.selectCount(new LambdaQueryWrapper<CourseInfo>()
                .like(StringUtils.hasText(courseInfo.getCollegeName()), CourseInfo::getCollegeName, courseInfo.getCollegeName())
                .eq(StringUtils.hasText(courseInfo.getMajorName()), CourseInfo::getMajorName, courseInfo.getMajorName())
                .eq(StringUtils.hasText(courseInfo.getClassesName()), CourseInfo::getClassesName, courseInfo.getClassesName())
                .like(StringUtils.hasText(courseInfo.getLearnYear()), CourseInfo::getLearnYear, courseInfo.getLearnYear())
                .like(StringUtils.hasText(courseInfo.getSemester()), CourseInfo::getSemester, courseInfo.getSemester())
                .likeRight(StringUtils.hasText(courseInfo.getYear()), CourseInfo::getYear, courseInfo.getYear())
                .eq(StringUtils.hasText(courseInfo.getStudnetId()), CourseInfo::getStudnetId, courseInfo.getStudnetId())
                .lt(CourseInfo::getScore, 60)));
        PageBean<CourseInfoVo> pageBean = new PageBean<>(pageNum, totalNum, pageSize);
        List<CourseInfoVo> courseInfoList = new ArrayList<>();
        for (CourseInfo score1 : records) {
            String failInfo = "";
            if (score1.getMakeup().equals("1")) {
                failInfo = "补考未通过待转重修";
            } else if (score1.getRebuild().equals("1")) {
                failInfo = "重修未通过";
            } else if (score1.getScore() >= 40) {
                failInfo = "待补考";
            } else {
                failInfo = "待重修";
            }
            CourseInfoVo courseInfo1 = CourseInfoVo.builder().
                    courseCode(score1.getCourseCode())
                    .classesName(score1.getCourseName())
                    .collegeName(score1.getCollegeName())
                    .cousreSelect(score1.getCousreSelect())
                    .score(score1.getScore())
                    .learnYear(score1.getLearnYear())
                    .studentId(score1.getStudnetId())
                    .studnetName(score1.getStudentName())
                    .majorName(score1.getMajorName())
                    .rebuild(score1.getRebuild())
                    .makeup(score1.getMakeup())
                    .semester(score1.getSemester())
                    .courseName(score1.getCourseName())
                    .credit(score1.getCredit())
                    .collegeName(score1.getCollegeName())
                    .majorName(score1.getMajorName())
                    .classesName(score1.getClassesName())
                    .failInfo(failInfo)
                    .build();
            courseInfoList.add(courseInfo1);
        }
        pageBean.setPageData(courseInfoList);
        return pageBean;
    }

    @Override
    public PageBean loadRebuildInfoPage(Integer pageNum, Integer pageSize, CourseInfo courseInfo) {
//        String learnYear = RQUtil.getLearnYear();
//        int sub1 = Integer.parseInt(learnYear.substring(0, 4)) + 1;
//        int sub2 = Integer.parseInt(learnYear.substring(5)) + 1;
//        String rebuildLearnYear = sub1 + "-" + sub2;
        String learnYear = "";
        final Page<CourseInfo> courseInfoPage = courseInfoMapper.selectPage(new Page<>().of(pageNum, pageSize), new LambdaQueryWrapper<CourseInfo>()
                .eq(CourseInfo::getRebuild, "0")
                .and(courseInfoLambdaQueryWrapper -> {
                    courseInfoLambdaQueryWrapper.eq(CourseInfo::getNotes, "缺考").or().eq(CourseInfo::getNotes, "<=40重修")
                            .or(courseInfoLambdaQueryWrapper1 -> {
                                courseInfoLambdaQueryWrapper1.eq(CourseInfo::getMakeup, "1").
                                        lt(CourseInfo::getScore, 60);
                            })
                            .or().lt(CourseInfo::getScore, 40);
                })
                .like(StringUtils.hasText(courseInfo.getCollegeName()), CourseInfo::getCollegeName, courseInfo.getCollegeName())
                .eq(StringUtils.hasText(courseInfo.getMajorName()), CourseInfo::getMajorName, courseInfo.getMajorName())
                .eq(StringUtils.hasText(courseInfo.getClassesName()), CourseInfo::getClassesName, courseInfo.getClassesName())
                .eq(StringUtils.hasText(learnYear), CourseInfo::getLearnYear, learnYear)
                .eq(StringUtils.hasText(courseInfo.getSemester()), CourseInfo::getSemester, courseInfo.getSemester())
                .eq(StringUtils.hasText(courseInfo.getYear()), CourseInfo::getYear, courseInfo.getYear())
                .eq(StringUtils.hasText(courseInfo.getStudnetId()), CourseInfo::getStudnetId, courseInfo.getStudnetId())
                .orderByAsc(CourseInfo::getStudnetId));
        List<CourseInfo> records = courseInfoPage.getRecords();
        Integer count = Math.toIntExact(courseInfoMapper.selectCount(new LambdaQueryWrapper<CourseInfo>()
                .eq(CourseInfo::getRebuild, "0")
                .and(courseInfoLambdaQueryWrapper -> {
                    courseInfoLambdaQueryWrapper.eq(CourseInfo::getNotes, "缺考").or().eq(CourseInfo::getNotes, "<=40重修")
                            .or(courseInfoLambdaQueryWrapper1 -> {
                                courseInfoLambdaQueryWrapper1.eq(CourseInfo::getMakeup, "1").
                                        lt(CourseInfo::getScore, 60);
                            })
                            .or().lt(CourseInfo::getScore, 40);
                })
                .like(StringUtils.hasText(courseInfo.getCollegeName()), CourseInfo::getCollegeName, courseInfo.getCollegeName())
                .eq(StringUtils.hasText(courseInfo.getMajorName()), CourseInfo::getMajorName, courseInfo.getMajorName())
                .eq(StringUtils.hasText(courseInfo.getClassesName()), CourseInfo::getClassesName, courseInfo.getClassesName())
                .eq(StringUtils.hasText(learnYear), CourseInfo::getLearnYear, learnYear)
                .eq(StringUtils.hasText(courseInfo.getSemester()), CourseInfo::getSemester, courseInfo.getSemester())
                .eq(StringUtils.hasText(courseInfo.getYear()), CourseInfo::getYear, courseInfo.getYear())
                .eq(StringUtils.hasText(courseInfo.getStudnetId()), CourseInfo::getStudnetId, courseInfo.getStudnetId())
                .orderByAsc(CourseInfo::getStudnetId)));
        PageBean<RebuildInfoVO> pageBean = new PageBean<>(pageNum, count, pageSize);
        List<RebuildInfoVO> rebuildInfoList = new ArrayList<>();
        for (CourseInfo record : records) {
            int sub1 = Integer.parseInt(record.getLearnYear().substring(0, 4)) + 1;
            int sub2 = Integer.parseInt(record.getLearnYear().substring(5)) + 1;
            String rebuildLearnYear = sub1 + "-" + sub2;
            Major major = majorMapper.selectOne(new LambdaQueryWrapper<Major>().eq(Major::getMajorName, record.getMajorName()));
            TeachingProgram teachingProgram = teachingProgramMapper.selectOne(new LambdaQueryWrapper<TeachingProgram>()
                    .eq(TeachingProgram::getCourseId, record.getCourseCode())
                    .eq(TeachingProgram::getLearnYear, record.getLearnYear())
                    .eq(TeachingProgram::getMajorId, major.getMajorId()));
            String teachCollege = ObjectUtil.isNotNull(teachingProgram) ? teachingProgram.getTeachCollege() : "";
            System.out.println(teachingProgram);
            RebuildInfoVO rebuildInfo = RebuildInfoVO.builder().
                    courseCode(record.getCourseCode())
                    .classesName(record.getCourseName())
                    .collegeName(record.getCollegeName())
                    .cousreSelect(record.getCousreSelect())
                    .score(record.getScore())
                    .learnYear(record.getLearnYear())
                    .studentId(record.getStudnetId())
                    .studnetName(record.getStudentName())
                    .majorName(record.getMajorName())
                    .semester(record.getSemester())
                    .courseName(record.getCourseName())
                    .credit(record.getCredit())
                    .collegeName(record.getCollegeName())
                    .majorName(record.getMajorName())
                    .classesName(record.getClassesName())
                    .teachCollege(teachCollege)
                    .rebuildCourseCode(record.getCourseCode())
                    .rebuildCourseName(record.getCourseName())
                    .rebuildLearnYear(rebuildLearnYear).
                            rebuildSemester(record.getSemester())
                    .enroll("是")
                    .build();
            rebuildInfoList.add(rebuildInfo);
        }
        pageBean.setPageData(rebuildInfoList);
        return pageBean;
    }

    //不及格导出
    @Override
    public List<CourseInfoVo> allExprot(CourseInfo courseInfo) {

        List<CourseInfo> courseInfos = courseInfoMapper.selectList(new LambdaQueryWrapper<CourseInfo>()
                .like(StringUtils.hasText(courseInfo.getCollegeName()), CourseInfo::getCollegeName, courseInfo.getCollegeName())
                .eq(StringUtils.hasText(courseInfo.getMajorName()), CourseInfo::getMajorName, courseInfo.getMajorName())
                .eq(StringUtils.hasText(courseInfo.getClassesName()), CourseInfo::getClassesName, courseInfo.getClassesName())
                .like(StringUtils.hasText(courseInfo.getLearnYear()), CourseInfo::getLearnYear, courseInfo.getLearnYear())
                .like(StringUtils.hasText(courseInfo.getSemester()), CourseInfo::getSemester, courseInfo.getSemester())
                .likeRight(StringUtils.hasText(courseInfo.getYear()), CourseInfo::getYear, courseInfo.getYear())
                .eq(StringUtils.hasText(courseInfo.getStudnetId()), CourseInfo::getStudnetId, courseInfo.getStudnetId())
                .lt(CourseInfo::getScore, 60).orderByAsc(CourseInfo::getStudnetId));
        List<CourseInfoVo> courseInfoList = new ArrayList<>();
        for (CourseInfo score1 : courseInfos) {
            String failInfo = "";
            if (score1.getMakeup().equals("1")) {
                failInfo = "补考未通过待转重修";
            } else if (score1.getRebuild().equals("1")) {
                failInfo = "重修未通过";
            } else if (score1.getScore() >= 40) {
                failInfo = "待补考";
            } else {
                failInfo = "待重修";
            }
            CourseInfoVo courseInfo1 = CourseInfoVo.builder().
                    courseCode(score1.getCourseCode())
                    .classesName(score1.getCourseName())
                    .collegeName(score1.getCollegeName())
                    .cousreSelect(score1.getCousreSelect())
                    .score(score1.getScore())
                    .learnYear(score1.getLearnYear())
                    .studentId(score1.getStudnetId())
                    .studnetName(score1.getStudentName())
                    .majorName(score1.getMajorName())
                    .rebuild(score1.getRebuild())
                    .makeup(score1.getMakeup())
                    .semester(score1.getSemester())
                    .courseName(score1.getCourseName())
                    .credit(score1.getCredit())
                    .collegeName(score1.getCollegeName())
                    .majorName(score1.getMajorName())
                    .classesName(score1.getClassesName())
                    .failInfo(failInfo)
                    .build();
            courseInfoList.add(courseInfo1);
        }
        return courseInfoList;
    }

    //重修导出
    @Override
    public  List<RebuildInfoVO> allRebuidExprot(CourseInfo courseInfo) {
        //        String learnYear = RQUtil.getLearnYear();
//        int sub1 = Integer.parseInt(learnYear.substring(0, 4)) + 1;
//        int sub2 = Integer.parseInt(learnYear.substring(5)) + 1;
//        String rebuildLearnYear = sub1 + "-" + sub2;
        String learnYear = "";
        List<CourseInfo> rebuildList = courseInfoMapper.selectList(new LambdaQueryWrapper<CourseInfo>()
                .eq(CourseInfo::getRebuild, "0")
                .and(courseInfoLambdaQueryWrapper -> {
                    courseInfoLambdaQueryWrapper.eq(CourseInfo::getNotes, "缺考").or().eq(CourseInfo::getNotes, "<=40重修")
                            .or(courseInfoLambdaQueryWrapper1 -> {
                                courseInfoLambdaQueryWrapper1.eq(CourseInfo::getMakeup, "1").
                                        lt(CourseInfo::getScore, 60);
                            })
                            .or().lt(CourseInfo::getScore, 40);
                })
                .like(StringUtils.hasText(courseInfo.getCollegeName()), CourseInfo::getCollegeName, courseInfo.getCollegeName())
                .eq(StringUtils.hasText(courseInfo.getMajorName()), CourseInfo::getMajorName, courseInfo.getMajorName())
                .eq(StringUtils.hasText(courseInfo.getClassesName()), CourseInfo::getClassesName, courseInfo.getClassesName())
                .eq(StringUtils.hasText(learnYear), CourseInfo::getLearnYear, learnYear)
                .eq(StringUtils.hasText(courseInfo.getSemester()), CourseInfo::getSemester, courseInfo.getSemester())
                .eq(StringUtils.hasText(courseInfo.getYear()), CourseInfo::getYear, courseInfo.getYear())
                .eq(StringUtils.hasText(courseInfo.getStudnetId()), CourseInfo::getStudnetId, courseInfo.getStudnetId())
                .orderByAsc(CourseInfo::getStudnetId));
        List<RebuildInfoVO> rebuildInfoList = new ArrayList<>();
        for (CourseInfo record : rebuildList) {
            int sub1 = Integer.parseInt(record.getLearnYear().substring(0, 4)) + 1;
            int sub2 = Integer.parseInt(record.getLearnYear().substring(5)) + 1;
            String rebuildLearnYear = sub1 + "-" + sub2;
            Major major = majorMapper.selectOne(new LambdaQueryWrapper<Major>().eq(Major::getMajorName, record.getMajorName()));
            TeachingProgram teachingProgram = teachingProgramMapper.selectOne(new LambdaQueryWrapper<TeachingProgram>()
                    .eq(TeachingProgram::getCourseId, record.getCourseCode())
                    .eq(TeachingProgram::getLearnYear, record.getLearnYear())
                    .eq(TeachingProgram::getMajorId, major.getMajorId()));
            String teachCollege = ObjectUtil.isNotNull(teachingProgram) ? teachingProgram.getTeachCollege() : "";
            System.out.println(teachingProgram);
            RebuildInfoVO rebuildInfo = RebuildInfoVO.builder().
                    courseCode(record.getCourseCode())
                    .classesName(record.getCourseName())
                    .collegeName(record.getCollegeName())
                    .cousreSelect(record.getCousreSelect())
                    .score(record.getScore())
                    .learnYear(record.getLearnYear())
                    .studentId(record.getStudnetId())
                    .studnetName(record.getStudentName())
                    .majorName(record.getMajorName())
                    .semester(record.getSemester())
                    .courseName(record.getCourseName())
                    .credit(record.getCredit())
                    .collegeName(record.getCollegeName())
                    .majorName(record.getMajorName())
                    .classesName(record.getClassesName())
                    .teachCollege(teachCollege)
                    .rebuildCourseCode(record.getCourseCode())
                    .rebuildCourseName(record.getCourseName())
                    .rebuildLearnYear(rebuildLearnYear).
                            rebuildSemester(record.getSemester())
                    .enroll("是")
                    .build();
            rebuildInfoList.add(rebuildInfo);
        }
        return rebuildInfoList;
    }

    @Override
    public List getIdS(Map<String, String> map) {
        List<CourseInfo> courseInfos = courseInfoMapper.selectList(new LambdaQueryWrapper<CourseInfo>()
                .like(StringUtils.hasText(map.get("collegeName")), CourseInfo::getCollegeName, map.get("collegeName"))
                .eq(StringUtils.hasText(UrlEncode.decodeParam(map.get("getMajorName"))), CourseInfo::getMajorName,UrlEncode.decodeParam(map.get("getMajorName")))
                .eq(StringUtils.hasText(map.get("classesName")), CourseInfo::getClassesName, map.get("classesName"))
                .like(StringUtils.hasText(map.get("learnYear")), CourseInfo::getLearnYear, map.get("learnYear"))
                .like(StringUtils.hasText(map.get("semester")), CourseInfo::getSemester, map.get("semester"))
                .likeRight(StringUtils.hasText(map.get("year")), CourseInfo::getYear,map.get("year"))
                .eq(StringUtils.hasText(map.get("studentId")), CourseInfo::getStudnetId,map.get("studentId"))
                .lt(CourseInfo::getScore, 60).orderByAsc(CourseInfo::getStudnetId));

        return courseInfos;
    }

    @Override
    public List<CourseInfo> getRebuildIdS(Map<String, String> map) {
        //        String learnYear = RQUtil.getLearnYear();
//        int sub1 = Integer.parseInt(learnYear.substring(0, 4)) + 1;
//        int sub2 = Integer.parseInt(learnYear.substring(5)) + 1;
//        String rebuildLearnYear = sub1 + "-" + sub2;
        String learnYear = "";
        List<CourseInfo> courseInfoList = courseInfoMapper.selectList(new LambdaQueryWrapper<CourseInfo>()
                .eq(CourseInfo::getRebuild, "0")
                .and(courseInfoLambdaQueryWrapper -> {
                    courseInfoLambdaQueryWrapper.eq(CourseInfo::getNotes, "缺考").or().eq(CourseInfo::getNotes, "<=40重修")
                            .or(courseInfoLambdaQueryWrapper1 -> {
                                courseInfoLambdaQueryWrapper1.eq(CourseInfo::getMakeup, "1").
                                        lt(CourseInfo::getScore, 60);
                            })
                            .or().lt(CourseInfo::getScore, 40);
                })
                .like(StringUtils.hasText(map.get("collegeName")), CourseInfo::getCollegeName, map.get("collegeName"))
                .eq(StringUtils.hasText(UrlEncode.decodeParam(map.get("getMajorName"))), CourseInfo::getMajorName, UrlEncode.decodeParam(map.get("getMajorName")))
                .eq(StringUtils.hasText(map.get("classesName")), CourseInfo::getClassesName, map.get("classesName"))
                .eq(StringUtils.hasText(learnYear), CourseInfo::getLearnYear, learnYear)
                .eq(StringUtils.hasText(map.get("semester")), CourseInfo::getSemester,map.get("semester"))
                .eq(StringUtils.hasText(map.get("year")), CourseInfo::getYear, map.get("year"))
                .eq(StringUtils.hasText(map.get("studentId")), CourseInfo::getStudnetId, map.get("studentId"))
                .orderByAsc(CourseInfo::getStudnetId));
        return courseInfoList;
    }
}
