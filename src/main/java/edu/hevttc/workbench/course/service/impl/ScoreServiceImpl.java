package edu.hevttc.workbench.course.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.hevttc.basic.mapper.ClassesMapper;
import edu.hevttc.basic.mapper.CollegeMapper;
import edu.hevttc.basic.mapper.MajorMapper;
import edu.hevttc.domain.*;
import edu.hevttc.workbench.course.struct.vo.ClassesVO;
import edu.hevttc.workbench.course.struct.vo.CollegeVO;
import edu.hevttc.workbench.course.struct.vo.InitOption;
import edu.hevttc.workbench.course.struct.vo.MajorVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.workbench.course.mapper.ScoreMapper;
import edu.hevttc.workbench.course.service.ScoreService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {
    @Resource
    private  ScoreMapper scoreMapper;
    @Resource
    private CollegeMapper collegeMapper;
    @Resource
    private MajorMapper majorMapper;
    @Resource
    private ClassesMapper classesMapper;


    /*@Override
    public List loadCourseInfoPage(Integer pageNum, Integer pageSize, CourseInfoVo courseInfo) {
        *//*Integer totalNum = activityMapper.selectCount(activityName,ownerName,startDate,endDate);
        PageBean<Map> pageBean = new PageBean<>(pageNum,totalNum,pageSize);
        List<Map> list = activityMapper.selectLimit(pageBean.getSkipNum(),pageBean.getPageSize(),activityName,ownerName,startDate,endDate);
        pageBean.setPageData(list);*//*
        List<Student> studentList = studentMapper.selectList(new LambdaQueryWrapper<Student>().like(StringUtils.hasText(courseInfo.getCollegeName()), Student::getCollegeName, courseInfo.getCollegeName())
                .like(StringUtils.hasText(courseInfo.getMajorName()), Student::getMajorName, courseInfo.getMajorName())
                .like(StringUtils.hasText(courseInfo.getClassesName()), Student::getClassesName, courseInfo.getClassesName()));

        List<String> collect = studentList.stream().map(Student::getStudnetId).collect(Collectors.toList());
        List<Score> scores = scoreMapper.selectList(new LambdaQueryWrapper<Score>().in(ObjectUtil.isNotEmpty(collect), Score::getStudentId, collect).
                like(StringUtils.hasText(courseInfo.getLearnYear()), Score::getLearnYear, courseInfo.getLearnYear())
                .like(StringUtils.hasText(courseInfo.getSemester()), Score::getSemester, courseInfo.getSemester()).lt(Score::getScore, 60));
        Integer totalNum = scores.size();
        List<CourseInfoVo>  courseInfoList= new ArrayList<>();
        for (Score score1 : scores) {
            Student student = studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getStudnetId, score1.getStudentId()));
            String failInfo ="";
            if (score1.getMakeup().equals("1")){
                failInfo = "补考未通过待转重修";
            }
            else if(score1.getRebuild().equals("1")){
                failInfo ="重修未通过";
            }
            else if (score1.getScore() >= 40){
                failInfo = "待补考";
            }else {
                failInfo = "待重修";
            }
            CourseInfoVo courseInfo1 = CourseInfoVo.builder().
                    courseCode(score1.getCourseCode())
                    .classesName(score1.getCourseName())
                    .collegeName(courseInfo.getCollegeName())
                    .cousreSelect(score1.getCousreSelect())
                    .score(score1.getScore())
                    .learnYear(score1.getLearnYear())
                    .studentId(score1.getStudentId())
                    .studnetName(score1.getStudnetName())
                    .majorName(courseInfo.getMajorName())
                    .rebuild(score1.getRebuild())
                    .makeup(score1.getMakeup())
                    .semester(score1.getSemester())
                    .courseName(score1.getCourseName())
                    .credit(score1.getCredit())
                    .collegeName(student.getCollegeName())
                    .majorName(student.getMajorName())
                    .classesName(student.getClassesName())
                    .failInfo(failInfo)
                    .build();
            courseInfoList.add(courseInfo1);
        }
        return courseInfoList;
    }*/

    @Override
    public Map getDicValueAll() {
        List<College> colleges = collegeMapper.selectList(null);
        List<String> collegeNames = colleges.stream().map(College::getCollegeName).collect(Collectors.toList());
        List<Classes> classesList = classesMapper.selectList(null);
        List<String> ClassesNames = classesList.stream().map(Classes::getClassesName).collect(Collectors.toList());
        List<Major> majorList = majorMapper.selectList(null);
        List<String> majorNames = majorList.stream().map(Major::getMajorName).collect(Collectors.toList());
        List<Score> scores = scoreMapper.selectList(null);
        List<String> learnYears = scores.stream().map(Score::getLearnYear).distinct().collect(Collectors.toList());
        List<String> year = classesList.stream().map(Classes::getYear).distinct().collect(Collectors.toList());
        Map map = new HashMap();
        InitOption initOption = new InitOption();
        List<CollegeVO> collegeVOList = new ArrayList<>();
        for (College college : colleges) {
            CollegeVO collegeVO = new CollegeVO ();
            collegeVO.setCollegeId(college.getCollegeId());
            collegeVO.setCollegeName(college.getCollegeName());
            List<Major> majors = majorMapper.selectList(new LambdaQueryWrapper<Major>().eq(Major::getCollegeId, college.getCollegeId()));
            List<MajorVO> majorVOList = new ArrayList<>();
            for (Major major : majors) {
                MajorVO majorVO = new MajorVO();
                majorVO.setMajorId(major.getMajorId());
                majorVO.setMajorName(major.getMajorName());
                majorVO.setCollegeId(college.getCollegeId());
                List<ClassesVO> classesVOList = new ArrayList<>();
                List<Classes> classesList1 = classesMapper.selectList(new LambdaQueryWrapper<Classes>().eq(Classes::getMajorId, major.getMajorId()));
                for (Classes classes : classesList1) {
                    ClassesVO classesVO = new ClassesVO();
                    classesVO.setClassesId(classes.getClassesId());
                    classesVO.setClassesName(classes.getClassesName());
                    classesVO.setMajorId(major.getMajorId());
                    classesVO.setYear(classes.getYear());
                    classesVOList.add(classesVO);
                }
                majorVO.setClassesVOList(classesVOList);
                majorVOList.add(majorVO);
            }
            collegeVO.setMajorVOList(majorVOList);
            collegeVOList.add(collegeVO);
        }
        initOption.setCollegeVOList(collegeVOList);
        map.put("initOption", JSONObject.toJSONString(initOption));
        map.put("collegeNames", JSONObject.toJSONString(collegeNames));
        map.put("classesNames",JSONObject.toJSONString(ClassesNames));
        map.put("majorNames",JSONObject.toJSONString(majorNames));
        map.put("learnYears",JSONObject.toJSONString(learnYears));
        map.put("year",JSONObject.toJSONString(year));
        return map;
    }
}
