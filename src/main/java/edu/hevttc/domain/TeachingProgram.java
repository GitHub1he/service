package edu.hevttc.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="edu-hevttc-domain-TeachingProgram")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_teaching_program")
public class TeachingProgram implements Serializable {
    /**
     * 教学计划主键id
     */
    @TableField(value = "tp_id")
    @ApiModelProperty(value="教学计划主键id")
    private String tpId;

    /**
     * 专业代码
     */
    @TableField(value = "major_id")
    @ApiModelProperty(value="专业代码")
    private String majorId;

    /**
     * 专业名称
     */
    @TableField(value = "major_name")
    @ApiModelProperty(value="专业名称")
    private String majorName;

    /**
     * 学年
     */
    @TableField(value = "learn_year")
    @ApiModelProperty(value="学年")
    private String learnYear;

    /**
     * 学期
     */
    @TableField(value = "semeter")
    @ApiModelProperty(value="学期")
    private String semeter;

    /**
     * 课程名称
     */
    @TableField(value = "course_name")
    @ApiModelProperty(value="课程名称")
    private String courseName;

    /**
     * 课程代码
     */
    @TableField(value = "course_id")
    @ApiModelProperty(value="课程代码")
    private String courseId;

    /**
     * 课程选择
     */
    @TableField(value = "course_select")
    @ApiModelProperty(value="课程选择")
    private String courseSelect;

    /**
     * 学分
     */
    @TableField(value = "credit")
    @ApiModelProperty(value="学分")
    private Double credit;

    /**
     * 考核方式
     */
    @TableField(value = "exam_method")
    @ApiModelProperty(value="考核方式")
    private String examMethod;

    /**
     * 开课学院
     */
    @TableField(value = "teach_college")
    @ApiModelProperty(value="开课学院")
    private String teachCollege;

    private static final long serialVersionUID = 1L;
}