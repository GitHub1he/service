package edu.hevttc.util;

import edu.hevttc.workbench.course.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Pc.dragon
 * @ClassName UpdateInitOptionUtil
 * @description: 更新条件选项
 * @date 2023年02月05日
 * @version: 1.0
 */
@Component
@Slf4j
public class UpdateInitOptionUtil {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ScoreService scoreService;
    @Bean
    public  void updateInitoption(){
        Map dicValueMap=scoreService.getDicValueAll();
        try {
            stringRedisTemplate.opsForHash().putAll("dicValue",dicValueMap);
        } catch (Exception e) {
            log.error("redis出错了");
        }
    }
}
