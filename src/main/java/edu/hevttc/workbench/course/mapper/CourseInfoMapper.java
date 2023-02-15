package edu.hevttc.workbench.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.hevttc.workbench.course.domain.CourseInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseInfoMapper extends BaseMapper<CourseInfo> {
}
