package edu.hevttc.basic.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.domain.Classes;
import edu.hevttc.basic.mapper.ClassesMapper;
import edu.hevttc.basic.service.ClassesService;
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements ClassesService{

}
