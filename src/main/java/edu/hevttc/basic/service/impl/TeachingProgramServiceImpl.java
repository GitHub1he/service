package edu.hevttc.basic.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.basic.mapper.TeachingProgramMapper;
import edu.hevttc.domain.TeachingProgram;
import edu.hevttc.basic.service.TeachingProgramService;
@Service
public class TeachingProgramServiceImpl extends ServiceImpl<TeachingProgramMapper, TeachingProgram> implements TeachingProgramService{

}
