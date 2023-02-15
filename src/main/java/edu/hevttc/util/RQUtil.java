package edu.hevttc.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.hevttc.basic.mapper.StudentMapper;
import edu.hevttc.basic.service.StudentService;
import edu.hevttc.domain.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RQUtil {
    @Resource
    private StudentService studentService;

    @Bean
    public static String getLearnYear() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM");
        String time = sdf.format(date);
        String year = time.substring(0, 4);
        String month = time.substring(5);
        String xn = null;
        if (Integer.parseInt(month) <= 8 && Integer.parseInt(month) >= 2) {
            int y = Integer.parseInt(year) - 1;
            xn = y + "-" + year;
        } else {
            int y = Integer.parseInt(year) + 1;
            xn = year + "-" + y;
        }
        return xn;
    }

//    @Bean
//    public int getSemester(String studentId) {
//        int dxq = 0;
//        Student student = studentService.getOne(new QueryWrapper<Student>().eq("studnet_id", studentId));
//        String year1 = student.getYear();
//        int njj = Integer.parseInt(year1);
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        sdf.applyPattern("yyyy");
//        int year = Integer.parseInt(sdf.format(date));
//        sdf.applyPattern("MM");
//        int month = Integer.parseInt(sdf.format(date));
//        int yn = year - njj;
//        dxq = 2 * yn;
//        if (month > 8) {
//            dxq = 2 * yn + 1;
//        }
//        return dxq;
//    }

}
