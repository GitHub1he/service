package edu.hevttc.workbench.course.struct.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Pc.dragon
 * @ClassName FialCourse
 * @description: 课程信息
 * @date 2023年01月30日
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfoVo implements Serializable {
    private String learnYear;

    private String semester;

    private String studentId;

    private String studnetName;

    private String courseName;

    private String courseCode;

    private Double score;

    private Double credit;

    /**
     * 重修预警
     */
    private String rebuild;

    /**
     * 课程选择
     */
    private String cousreSelect;

    /**
     * 补考情况
     */
    private String makeup;
    private String collegeName;
    private String classesName;
    private String majorName;
    private String failInfo;
    private static final long serialVersionUID = 1L;
}
