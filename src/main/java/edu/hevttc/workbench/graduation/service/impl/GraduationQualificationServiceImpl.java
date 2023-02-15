package edu.hevttc.workbench.graduation.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.workbench.graduation.mapper.GraduationQualificationMapper;
import edu.hevttc.domain.GraduationQualification;
import edu.hevttc.workbench.graduation.service.GraduationQualificationService;
@Service
public class GraduationQualificationServiceImpl extends ServiceImpl<GraduationQualificationMapper, GraduationQualification> implements GraduationQualificationService{

}
