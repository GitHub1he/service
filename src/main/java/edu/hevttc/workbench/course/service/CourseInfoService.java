package edu.hevttc.workbench.course.service;

import edu.hevttc.commons.PageBean;
import edu.hevttc.workbench.course.domain.CourseInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.hevttc.workbench.course.struct.vo.CourseInfoVo;
import edu.hevttc.workbench.course.struct.vo.RebuildInfoVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface CourseInfoService extends IService<CourseInfo>{


    PageBean loadCourseInfoPage(Integer pageNum, Integer pageSize, CourseInfo courseInfo);

    PageBean loadRebuildInfoPage(Integer pageNum, Integer pageSize, CourseInfo courseInfo);

    List<CourseInfoVo> allExprot(CourseInfo courseInfo);

    List<RebuildInfoVO> allRebuidExprot(CourseInfo courseInfo);

    List getIdS(Map<String, String> map);

    List<CourseInfo> getRebuildIdS(Map<String, String> map);
}
