package edu.hevttc.workbench.notice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.hevttc.domain.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}