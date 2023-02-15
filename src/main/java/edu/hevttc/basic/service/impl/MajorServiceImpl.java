package edu.hevttc.basic.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.domain.Major;
import edu.hevttc.basic.mapper.MajorMapper;
import edu.hevttc.basic.service.MajorService;
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService{

}
