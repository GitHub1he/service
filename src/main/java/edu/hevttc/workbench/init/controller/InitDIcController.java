package edu.hevttc.workbench.init.controller;

import com.alibaba.fastjson.JSONObject;
import edu.hevttc.commons.ReturnObject;
import edu.hevttc.domain.User;
import edu.hevttc.util.UserUtils;
import edu.hevttc.workbench.course.struct.vo.InitOption;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pc.dragon
 * @ClassName InitDIcController
 * @description: 初始化查询条件
 * @date 2023年02月08日
 * @version: 1.0
 */
@RestController
@Api(tags = "初始化查询条件")
@RequestMapping("/init")
public class InitDIcController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private UserUtils userUtils;
    @ApiOperation("初始化条件查询选项")
    @GetMapping("/initDic")
    public Object getDivValueByTypeCodeFromRedis(@RequestParam("token") String token , @RequestParam("userRole") String userRole , String typeCodes){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        //将条件值的TypeCode按照逗号分割成数组
        String typeCodeArr[]=typeCodes.split(",");
        //定义Map集合用于最终封装所有需要的字典值
        Map map=new HashMap();
        //循环所有的TypeCode
        for(String typeCode:typeCodeArr){
            //根据具体TypeCode到Redis中获取对应的字典值
            Object obj= stringRedisTemplate.opsForHash().get("dicValue",typeCode);
            if (typeCode.equals("initOption")) {

                map.put(typeCode,  JSONObject.parseObject( stringRedisTemplate.opsForHash().get("dicValue", typeCode).toString(), InitOption.class));
                break;
            }
            //将获取到的Json数组格式的字典值字符串转换成对应类型的List集合中存入Map集合
            map.put(typeCode, JSONObject.parseArray(obj.toString(), String.class));
        }
        return ReturnObject.SUCCESS(map);
    }
}
