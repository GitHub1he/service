package edu.hevttc.util;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.hevttc.domain.User;
import edu.hevttc.workbench.user.service.UserService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.Duration;

@Component
public class UserUtils {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private UserService userService;

    /**
     * 根据请求中携带的Token 到Redis中获取用户信息，
     * 如果有则表示当前用户有登录状态
     * 如果没有则表示当前用户没有登录状态(用户没有登录)
     * @param token 请求中携带的Token
     * @return 用户对象如果返回null则表示当前用户没有登录状态需要登录
     */
    public User getUserByTokenFromRedis(String token){
        //当用户有操作时更新Redis中的用户Session的超时时间 ,返回boolean 类型
       Boolean flag=  stringRedisTemplate.expire("sessId:"+token, Duration.ofSeconds(60*30));
       //进入if表示设置Key的超时失败原因key不存在证明用户没有登录状态
       if(!flag){
           return null;
       }
        //根据前段携带的Token，到Redis中获取用户数据
       String userJson= (String) stringRedisTemplate.opsForHash().get("sessId:"+token,"userSession");
       //进入if表示没有登录状态
       if(userJson==null){
           return null;
       }
       //将用户Json转换成User对象
       return JSONObject.parseObject(userJson,User.class);
    }
    public boolean checkUserRole(String token ,String userRole){
        if (!StringUtils.hasText(userRole)){
            return true;
        }
        //当用户有操作时更新Redis中的用户Session的超时时间 ,返回boolean 类型
        Boolean flag=  stringRedisTemplate.expire("sessId:"+token, Duration.ofSeconds(60*30));
        //进入if表示设置Key的超时失败原因key不存在证明用户没有登录状态
        if(!flag){
            return true;
        }
        //根据前段携带的Token，到Redis中获取用户数据
        String userJson= (String) stringRedisTemplate.opsForHash().get("sessId:"+token,"userSession");
        //进入if表示没有登录状态
        if(userJson==null){
            return true;
        }
        User one = JSONObject.parseObject(userJson,User.class);
        if (!one.getUserRole().equals(userRole)){
            return true;
        }
        return false;
    }
}
