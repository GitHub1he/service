package edu.hevttc.workbench.course.controller;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import edu.hevttc.commons.BusinessException;
import edu.hevttc.commons.PageBean;
import edu.hevttc.commons.ReturnObject;
import edu.hevttc.domain.User;
import edu.hevttc.util.UserUtils;
import edu.hevttc.workbench.course.domain.CourseInfo;
import edu.hevttc.workbench.course.service.CourseInfoService;
import edu.hevttc.workbench.course.service.ScoreService;
import edu.hevttc.util.UrlEncode;
import edu.hevttc.workbench.course.struct.vo.CourseInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author Pc.dragon
 * @ClassName controller
 * @description: 课程预警模块
 * @date 2023年01月30日
 * @version: 1.0
 */
@Api(tags = "课程预警模块")
@RestController
@RequestMapping("/course")
public class CourseController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ScoreService scoreService;
    @Resource
    private CourseInfoService courseinfoService ;
    @Resource
    private UserUtils userUtils;


    @ApiOperation("分页加载学生成绩列表")
    @GetMapping("/page")
    public ReturnObject loadCourseInfoPage(Integer pageNum , Integer pageSize,
                                           String  collegeName, String majorName ,
                                           String classesName, String learnYear , String semester,
                                           String year,String studentId,String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        majorName = UrlEncode.decodeParam(majorName);
        classesName = UrlEncode.decodeParam(classesName);
        CourseInfo courseInfo = CourseInfo.builder().
                collegeName(collegeName).
                majorName(majorName).
                classesName(classesName).
                learnYear(learnYear).
                year(year)
                .studnetId(studentId)
                .semester(semester).build();
        PageBean pageBean=courseinfoService.loadCourseInfoPage(pageNum,pageSize,courseInfo);
        return ReturnObject.SUCCESS(pageBean);
    }

    @ApiOperation("全部导出学生成绩列表")
    @GetMapping("/export")
    public void allExprot(String  collegeName, String majorName ,
                               String classesName, String learnYear , String semester,
                               String year, String studentId, String token, @RequestParam("userRole") String userRole, HttpServletResponse response){
       User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
           throw new BusinessException();
        }
        if (userUtils.checkUserRole(token,userRole)){
            throw new BusinessException();
        }
        majorName = UrlEncode.decodeParam(majorName);
        classesName = UrlEncode.decodeParam(classesName);
        CourseInfo courseInfo = CourseInfo.builder().
                collegeName(collegeName).
                majorName(majorName).
                classesName(classesName).
                learnYear(learnYear).
                year(year)
                .studnetId(studentId)
                .semester(semester).build();
       List<CourseInfoVo> courseInfoVoList = courseinfoService.allExprot(courseInfo);
        if (ObjectUtil.isNotNull(courseInfoVoList)&& courseInfoVoList.size() != 0){

            // 设置浏览器响应的格式
            try {
                response.setContentType("application/vnd.ms-excel");
                response.setCharacterEncoding("utf-8");
                response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
                response.setHeader("Content-disposition",
                        "attachment;filename*=utf-8''" + URLEncoder.encode("重修信息表", "UTF-8") + ".xlsx");
                ExcelWriter writer = ExcelUtil.getWriter(true);
                writer.addHeaderAlias("learnYear", "学年");
                writer.addHeaderAlias("semester", "学期");
                writer.addHeaderAlias("studentId", "学号");
                writer.addHeaderAlias("studnetName", "姓名");
                writer.addHeaderAlias("courseName", "课程名称");
                writer.addHeaderAlias("courseCode", "课程代码");
                writer.addHeaderAlias("score", "分数");
                writer.addHeaderAlias("credit", "学分");
                writer.addHeaderAlias("rebuild", "是否重修");
                writer.addHeaderAlias("cousreSelect", "课程性质");
                writer.addHeaderAlias("makeup", "是否补考");
                writer.addHeaderAlias("collegeName", "学院");
                writer.addHeaderAlias("classesName", "班级");
                writer.addHeaderAlias("majorName", "专业名称");
                writer.addHeaderAlias("failInfo", "不及格信息");

                writer.write(courseInfoVoList, true);
                ServletOutputStream out = response.getOutputStream();
                writer.flush(out, true);
                out.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            throw new BusinessException();

        }

    }
}
