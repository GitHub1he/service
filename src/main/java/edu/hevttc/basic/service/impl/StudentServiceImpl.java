package edu.hevttc.basic.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.basic.mapper.StudentMapper;
import edu.hevttc.domain.Student;
import edu.hevttc.basic.service.StudentService;
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService{

}
