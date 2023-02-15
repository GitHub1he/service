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

@ApiModel(value="edu-hevttc-domain-PubEleSprotTeaProgram")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_pub_ele_sprot_tea_program")
public class PubEleSprotTeaProgram implements Serializable {
    @TableId(value = "pestp_id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Integer pestpId;

    @TableField(value = "major_name")
    @ApiModelProperty(value="")
    private String majorName;

    @TableField(value = "grade")
    @ApiModelProperty(value="")
    private String grade;

    @TableField(value = "learn_year")
    @ApiModelProperty(value="")
    private String learnYear;

    @TableField(value = "semeter")
    @ApiModelProperty(value="")
    private String semeter;

    @TableField(value = "course_name")
    @ApiModelProperty(value="")
    private String courseName;

    @TableField(value = "course_id")
    @ApiModelProperty(value="")
    private String courseId;

    @TableField(value = "course_select")
    @ApiModelProperty(value="")
    private String courseSelect;

    @TableField(value = "course_affiliation")
    @ApiModelProperty(value="")
    private String courseAffiliation;

    @TableField(value = "credit")
    @ApiModelProperty(value="")
    private Double credit;

    @TableField(value = "exam_method")
    @ApiModelProperty(value="")
    private String examMethod;

    @TableField(value = "teach_college")
    @ApiModelProperty(value="")
    private String teachCollege;

    private static final long serialVersionUID = 1L;
}