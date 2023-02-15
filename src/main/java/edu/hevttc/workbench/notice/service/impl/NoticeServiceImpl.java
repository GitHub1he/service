package edu.hevttc.workbench.notice.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.hevttc.commons.BusinessException;
import edu.hevttc.commons.PageBean;
import edu.hevttc.commons.ReturnObject;
import edu.hevttc.domain.Message;
import edu.hevttc.workbench.notice.VO.NoticeVO;
import edu.hevttc.workbench.notice.mapper.MessageMapper;
import edu.hevttc.workbench.notice.service.MessageService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.workbench.notice.mapper.NoticeMapper;
import edu.hevttc.domain.Notice;
import edu.hevttc.workbench.notice.service.NoticeService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;

@Service

public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;
    @Resource
    private MessageService messageService;
    @Resource
    private MessageMapper messageMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReturnObject savePubishMessage(Notice notice, boolean onlyId) {
        int insertNotice = 0;
        insertNotice = noticeMapper.insert(notice);
        Integer insertMessage = messageService.saveMessage(notice, onlyId);
        System.out.println(insertMessage);
        if (insertMessage <= 0) {
            throw new BusinessException("没有符合条件的学生,发布失败");
        }
        if (ObjectUtil.isNotNull(insertMessage)) {
            if (insertMessage == 1 && insertNotice == 1) {
                return ReturnObject.SUCCESS("发布成功");
            }
        }
        return ReturnObject.ERROR("发布失败");
    }

    @Override
    public PageBean getPage(String userRole, Integer pageNum, Integer pageSize) {
        Page<Notice> page = null;
        Integer totalNum = 0;
        PageBean<Notice> pageBean = null;
        if ("0".equals(userRole)) {
            page = noticeMapper.selectPage(Page.of(pageNum, pageSize), new LambdaQueryWrapper<Notice>().eq(Notice::getUrole, userRole).orderByDesc(Notice::getId));
            totalNum = Math.toIntExact(noticeMapper.selectCount(new LambdaQueryWrapper<Notice>().eq(Notice::getUrole, userRole)));
            pageBean = new PageBean<>(pageNum, totalNum, pageSize);
            pageBean.setPageData(page.getRecords());
        } else if ("1".equals(userRole)) {
            page = noticeMapper.selectPage(Page.of(pageNum, pageSize), new LambdaQueryWrapper<Notice>().and(noticeLambdaQueryWrapper -> noticeLambdaQueryWrapper.eq(Notice::getUrole, userRole).or().eq(Notice::getUrole, "0")).orderByDesc(Notice::getId));
            totalNum = Math.toIntExact(noticeMapper.selectCount(new LambdaQueryWrapper<Notice>().and(noticeLambdaQueryWrapper -> noticeLambdaQueryWrapper.eq(Notice::getUrole, userRole).or().eq(Notice::getUrole, "0"))));
            pageBean = new PageBean<>(pageNum, totalNum, pageSize);
            pageBean.setPageData(page.getRecords());
        } else if ("2".equals(userRole)) {
            page = noticeMapper.selectPage(Page.of(pageNum, pageSize), new LambdaQueryWrapper<Notice>().and(noticeLambdaQueryWrapper -> noticeLambdaQueryWrapper.eq(Notice::getUrole, userRole).or().eq(Notice::getUrole, "0").or().eq(Notice::getUrole, "1")).orderByDesc(Notice::getId));
            totalNum = Math.toIntExact(noticeMapper.selectCount(new LambdaQueryWrapper<Notice>().and(noticeLambdaQueryWrapper -> noticeLambdaQueryWrapper.eq(Notice::getUrole, userRole).or().eq(Notice::getUrole, "0").or().eq(Notice::getUrole, "1"))));
            pageBean = new PageBean<>(pageNum, totalNum, pageSize);
            pageBean.setPageData(page.getRecords());
        } else {
            page = noticeMapper.selectPage(Page.of(pageNum, pageSize), new LambdaQueryWrapper<Notice>().and(noticeLambdaQueryWrapper -> noticeLambdaQueryWrapper.eq(Notice::getUrole, userRole).or().eq(Notice::getUrole, "0").or().eq(Notice::getUrole, "1").or().eq(Notice::getUrole, "2")).orderByDesc(Notice::getId));
            totalNum = Math.toIntExact(noticeMapper.selectCount(new LambdaQueryWrapper<Notice>().and(noticeLambdaQueryWrapper -> noticeLambdaQueryWrapper.eq(Notice::getUrole, userRole).or().eq(Notice::getUrole, "0").or().eq(Notice::getUrole, "1").or().eq(Notice::getUrole, "2"))));
            pageBean = new PageBean<>(pageNum, totalNum, pageSize);
            pageBean.setPageData(page.getRecords());
        }

        return pageBean;
    }

    @Override
    public PageBean getNotices(String userRole, String userName, Integer pageNum, Integer pageSize) {
        Page<Notice> page = null;
        Integer totalNum = 0;
        PageBean<Notice> pageBean = null;
        if (StringUtils.hasText(userRole) && StringUtils.hasText(userName)) {
            page = noticeMapper.selectPage(Page.of(pageNum, pageSize), new LambdaQueryWrapper<Notice>().eq(Notice::getUrole, userRole).eq(Notice::getPublisher, userName).orderByDesc(Notice::getId));
            totalNum = Math.toIntExact(noticeMapper.selectCount(new LambdaQueryWrapper<Notice>().eq(Notice::getUrole, userRole).eq(Notice::getPublisher, userName)));
            pageBean = new PageBean<>(pageNum, totalNum, pageSize);
            pageBean.setPageData(page.getRecords());
        }
        return pageBean;
    }

    @Override
    public NoticeVO getNoticeById(String noticeId) {
        Long unAck = messageMapper.selectCount(new LambdaQueryWrapper<Message>().eq(Message::getNoticeId, noticeId).eq(Message::getIsAck, "1"));
        Long ack = messageMapper.selectCount(new LambdaQueryWrapper<Message>().eq(Message::getNoticeId, noticeId).eq(Message::getIsAck, "0"));
        Notice notice = noticeMapper.selectById(noticeId);
        NoticeVO noticeVO = NoticeVO.builder()
                .id(Integer.valueOf(noticeId))
                .ackCount(ack)
                .unAckCount(unAck)
                .cautionClass(notice.getCautionClass())
                .cautionCollege(notice.getCautionCollege())
                .cautionMajor(notice.getCautionMajor())
                .cautionStudent(notice.getCautionStudent())
                .cautionYear(notice.getCautionYear())
                .content(notice.getContent())
                .title(notice.getTitle())
                .publisher(notice.getPublisher())
                .urole(notice.getUrole())
                .isAck(notice.getIsAck())
                .releaseTime(notice.getReleaseTime())
                .build();
        return noticeVO;
    }

}
