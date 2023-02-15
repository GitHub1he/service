package edu.hevttc.workbench.user.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.hevttc.commons.ReturnObject;
import edu.hevttc.domain.User;
import edu.hevttc.workbench.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Pc.dragon
 * @ClassName LoginController
 * @description: 登录
 * @date 2023年01月15日
 * @version: 1.0
 */
@Api(tags = "登录模块")
@RestController
public class LoginController {
    @Resource
    private UserService userService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @ApiOperation("登录")
    @PostMapping("/login")
    public ReturnObject login(@RequestBody  User user) {

        Integer result = 0;
        User userResult = userService.getOne(new LambdaQueryWrapper<User>().
                eq(User::getUserName, user.getUserName()).
                eq(User::getUserPwd, user.getUserPwd()));
        if (ObjectUtil.isEmpty(userResult)) {
            result = 1;
        } else if (StringUtils.hasText(user.getUserRole())) {
            if (!userResult.getUserRole().equals(user.getUserRole())) {
                result = 2;
            }
        }
        switch (result) {
            case 1:
                return ReturnObject.ERROR("error!(账户|密码 有误)");
            case 2:
                return ReturnObject.ERROR("error!(权限有误)");
        }
        String token = UUID.randomUUID().toString();
        Map<String,String> sessData = new HashMap<String,String>();
        sessData.put("userSession", JSONUtil.toJsonStr(user));
        try {
            stringRedisTemplate.opsForHash().putAll("sessId:"+token,sessData);
            stringRedisTemplate.expire("sessId:"+token, Duration.ofSeconds(60*30));
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnObject.ERROR("服务器出错了");
        }
        userResult.setToken(token);
        return ReturnObject.SUCCESS(userResult);
    }
}
