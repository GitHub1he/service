package edu.hevttc.workbench.fileload.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.hevttc.basic.mapper.MajorMapper;
import edu.hevttc.commons.PageBean;
import edu.hevttc.domain.Major;
import edu.hevttc.workbench.fileload.struct.vo.MajorCreditVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.hevttc.domain.TeachingProgramMajorCredit;
import edu.hevttc.workbench.fileload.mapper.TeachingProgramMajorCreditMapper;
import edu.hevttc.workbench.fileload.service.TeachingProgramMajorCreditService;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeachingProgramMajorCreditServiceImpl extends ServiceImpl<TeachingProgramMajorCreditMapper, TeachingProgramMajorCredit> implements TeachingProgramMajorCreditService{
    @Resource
    private TeachingProgramMajorCreditMapper majorCreditMapper;
    @Resource
     private  MajorMapper majorMapper;
    @Override
    public PageBean loadMajorCreditPage(Integer pageNum, Integer pageSize, String collegeCode) {
        Page<TeachingProgramMajorCredit> teachingProgramMajorCreditPage = majorCreditMapper.selectPage(Page.of(pageNum, pageSize),
                new LambdaQueryWrapper<TeachingProgramMajorCredit>()
                        .likeRight(StringUtils.hasText(collegeCode),TeachingProgramMajorCredit::getMajorId, collegeCode)
        .orderByDesc(TeachingProgramMajorCredit::getYear).orderByAsc(TeachingProgramMajorCredit::getMajorId));
        Integer aLong = Math.toIntExact(majorCreditMapper.selectCount(new LambdaQueryWrapper<TeachingProgramMajorCredit>()
                .likeRight(StringUtils.hasText(collegeCode),TeachingProgramMajorCredit::getMajorId, collegeCode)));
        PageBean<MajorCreditVO> pageBean = new PageBean<>(pageNum,aLong, pageSize);
        List<TeachingProgramMajorCredit> records = teachingProgramMajorCreditPage.getRecords();
        List<MajorCreditVO> majorCreditVOList = new ArrayList<>();
        Major major = new Major();
        MajorCreditVO majorCreditVO = new MajorCreditVO();
        for (TeachingProgramMajorCredit record : records) {
          major= majorMapper.selectOne(new LambdaQueryWrapper<Major>().eq(Major::getMajorId, record.getMajorId()));
            majorCreditVO = MajorCreditVO.builder().majorId(record.getMajorId())
                    .majorName(major.getMajorName())
                    .praTeachingCredit(record.getPraTeachingCredit())
                    .proCoreCredit(record.getProCoreCredit())
                    .proBasCredit(record.getProBasCredit())
                    .proEleCredit(record.getProEleCredit())
                    .proLimCredit(record.getProLimCredit())
                    .pubGenCredit(record.getPubGenCredit())
                    .pubEleCredit(record.getPubEleCredit())
                    .tpmId(record.getTpmId())
                    .year(record.getYear())
                    .sumCredit(record.getSumCredit())
                    .build();
            majorCreditVOList.add(majorCreditVO);
        }
        pageBean.setPageData(majorCreditVOList);
        return pageBean;
    }
}
