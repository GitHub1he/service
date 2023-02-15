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

@ApiModel(value="edu-hevttc-domain-TeachingProgramMajorCredit")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_teaching_program_major_credit")
public class TeachingProgramMajorCredit implements Serializable {
    /**
     * 教学计划号 年级+专业代码
     */
    @TableId(value = "tpm_id", type = IdType.INPUT)
    @ApiModelProperty(value="教学计划号 年级+专业代码")
    private String tpmId;

    /**
     * 专业
     */
    @TableField(value = "major_id")
    @ApiModelProperty(value="专业")
    private String majorId;

    /**
     * 年级
     */
    @TableField(value = "year")
    @ApiModelProperty(value="年级")
    private String year;

    /**
     * 总学分
     */
    @TableField(value = "sum_credit")
    @ApiModelProperty(value="总学分")
    private Double sumCredit;

    /**
     * 公共选修课
     */
    @TableField(value = "pub_ele_credit")
    @ApiModelProperty(value="公共选修课")
    private Double pubEleCredit;

    /**
     * 公共通修课
     */
    @TableField(value = "pub_gen_credit")
    @ApiModelProperty(value="公共通修课")
    private Double pubGenCredit;

    /**
     * 专业基础课
     */
    @TableField(value = "pro_bas_credit")
    @ApiModelProperty(value="专业基础课")
    private Double proBasCredit;

    /**
     * 专业核心课
     */
    @TableField(value = "pro_core_credit")
    @ApiModelProperty(value="专业核心课")
    private Double proCoreCredit;

    /**
     * 专业任选课
     */
    @TableField(value = "pro_ele_credit")
    @ApiModelProperty(value="专业任选课")
    private Double proEleCredit;

    /**
     * 专业限选课
     */
    @TableField(value = "pro_lim_credit")
    @ApiModelProperty(value="专业限选课")
    private Double proLimCredit;

    /**
     * 实践教学环节
     */
    @TableField(value = "pra_teaching_credit")
    @ApiModelProperty(value="实践教学环节")
    private Double praTeachingCredit;

    private static final long serialVersionUID = 1L;
}
