package edu.hevttc.workbench.notice.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.hevttc.commons.PageBean;
import edu.hevttc.commons.ReturnObject;
import edu.hevttc.domain.Notice;
import edu.hevttc.domain.User;
import edu.hevttc.util.UrlEncode;
import edu.hevttc.util.UserUtils;
import edu.hevttc.workbench.notice.VO.NoticeVO;
import edu.hevttc.workbench.notice.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author Pc.dragon
 * @ClassName NoticeController
 * @description: 消息推动
 * @date 2023年02月09日
 * @version: 1.0
 */
@Api(tags = "消息推送模块")
@RestController
@RequestMapping("/notice")
@Slf4j
public class NoticeController {
    @Resource
    private NoticeService noticeService;
    @Resource
    private UserUtils userUtils;
    @Resource
    private UrlEncode urlEncode;

    @ApiOperation("添加推送信息")
    @PostMapping("/add")
    public ReturnObject saveNotice(@RequestBody Notice notice, @RequestParam("token") String token , @RequestParam("onlyId") boolean onlyId){
        log.info(notice.toString());

      User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token,notice.getUrole())){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        ReturnObject save = ReturnObject.ERROR("发布失败");

            notice.setCautionMajor(UrlEncode.decodeParam(notice.getCautionMajor()));
            notice.setReleaseTime(new DateTime());
            save = noticeService.savePubishMessage(notice,onlyId);


        return save;
    }
    @ApiOperation("首页加载更新信息")
    @GetMapping("/home")
    public ReturnObject homePage(@RequestParam("token") String token ,@RequestParam("userRole") String userRole ,Integer pageNum , Integer pageSize){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
       PageBean pageBean =  noticeService.getPage(userRole, pageNum ,pageSize);
        if (ObjectUtil.isNotNull(pageBean)){
            return ReturnObject.SUCCESS(pageBean);
        }
        return ReturnObject.ERROR("加载失败");
    }

    @ApiOperation("展示notice详情")
    @GetMapping("/detail")
    public ReturnObject homePage(@RequestParam("token") String token ,@RequestParam("noticeId") String noticeId ){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        NoticeVO notice = noticeService.getNoticeById(noticeId);
        if (ObjectUtil.isNotNull(notice)){
            return ReturnObject.SUCCESS(notice);
        }
        return ReturnObject.ERROR("加载失败");
    }
    @ApiOperation("已发送信息")
    @GetMapping("/getNotices")
    public ReturnObject getNotices(@RequestParam("token") String token ,@RequestParam("userRole") String userRole ,@RequestParam("userName") String userName,Integer pageNum , Integer pageSize){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        PageBean pageBean =  noticeService.getNotices(userRole,userName, pageNum ,pageSize);
        if (ObjectUtil.isNotNull(pageBean)){
            return ReturnObject.SUCCESS(pageBean);
        }
        return ReturnObject.ERROR("加载失败");
    }
    @ApiOperation("删除已发送信息")
    @DeleteMapping("/batchDeleteNotice")
    public ReturnObject batchDeleteNotice(@RequestParam("token") String token ,@RequestParam("userRole") String userRole ,@RequestParam("ids") String ids){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        String[] arrayId = ids.split(",");
        boolean result = noticeService.removeBatchByIds(Arrays.asList(arrayId));
        if (result){
            return ReturnObject.SUCCESS("删除成功");
        }
        return ReturnObject.ERROR("删除失败");
    }
}
