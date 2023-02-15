package edu.hevttc.workbench.notice.service;

import edu.hevttc.commons.PageBean;
import edu.hevttc.domain.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.hevttc.domain.Notice;

import java.util.List;
import java.util.Map;

public interface MessageService extends IService<Message>{


    Integer saveMessage(Notice notice, boolean onlyId);

    Map<String,Integer> getUnreadeCount(String userName);

    List<Message> getThreeMessage(String userName);

    PageBean getMessages( String userName, Integer pageNum, Integer pageSize);

    boolean saveCrouseAlert(String userRole, String[] alerts, String type);

    Map<String, Integer> getAlertCounts(String userName);

    List<Message> getThreeAltere(String userName);

    PageBean getAlert(String userName, Integer pageNum, Integer pageSize);

    boolean courseAllSend(Map<String, String> map, String type);

    boolean rebuildAllSend(Map<String, String> map, String type);
}
