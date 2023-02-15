package edu.hevttc.workbench.course.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="edu-hevttc-course-domain-Courseinfo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "courseinfo")
public class CourseInfo implements Serializable {
    @TableField(value = "studnet_id")
    @ApiModelProperty(value="")
    private String studnetId;

    @TableField(value = "learn_year")
    @ApiModelProperty(value="")
    private String learnYear;

    @TableField(value = "semester")
    @ApiModelProperty(value="")
    private String semester;

    @TableField(value = "student_name")
    @ApiModelProperty(value="")
    private String studentName;

    @TableField(value = "course_name")
    @ApiModelProperty(value="")
    private String courseName;

    @TableField(value = "course_code")
    @ApiModelProperty(value="")
    private String courseCode;

    @TableField(value = "score")
    @ApiModelProperty(value="")
    private Double score;

    @TableField(value = "credit")
    @ApiModelProperty(value="")
    private Double credit;

    /**
     * 重修预警
     */
    @TableField(value = "rebuild")
    @ApiModelProperty(value="重修预警")
    private String rebuild;

    /**
     * 课程选择
     */
    @TableField(value = "cousre_select")
    @ApiModelProperty(value="课程选择")
    private String cousreSelect;

    /**
     * 补考
     */
    @TableField(value = "makeup")
    @ApiModelProperty(value="补考")
    private String makeup;

    @TableField(value = "year")
    @ApiModelProperty(value="")
    private String year;

    @TableField(value = "classes_name")
    @ApiModelProperty(value="")
    private String classesName;

    @TableField(value = "college_name")
    @ApiModelProperty(value="")
    private String collegeName;

    @TableField(value = "major_name")
    @ApiModelProperty(value="")
    private String majorName;

    @TableField(value = "notes")
    @ApiModelProperty(value="")
    private String notes;

    private static final long serialVersionUID = 1L;
}
