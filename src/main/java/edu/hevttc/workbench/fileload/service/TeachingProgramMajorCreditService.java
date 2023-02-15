package edu.hevttc.workbench.fileload.service;

import edu.hevttc.commons.PageBean;
import edu.hevttc.domain.TeachingProgramMajorCredit;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TeachingProgramMajorCreditService extends IService<TeachingProgramMajorCredit>{


    PageBean loadMajorCreditPage(Integer pageNum, Integer pageSize, String collegeCode);
}
