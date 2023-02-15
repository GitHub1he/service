package edu.hevttc.workbench.notice.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import edu.hevttc.commons.PageBean;
import edu.hevttc.commons.ReturnObject;
import edu.hevttc.domain.Message;
import edu.hevttc.domain.User;
import edu.hevttc.util.UserUtils;
import edu.hevttc.workbench.notice.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Pc.dragon
 * @ClassName MessageController
 * @description: 学生消息
 * @date 2023年02月12日
 * @version: 1.0
 */
@RestController
@Api(tags = "学生消息模块")
@RequestMapping("/Message")
public class MessageController {
    @Resource
    private UserUtils userUtils;
    @Resource
    private MessageService messageService;
    @ApiOperation("获取未读信息个数和总个数")
    @GetMapping("/Counts")
    public ReturnObject getMessageCount(@RequestParam("token") String token, @RequestParam("userRole") String userRole, @RequestParam("userName") String userName) {
        User user = userUtils.getUserByTokenFromRedis(token);
        if (user == null) {
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token, userRole)) {
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        Map<String,Integer> count =messageService.getUnreadeCount(userName);
        if (ObjectUtil.isNotNull(count)){
            return ReturnObject.SUCCESS(count);
        }
        return  ReturnObject.ERROR("服务器出错了");
    }

    @ApiOperation("获取最近三个信息")
    @GetMapping("/threeMessage")
    public ReturnObject getThreeMessage(@RequestParam("token") String token, @RequestParam("userRole") String userRole, @RequestParam("userName") String userName) {
        User user = userUtils.getUserByTokenFromRedis(token);
        if (user == null) {
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token, userRole)) {
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
       List<Message> messageList =messageService.getThreeMessage(userName);
        if (ObjectUtil.isNotNull(messageList)){
            return ReturnObject.SUCCESS(messageList);
        }
        return  ReturnObject.ERROR("服务器出错了");
    }

    @ApiOperation("获取信息列表")
    @GetMapping("/getMessages")
    public ReturnObject getMessages(@RequestParam("token") String token ,@RequestParam("userRole") String userRole ,@RequestParam("userName") String userName,Integer pageNum , Integer pageSize){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        PageBean pageBean =  messageService.getMessages(userName, pageNum ,pageSize);
        if (ObjectUtil.isNotNull(pageBean)){
            return ReturnObject.SUCCESS(pageBean);
        }
        return ReturnObject.ERROR("加载失败");
    }

    @ApiOperation("查看详情")
    @GetMapping("/detail")
    public ReturnObject getMessages(@RequestParam("token") String token ,@RequestParam("userRole") String userRole ,@RequestParam("messageId") String messageId){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        Message one = messageService.getOne(new LambdaQueryWrapper<Message>().eq(Message::getMessageId, messageId));
        if (ObjectUtil.isNotNull(one)){
            return ReturnObject.SUCCESS(one);
        }
        return ReturnObject.ERROR("加载失败");
    }

    @ApiOperation("更新确认")
    @PutMapping("/updateAck")
    public ReturnObject updateAck(@RequestBody Map<String,String> map){
        User user= userUtils.getUserByTokenFromRedis(map.get("token"));
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(map.get("token"),map.get("userRole"))){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        Message one = messageService.getOne(new LambdaQueryWrapper<Message>().eq(Message::getMessageId, map.get("messageId")));
        if (one.getIsAck().equals("0")){
            ReturnObject.ERROR("已确认");
        }
        one.setIsAck("0");
        one.setAckTime(new Date());
        boolean b = messageService.updateById(one);
        if (b){
            return ReturnObject.SUCCESS(one);
        }
        return ReturnObject.ERROR("加载失败");
    }
    @ApiOperation("发送预警提示根据类型判断")
    @PostMapping("/batchAlert")
    public ReturnObject saveCrouseAlert(@RequestBody Map<String,String> map){
        User user= userUtils.getUserByTokenFromRedis(map.get("token"));
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(map.get("token"),map.get("userRole"))){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        String[] alerts = map.get("alerts").split(",");
         String type = map.get("type");
       boolean result= messageService.saveCrouseAlert(map.get("userRole"),alerts,type);
        if (result){
            return ReturnObject.SUCCESS("发布成功");
        }
        return ReturnObject.ERROR("加载失败");
    }

    @ApiOperation("获取未读提醒个数和总个数")
    @GetMapping("/alertCounts")
    public ReturnObject getalertCounts(@RequestParam("token") String token, @RequestParam("userRole") String userRole, @RequestParam("userName") String userName) {
        User user = userUtils.getUserByTokenFromRedis(token);
        if (user == null) {
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token, userRole)) {
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        Map<String,Integer> count =messageService.getAlertCounts(userName);
        if (ObjectUtil.isNotNull(count)){
            return ReturnObject.SUCCESS(count);
        }
        return  ReturnObject.ERROR("服务器出错了");
    }


    @ApiOperation("获取最近三个提醒信息")
    @GetMapping("/threeAlter")
    public ReturnObject getThreeAltere(@RequestParam("token") String token, @RequestParam("userRole") String userRole, @RequestParam("userName") String userName) {
        User user = userUtils.getUserByTokenFromRedis(token);
        if (user == null) {
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token, userRole)) {
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        List<Message> messageList =messageService.getThreeAltere(userName);
        if (ObjectUtil.isNotNull(messageList)){
            return ReturnObject.SUCCESS(messageList);
        }
        return  ReturnObject.ERROR("服务器出错了");
    }

    @ApiOperation("获取警示提醒列表")
    @GetMapping("/getAlert")
    public ReturnObject getAlert(@RequestParam("token") String token ,@RequestParam("userRole") String userRole ,@RequestParam("userName") String userName,Integer pageNum , Integer pageSize){
        User user= userUtils.getUserByTokenFromRedis(token);
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }

        if (userUtils.checkUserRole(token,userRole)){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        PageBean pageBean =  messageService.getAlert(userName, pageNum ,pageSize);
        if (ObjectUtil.isNotNull(pageBean)){
            return ReturnObject.SUCCESS(pageBean);
        }
        return ReturnObject.ERROR("加载失败");
    }
    @ApiOperation("不及格全部预警")
    @PostMapping("/allSend")
    public ReturnObject courseAllSend(@RequestBody Map<String,String> map){
        User user= userUtils.getUserByTokenFromRedis(map.get("token"));
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(map.get("token"),map.get("userRole"))){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        String type = map.get("type");
        boolean result= messageService.courseAllSend(map,type);
        if (result){
            return ReturnObject.SUCCESS("发布成功");
        }
        return ReturnObject.ERROR("发布失败");
    }

    @ApiOperation("重修全部预警")
    @PostMapping("/allSendRebuild")
    public ReturnObject allSendRebuild(@RequestBody Map<String,String> map){
        User user= userUtils.getUserByTokenFromRedis(map.get("token"));
        if(user==null){
            return new ReturnObject(2, "对不起，你还没有登录", null);
        }
        if (userUtils.checkUserRole(map.get("token"),map.get("userRole"))){
            return new ReturnObject(2, "对不起，您没有权限", null);
        }
        String type = map.get("type");
        boolean result= messageService.rebuildAllSend(map,type);
        if (result){
            return ReturnObject.SUCCESS("发布成功");
        }
        return ReturnObject.ERROR("发布失败");
    }
}
