package edu.hevttc.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.hevttc.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
