package edu.hevttc.listener;


import edu.hevttc.workbench.course.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

/**
 * 定义应用监听器，可以在Tomcat启动和关闭时自动执行
 * 注意：当前类需要定义到Spring应用上下文容器中
 */
@Component
@Slf4j
public class IntiDicValueListener implements ServletContextListener {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ScoreService scoreService;
    /**
     * Tomcat启动时会自动触发用于初始化一些数据，例如初始化数据字典值到缓存中
     *
     */
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("-----Tomcat启动了-----");
        Map dicValueMap=scoreService.getDicValueAll();
        try {
            stringRedisTemplate.delete("dicValue");
            stringRedisTemplate.opsForHash().putAll("dicValue",dicValueMap);
        } catch (Exception e) {
           log.error("redis出错了");
        }
    }

    /**
     * 当Tomcat关闭时会自动触发（正常关闭，调用Tomcat的shutdown命令）
     * @param
     */
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("=====Tomcat关闭了=====");
    }
}
