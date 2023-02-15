package edu.hevttc.workbench.notice.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.hevttc.basic.mapper.StudentMapper;
import edu.hevttc.commons.BusinessException;
import edu.hevttc.commons.PageBean;
import edu.hevttc.domain.Notice;
import edu.hevttc.domain.Student;
import edu.hevttc.workbench.course.domain.CourseInfo;
import edu.hevttc.workbench.course.service.CourseInfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.domain.Message;
import edu.hevttc.workbench.notice.mapper.MessageMapper;
import edu.hevttc.workbench.notice.service.MessageService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService{
@Resource
private MessageMapper messageMapper;
@Resource
private StudentMapper studentMapper;
@Resource
private   CourseInfoService courseInfoService;
    @Override
    public Integer saveMessage(Notice notice, boolean onlyId) {
        Integer insertMessage= 0;

        Message message = null;
        if (onlyId) {
            String studentIds[]=notice.getCautionStudent().split(",");
            for (String studentId : studentIds) {
                message = Message.builder()
                        .studentId(studentId)
                        .noticeId(notice.getId())
                        .publisher(notice.getUrole())
                        .title(notice.getTitle())
                        .content(notice.getContent())
                        .releaseTime(notice.getReleaseTime())
                        .isAck(notice.getIsAck().equals("1") ? "1" : "0")
                        .messageType("0")
                        .build();
                insertMessage = messageMapper.insert(message);
            }
        } else {
            List<Student> studentList = studentMapper.selectList(new LambdaQueryWrapper<Student>()
                    .eq(StringUtils.hasText(notice.getCautionCollege()), Student::getCollegeName, notice.getCautionCollege())
                    .eq(StringUtils.hasText(notice.getCautionMajor()), Student::getMajorName, notice.getCautionMajor())
                    .eq(StringUtils.hasText(notice.getCautionClass()), Student::getClassesName, notice.getCautionClass())
                    .likeRight(StringUtils.hasText(notice.getCautionYear()), Student::getYear, notice.getCautionYear()));
            List<String> ids = studentList.stream().map(Student::getStudnetId).collect(Collectors.toList());

            if (ObjectUtil.isNotNull(ids) && ObjectUtil.isNotEmpty(ids)) {
                for (String id : ids) {
                    message = Message.builder()
                            .studentId(id)
                            .noticeId(notice.getId())
                            .publisher(notice.getUrole())
                            .title(notice.getTitle())
                            .content(notice.getContent())
                            .releaseTime(notice.getReleaseTime())
                            .isAck(notice.getIsAck().equals("1") ? "1" : "0")
                            .messageType("0")
                            .build();
                    insertMessage = messageMapper.insert(message);
                }

            }
        }

        return insertMessage;
    }

    @Override
    public Map<String,Integer> getUnreadeCount(String userName) {
       Integer unReadeCount = Math.toIntExact(messageMapper.selectCount(new LambdaQueryWrapper<Message>().eq(Message::getStudentId, userName).eq(Message::getMessageType,"0").eq(Message::getIsAck, "1")));
       Integer counts = Math.toIntExact(messageMapper.selectCount(new LambdaQueryWrapper<Message>().eq(Message::getStudentId, userName).eq(Message::getMessageType,"0")));
        Map<String,Integer> count = new HashMap<>();
        count.put("unReadeCount",unReadeCount);
        count.put("counts",counts);
        return count;
    }

    @Override
    public List<Message> getThreeMessage(String userName) {
        List<Message> messageList = messageMapper.selectList((new LambdaQueryWrapper<Message>().eq(Message::getStudentId, userName).eq(Message::getMessageType,"0")).orderByDesc(Message::getReleaseTime).last("limit 3"));
        return messageList;
    }

    @Override
    public PageBean getMessages( String userName, Integer pageNum, Integer pageSize) {
        Page<Message> page = null;
        Integer totalNum= 0;
        PageBean<Message> pageBean = null;
        if (StringUtils.hasText(userName)){
            page = messageMapper.selectPage(Page.of(pageNum, pageSize), new LambdaQueryWrapper<Message>().eq(Message::getStudentId, userName).eq(Message::getMessageType,"0").orderByDesc(Message::getMessageId));
            totalNum = Math.toIntExact(messageMapper.selectCount(new LambdaQueryWrapper<Message>().eq(Message::getStudentId, userName).eq(Message::getMessageType,"0")));
            pageBean = new PageBean<>(pageNum, totalNum, pageSize);
            pageBean.setPageData(page.getRecords());
        }
        return pageBean;
    }

    @Override
    @Transactional
    public synchronized  boolean saveCrouseAlert(String userRole, String[] alerts, String type) {
        int saveNum = alerts.length;
        int num = 0;
        try {
            if (type.equals("batchCrouseAlert")){
                Message message = null;
                for (String alert : alerts) {
                    message= Message.builder().messageType("1")
                            .isAck("1")
                            .content("有不及格预警,请尽快查看 科目为"+ alert.substring(10))
                            .releaseTime(new Date())
                            .publisher(userRole)
                            .studentId(alert.substring(0, 10))
                            .title("不及格课程提醒").build();
                    num = num+ messageMapper.insert(message);
                }
            }
            else if(type.equals("batchRebuildAlert")){
                Message message = null;
                for (String alert : alerts) {
                    message= Message.builder().messageType("1")
                            .isAck("1")
                            .content("有重修预警,请尽快查看 科目为"+ alert.substring(10))
                            .releaseTime(new Date())
                            .publisher(userRole)
                            .studentId(alert.substring(0, 10))
                            .title("重修课程提醒").build();
                    num = num+ messageMapper.insert(message);

                }
            }

        } catch (Exception e) {
            throw new BusinessException("发布失败");
        }
        if (num ==saveNum){
            return  true;
        }
        return false;
    }

    @Override
    public Map<String, Integer> getAlertCounts(String userName) {
        Integer alertUnReadCount = Math.toIntExact(messageMapper.selectCount(new LambdaQueryWrapper<Message>().eq(Message::getStudentId, userName).eq(Message::getMessageType,"1").eq(Message::getIsAck, "1")));
        Integer alertCount = Math.toIntExact(messageMapper.selectCount(new LambdaQueryWrapper<Message>().eq(Message::getStudentId, userName).eq(Message::getMessageType,"1")));
        Map<String,Integer> count = new HashMap<>();
        count.put("alertUnReadCount",alertUnReadCount);
        count.put("alertCount",alertCount);
        return count;
    }

    @Override
    public List<Message> getThreeAltere(String userName) {
        List<Message> messageList = messageMapper.selectList((new LambdaQueryWrapper<Message>().eq(Message::getStudentId, userName).eq(Message::getMessageType,"1")).orderByDesc(Message::getReleaseTime).last("limit 3"));
        return messageList;
    }

    @Override
    public PageBean getAlert(String userName, Integer pageNum, Integer pageSize) {
        Page<Message> page = null;
        Integer totalNum= 0;
        PageBean<Message> pageBean = null;
        if (StringUtils.hasText(userName)){
            page = messageMapper.selectPage(Page.of(pageNum, pageSize), new LambdaQueryWrapper<Message>().eq(Message::getStudentId, userName).eq(Message::getMessageType,"1").orderByDesc(Message::getMessageId));
            totalNum = Math.toIntExact(messageMapper.selectCount(new LambdaQueryWrapper<Message>().eq(Message::getStudentId, userName).eq(Message::getMessageType,"1")));
            pageBean = new PageBean<>(pageNum, totalNum, pageSize);
            pageBean.setPageData(page.getRecords());
        }
        return pageBean;
    }

    @Override
    @Transactional
    public boolean courseAllSend(Map<String, String> map, String type) {
        List<CourseInfo> list =courseInfoService.getIdS(map);
        if (list.size()==0){
           return false;
        }
        int saveNum = list.size();
        int num = 0;
            try {
                if (type.equals("batchCrouseAlert")){
                    Message message = null;
                    for (CourseInfo courseInfo : list) {
                        message= Message.builder().messageType("1")
                                .isAck("1")
                                .content("有不及格预警,请尽快查看 科目为"+ courseInfo.getCourseName())
                                .releaseTime(new Date())
                                .publisher(map.get("userRole"))
                                .studentId(courseInfo.getStudnetId())
                                .title("不及格课程提醒").build();
                        num = num+ messageMapper.insert(message);
                    }
                }
            }
            catch (Exception e) {
                throw new BusinessException("发布失败");
            }
            if (num ==saveNum){
                return  true;
            }

        return false;
    }

    @Override
    public boolean rebuildAllSend(Map<String, String> map, String type) {
        List<CourseInfo> list =courseInfoService.getRebuildIdS(map);
        if (list.size()==0){
            return false;
        }
        int saveNum = list.size();
        int num = 0;
        try {
            if (type.equals("batchRebuildAlert")){
                Message message = null;
                for (CourseInfo courseInfo : list) {
                    message= Message.builder().messageType("1")
                            .isAck("1")
                            .content("有重修预警,请尽快查看 科目为"+ courseInfo.getCourseName())
                            .releaseTime(new Date())
                            .publisher(map.get("userRole"))
                            .studentId(courseInfo.getStudnetId())
                            .title("重修课程提醒").build();
                    num = num+ messageMapper.insert(message);
                }
            }
        }
        catch (Exception e) {
            throw new BusinessException("发布失败");
        }
        if (num ==saveNum){
            return  true;
        }
        return false;
    }
}
