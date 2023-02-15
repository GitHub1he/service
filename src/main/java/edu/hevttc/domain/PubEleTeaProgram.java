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

@ApiModel(value="edu-hevttc-domain-PubEleTeaProgram")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_pub_ele_tea_program")
public class PubEleTeaProgram implements Serializable {
    @TableId(value = "petp_id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private String petpId;

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

    /**
     * 课程性质
     */
    @TableField(value = "course_select")
    @ApiModelProperty(value="课程性质")
    private String courseSelect;

    /**
     * 课程归属
     */
    @TableField(value = "course_affiliation")
    @ApiModelProperty(value="课程归属")
    private String courseAffiliation;

    @TableField(value = "credit")
    @ApiModelProperty(value="")
    private Double credit;

    @TableField(value = "teach_college")
    @ApiModelProperty(value="")
    private String teachCollege;

    @TableField(value = "exam_method")
    @ApiModelProperty(value="")
    private String examMethod;

    private static final long serialVersionUID = 1L;
}
