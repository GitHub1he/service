package edu.hevttc.workbench.fileload.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.hevttc.basic.service.*;
import edu.hevttc.commons.PageBean;
import edu.hevttc.commons.ReturnObject;
import edu.hevttc.util.UserUtils;
import edu.hevttc.util.UpdateInitOptionUtil;
import edu.hevttc.workbench.course.service.ScoreService;
import edu.hevttc.domain.*;
import edu.hevttc.workbench.fileload.service.TeachingProgramMajorCreditService;
import edu.hevttc.workbench.fileload.struct.vo.MajorCreditVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Pc.dragon
 * @ClassName fileController
 * @description: 文件上传
 * @date 2023年01月17日
 * @version: 1.0
 */
@Api(tags = "文件上传")
@RestController
@Slf4j
public class FileUploadController {
    @Resource
    private ScoreService scoreService;
    @Resource
    private TeachingProgramService teachingProgramService;
    @Resource
    private PubEleTeaProgramService pubEleTeaProgramService;
    @Resource
    PubEleSprotTeaProgramService pubEleSprotTeaProgramService;
    @Resource
    private StudentService studentService;
    @Resource
    private MajorService majorService;
    @Resource
    private CollegeService collegeService;
    @Resource
    private ClassesService classesService;
    @Resource
    private TeachingProgramMajorCreditService teachingProgramMajorCreditService;
    @Resource
    private UserUtils userUtils;
    @Resource
    private UpdateInitOptionUtil updateInitOptionUtil;


    public FileUploadController(ScoreService scoreService, TeachingProgramService teachingProgramService, PubEleTeaProgramService pubEleTeaProgramService, PubEleSprotTeaProgramService pubEleSprotTeaProgramService, StudentService studentService, MajorService majorService, CollegeService collegeService, ClassesService classesService, TeachingProgramMajorCreditService teachingProgramMajorCreditService) {
        this.scoreService = scoreService;
        this.teachingProgramService = teachingProgramService;
        this.pubEleTeaProgramService = pubEleTeaProgramService;
        this.pubEleSprotTeaProgramService = pubEleSprotTeaProgramService;
        this.studentService = studentService;
        this.majorService = majorService;
        this.collegeService = collegeService;
        this.classesService = classesService;
        this.teachingProgramMajorCreditService = teachingProgramMajorCreditService;
    }

    public FileUploadController() {
    }

