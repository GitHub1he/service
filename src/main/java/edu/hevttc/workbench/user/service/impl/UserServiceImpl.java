package edu.hevttc.workbench.user.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.workbench.user.mapper.UserMapper;
import edu.hevttc.domain.User;
import edu.hevttc.workbench.user.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
