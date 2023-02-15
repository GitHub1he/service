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

@ApiModel(value="edu-hevttc-domain-Score")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_score")
public class Score implements Serializable {
    @TableField(value = "learn_year")
    @ApiModelProperty(value="")
    private String learnYear;

    @TableField(value = "semester")
    @ApiModelProperty(value="")
    private String semester;

    @TableField(value = "student_id")
    @ApiModelProperty(value="")
    private String studentId;

    @TableField(value = "studnet_name")
    @ApiModelProperty(value="")
    private String studnetName;

    @TableField(value = "course_name")
    @ApiModelProperty(value="")
    private String courseName;

    @TableField(value = "course_code")
    @ApiModelProperty(value="")
    private String courseCode;

    @TableField(value = "daily_score")
    @ApiModelProperty(value="")
    private Double dailyScore;

    @TableField(value = "last_score")
    @ApiModelProperty(value="")
    private Double lastScore;

    @TableField(value = "score")
    @ApiModelProperty(value="")
    private Double score;

    @TableField(value = "notes")
    @ApiModelProperty(value="")
    private String notes;

    @TableField(value = "credit")
    @ApiModelProperty(value="")
    private Double credit;

    @TableField(value = "grade_point")
    @ApiModelProperty(value="")
    private Double gradePoint;

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
     * 补考情况
     */
    @TableField(value = "makeup")
    @ApiModelProperty(value="补考情况")
    private String makeup;

    private static final long serialVersionUID = 1L;
}