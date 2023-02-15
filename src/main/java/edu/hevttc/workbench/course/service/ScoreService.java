package edu.hevttc.workbench.course.service;

import edu.hevttc.domain.Score;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface ScoreService extends IService<Score>{


 /*   List loadCourseInfoPage(Integer pageNum, Integer pageSize, CourseInfoVo courseInfo);*/

    Map getDicValueAll();
}
