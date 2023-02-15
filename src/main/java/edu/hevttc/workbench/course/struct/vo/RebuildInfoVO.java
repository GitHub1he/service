package edu.hevttc.workbench.course.struct.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pc.dragon
 * @ClassName RebuildInfoVO
 * @description: RebuildInfoVo
 * @date 2023年02月08日
 * @version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RebuildInfoVO {
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


    /**
     * 课程选择
     */
    private String cousreSelect;


    private String collegeName;
    private String classesName;
    private String majorName;
    private String rebuildLearnYear;
    private String rebuildSemester;
    private String rebuildCourseName;
    private String rebuildCourseCode;
    private String enroll;
    private String teachCollege;
    private static final long serialVersionUID = 1L;
}
