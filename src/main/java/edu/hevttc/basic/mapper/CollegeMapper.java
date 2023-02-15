package edu.hevttc.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.hevttc.domain.College;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollegeMapper extends BaseMapper<College> {
}
