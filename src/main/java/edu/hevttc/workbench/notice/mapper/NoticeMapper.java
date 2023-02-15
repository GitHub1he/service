package edu.hevttc.workbench.notice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.hevttc.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {
}