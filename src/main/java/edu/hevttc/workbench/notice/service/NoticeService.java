package edu.hevttc.workbench.notice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.hevttc.commons.PageBean;
import edu.hevttc.commons.ReturnObject;
import edu.hevttc.domain.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.hevttc.workbench.notice.VO.NoticeVO;

import java.io.Serializable;

public interface NoticeService extends IService<Notice>{


    ReturnObject savePubishMessage(Notice notice, boolean onlyId);


    PageBean getPage(String userRole, Integer pageNum ,Integer pageSize);

    PageBean getNotices(String userRole, String userName, Integer pageNum, Integer pageSize);


    NoticeVO getNoticeById(String noticeId);
}
