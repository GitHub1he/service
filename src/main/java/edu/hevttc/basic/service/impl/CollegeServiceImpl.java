package edu.hevttc.basic.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.basic.mapper.CollegeMapper;
import edu.hevttc.domain.College;
import edu.hevttc.basic.service.CollegeService;
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements CollegeService{

}
