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

@ApiModel(value="edu-hevttc-domain-Student")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_student")
public class Student implements Serializable {
    @TableId(value = "studnet_id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private String studnetId;

    @TableField(value = "student_name")
    @ApiModelProperty(value="")
    private String studentName;

    @TableField(value = "student_sex")
    @ApiModelProperty(value="")
    private String studentSex;

    @TableField(value = "college_name")
    @ApiModelProperty(value="")
    private String collegeName;

    @TableField(value = "major_name")
    @ApiModelProperty(value="")
    private String majorName;

    @TableField(value = "classes_name")
    @ApiModelProperty(value="")
    private String classesName;

    @TableField(value = "year")
    @ApiModelProperty(value="")
    private String year;

    private static final long serialVersionUID = 1L;
}