    @ApiOperation("学生成绩上传")
    @PostMapping("/upload/score")
    public ReturnObject uploadScoreFile(@RequestParam("file") MultipartFile file ,@RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        ReturnObject returnObject = ReturnObject.ERROR("上传失败，请检查上传数据，请稍后再试");
        InputStream in = null;
        ExcelReader excelReader=null;
        Boolean result =false;
        try {
            //文件处理成io流
            in = file.getInputStream();
            //io流给ExcelReader
            excelReader= ExcelUtil.getReader(in);
            List<Score> scores = excelReader.readAll(Score.class);
            Score existScore = null;
            for (Score score : scores) {
                existScore = null;
                existScore = scoreService.getOne(new LambdaQueryWrapper<Score>().eq(Score::getStudentId, score.getStudentId()
                ).eq(Score::getCourseCode, score.getCourseCode()).eq(Score::getLearnYear, score.getLearnYear()).eq(Score::getSemester, score.getSemester())
                );
                if (ObjectUtil.isNotNull(existScore)){
                    returnObject= ReturnObject.ERROR("存在相同主键的记录"+existScore.getStudnetName()+existScore.getCourseName()+existScore.getCourseName()+existScore.getLearnYear());
                    return ReturnObject.ERROR("");
                }
            }
            result = scoreService.saveBatch(scores);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                excelReader.close();
                if (!result){
                    return returnObject;
                }
                return ReturnObject.SUCCESS("上传成功");
            }

        }
    }
    @ApiOperation("教学任务表上传")
    @PostMapping("/upload/teachingprogram")
    public ReturnObject uploadTeachingProgramFile(@RequestParam("file") MultipartFile file ,@RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        ReturnObject returnObject = ReturnObject.ERROR("上传失败，请检查上传数据，请稍后再试");
        InputStream in = null;
        ExcelReader excelReader=null;
        Boolean result =false;
        try {
            //文件处理成io流
            in = file.getInputStream();
            //io流给ExcelReader
            excelReader= ExcelUtil.getReader(in);
            List<TeachingProgram> teachingPrograms = excelReader.readAll(TeachingProgram.class);
            TeachingProgram teachingProgram = null;
            for (TeachingProgram program : teachingPrograms) {
                teachingProgram=null;
                teachingProgram=teachingProgramService.getOne(new LambdaQueryWrapper<TeachingProgram>().eq(TeachingProgram::getTpId, program.getTpId()));
                if (ObjectUtil.isNotNull(teachingProgram)){
                    returnObject= ReturnObject.ERROR("存在相同主键的记录"+teachingProgram.getTpId());
                    return ReturnObject.ERROR("");
                }
            }
            result = teachingProgramService.saveBatch(teachingPrograms);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                excelReader.close();
                if (!result){
                    return returnObject;
                }

                return ReturnObject.SUCCESS("上传成功");
            }

        }
    }
    @ApiOperation("公选课教学任务表上传")
    @PostMapping("/upload/pub_ele_tea_program")
    public ReturnObject uploadPubEleTeaProgramFile( @RequestParam("file") MultipartFile file ,@RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        ReturnObject returnObject = ReturnObject.ERROR("上传失败，请检查上传数据，请稍后再试");
        InputStream in = null;
        ExcelReader excelReader=null;
        Boolean result =false;
        try {
            //文件处理成io流
            in = file.getInputStream();
            //io流给ExcelReader
            excelReader= ExcelUtil.getReader(in);
            List<PubEleTeaProgram> pubEleTeaProgramList = excelReader.readAll(PubEleTeaProgram.class);
            PubEleTeaProgram existPubEleTeaProgram = null;
            for (PubEleTeaProgram pubEleTeaProgram : pubEleTeaProgramList) {
                existPubEleTeaProgram = null;
                existPubEleTeaProgram = pubEleTeaProgramService.getById(pubEleTeaProgram.getPetpId());
                if (ObjectUtil.isNotNull(existPubEleTeaProgram)) {
                    returnObject= ReturnObject.ERROR("存在相同主键的记录"+existPubEleTeaProgram.getPetpId());
                    return ReturnObject.ERROR("");
                }
            }
            result = pubEleTeaProgramService.saveBatch(pubEleTeaProgramList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                excelReader.close();
                if (!result){
                    return returnObject;
                }
                return ReturnObject.SUCCESS("上传成功");
            }

        }
    }
    @ApiOperation("公共体育课教学任务表上传")
    @PostMapping("/upload/pub_ele_sprot_tea_program")
    public ReturnObject uploadPubEleSportTeaProgramFile( @RequestParam("file") MultipartFile file ,@RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        ReturnObject returnObject = ReturnObject.ERROR("上传失败，请检查上传数据，请稍后再试");
        InputStream in = null;
        ExcelReader excelReader=null;
        Boolean result =false;
        try {
            //文件处理成io流
            in = file.getInputStream();
            //io流给ExcelReader
            excelReader= ExcelUtil.getReader(in);
            List<PubEleSprotTeaProgram> pubEleSprotTeaProgramList = excelReader.readAll(PubEleSprotTeaProgram.class);
            PubEleSprotTeaProgram existPubEleSprotTeaProgram = null;
            for (PubEleSprotTeaProgram pubEleSprotTeaProgram : pubEleSprotTeaProgramList) {
                existPubEleSprotTeaProgram = null;
                existPubEleSprotTeaProgram = pubEleSprotTeaProgramService.getById(pubEleSprotTeaProgram.getPestpId());
                if (ObjectUtil.isNotNull(existPubEleSprotTeaProgram)){
                    returnObject= ReturnObject.ERROR("存在相同主键的记录"+existPubEleSprotTeaProgram.getPestpId());
                    return ReturnObject.ERROR("");
                }
            }
            result = pubEleSprotTeaProgramService.saveBatch(pubEleSprotTeaProgramList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                excelReader.close();
                if (!result){
                    return returnObject;
                }
                return ReturnObject.SUCCESS("上传成功");
            }

        }
    }
    @ApiOperation("学生基本信息表上传")
    @PostMapping("/upload/student")
    public ReturnObject uploadStudentFile( @RequestParam("file") MultipartFile file ,@RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        ReturnObject returnObject = ReturnObject.ERROR("上传失败，请检查上传数据，请稍后再试");
        InputStream in = null;
        ExcelReader excelReader=null;
        Boolean result =false;
        try {
            //文件处理成io流
            in = file.getInputStream();
            //io流给ExcelReader
            excelReader= ExcelUtil.getReader(in);
            List<Student>  studentList = excelReader.readAll(Student.class);
            Student existStudent = null;
            for (Student student : studentList) {
                existStudent = null;
                existStudent= studentService.getById(student.getStudnetId());
                if (ObjectUtil.isNotNull(existStudent)){
                    returnObject= ReturnObject.ERROR("存在相同主键的记录"+existStudent.getStudentName());
                    return ReturnObject.ERROR("");
                }
            }
            result = studentService.saveBatch(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                excelReader.close();
                if (!result){
                    return returnObject;
                }
                return ReturnObject.SUCCESS("上传成功");
            }

        }
    }
    @ApiOperation("专业代码表上传")
    @PostMapping("/upload/major")
    public ReturnObject uploadMajorFile( @RequestParam("file") MultipartFile file ,@RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        ReturnObject returnObject = ReturnObject.ERROR("上传失败，请检查上传数据，请稍后再试");
        InputStream in = null;
        ExcelReader excelReader=null;
        Boolean result =false;
        try {
            //文件处理成io流
            in = file.getInputStream();
            //io流给ExcelReader
            excelReader= ExcelUtil.getReader(in);
            List<Major> majorList = excelReader.readAll(Major.class);
            Major existMajor = null;
            for (Major major : majorList) {
                existMajor =null;
                existMajor = majorService.getById(major.getMajorId());
                if (ObjectUtil.isNotNull(existMajor)){
                    returnObject= ReturnObject.ERROR("存在相同主键的记录"+existMajor.getMajorName());
                    return ReturnObject.ERROR("");
                }
            }
            result = majorService.saveBatch(majorList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                excelReader.close();
                if (!result){
                    return returnObject;
                }
               updateInitOptionUtil.updateInitoption();
                return ReturnObject.SUCCESS("上传成功");
            }
        }
    }
    @ApiOperation("学院代码表上传")
    @PostMapping("/upload/colleges")
    public ReturnObject uploadCollegeFile( @RequestParam("file") MultipartFile file ,@RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        ReturnObject returnObject = ReturnObject.ERROR("上传失败，请检查上传数据，请稍后再试");
        InputStream in = null;
        ExcelReader excelReader=null;
        Boolean result =false;
        try {
            //文件处理成io流
            in = file.getInputStream();
            //io流给ExcelReader
            excelReader= ExcelUtil.getReader(in);
            List<College> colleges = excelReader.readAll(College.class);
            College existCollege = null;
            for (College college : colleges) {
                existCollege =null;
                existCollege = collegeService.getById(college.getCollegeId());
                if (ObjectUtil.isNotNull(existCollege)){
                    returnObject= ReturnObject.ERROR("存在相同主键的记录"+existCollege.getCollegeName());
                    return ReturnObject.ERROR("");
                }
            }
            result = collegeService.saveBatch(colleges);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                excelReader.close();
                if (!result){
                    return returnObject;
                }
                updateInitOptionUtil.updateInitoption(); //更新redis缓存
                return ReturnObject.SUCCESS("上传成功");
            }
        }
    }
    @ApiOperation("行政班代码表上传")
    @PostMapping("/upload/classes")
    public ReturnObject uploadClassesFile( @RequestParam("file") MultipartFile file ,@RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        ReturnObject returnObject = ReturnObject.ERROR("上传失败，请检查上传数据，请稍后再试");
        InputStream in = null;
        ExcelReader excelReader=null;
        Boolean result =false;
        try {
            //文件处理成io流
            in = file.getInputStream();
            //io流给ExcelReader
            excelReader= ExcelUtil.getReader(in);
            List<Classes> classesList = excelReader.readAll(Classes.class);
            Classes existClasses = null;
            for (Classes classes: classesList) {
                existClasses=null;
                existClasses = classesService.getById(classes.getClassesId());
                if (ObjectUtil.isNotNull(existClasses)){
                    returnObject= ReturnObject.ERROR("存在相同主键的记录"+existClasses.getClassesName());
                    return ReturnObject.ERROR("");
                }
            }
            result = classesService.saveBatch(classesList);
            scoreService.getDicValueAll();//更新查询条件信息缓存
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                excelReader.close();
                if (!result){
                    return returnObject;
                }
                updateInitOptionUtil.updateInitoption();
                return ReturnObject.SUCCESS("上传成功");
            }
        }
    }
    @ApiOperation("教学计划专业信息表(学分结构表)上传")
    @PostMapping("/upload/teaching_program_major_credit")
    public ReturnObject uploadTeachingProgramMajorCreditFile(@RequestParam("file") MultipartFile file ,@RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        ReturnObject returnObject = ReturnObject.ERROR("上传失败，请检查上传数据，请稍后再试");
        InputStream in = null;
        ExcelReader excelReader=null;
        Boolean result =false;
        try {
            //文件处理成io流
            in = file.getInputStream();
            //io流给ExcelReader
            excelReader= ExcelUtil.getReader(in);
            List<TeachingProgramMajorCredit> teachingProgramMajorCreditList = excelReader.readAll(TeachingProgramMajorCredit.class);
            TeachingProgramMajorCredit exist = null;
            for (TeachingProgramMajorCredit teachingProgramMajorCredit : teachingProgramMajorCreditList) {
                exist = null;
                exist = teachingProgramMajorCreditService.getById(teachingProgramMajorCredit.getTpmId());
                if (ObjectUtil.isNotNull(exist)){
                    returnObject= ReturnObject.ERROR("存在相同主键的记录"+exist.getTpmId());
                    return ReturnObject.ERROR("");
                }
            }
            result = teachingProgramMajorCreditService.saveBatch(teachingProgramMajorCreditList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                excelReader.close();
                if (!result){
                    return returnObject;
                }
                return ReturnObject.SUCCESS("上传成功");
            }
        }
    }

    @ApiOperation("分页加载学分结构列表")
    @GetMapping("/file/page")
    public ReturnObject loadCourseInfoPage(Integer pageNum , Integer pageSize,String collegeCode, String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
       PageBean pageBean=teachingProgramMajorCreditService.loadMajorCreditPage(pageNum,pageSize,collegeCode);
        return ReturnObject.SUCCESS(pageBean);
    }
    @ApiOperation("获取修改的学分结构实体")
    @GetMapping("/majorcredit/toUpdate")
    public ReturnObject getMajorCreditById(@RequestParam("id") String id , @RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        TeachingProgramMajorCredit majorCredit = teachingProgramMajorCreditService.getById(id);
        String majorId = id.substring(4);
        Major major = majorService.getById(majorId);
        MajorCreditVO majorCreditVO = MajorCreditVO.builder().majorId(majorCredit.getMajorId())
                .majorName(major.getMajorName())
                .praTeachingCredit(majorCredit.getPraTeachingCredit())
                .proCoreCredit(majorCredit.getProCoreCredit())
                .proBasCredit(majorCredit.getProBasCredit())
                .proEleCredit(majorCredit.getProEleCredit())
                .proLimCredit(majorCredit.getProLimCredit())
                .pubGenCredit(majorCredit.getPubGenCredit())
                .pubEleCredit(majorCredit.getPubEleCredit())
                .tpmId(majorCredit.getTpmId())
                .year(majorCredit.getYear())
                .sumCredit(majorCredit.getSumCredit())
                .build();
        return ReturnObject.SUCCESS(majorCreditVO);
    }

    @ApiOperation("修改学分结构")
    @PostMapping("/majorcredit/Update")
    public ReturnObject updateBytmpId(@RequestBody TeachingProgramMajorCredit teachingProgramMajorCredit, @RequestParam("token") String token, @RequestParam("userRole") String userRole){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        System.out.println(teachingProgramMajorCredit);
        ReturnObject returnObject =ReturnObject.ERROR("保存失败，请稍后再试");
        boolean b = false;
        try {
          b = teachingProgramMajorCreditService.updateById(teachingProgramMajorCredit);
        } catch (Exception e) {
           log.error("保存失败");
        }
        if (b){
            return  ReturnObject.SUCCESS("保存成功");
        }
        return returnObject;
    }
}
