package edu.hevttc.workbench.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.hevttc.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
