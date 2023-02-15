package edu.hevttc.workbench.fileload.struct.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Pc.dragon
 * @ClassName MajorCreditVO
 * @description: 传递前端vo
 * @date 2023年02月04日
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MajorCreditVO implements Serializable {
    /**
     * 教学计划号 年级+专业代码
     */

    @ApiModelProperty(value="教学计划号 年级+专业代码")
    private String tpmId;

    /**
     * 专业
     */

    @ApiModelProperty(value="专业")
    private String majorId;

    /**
     * 年级
     */

    @ApiModelProperty(value="年级")
    private String year;

    /**
     * 总学分
     */

    @ApiModelProperty(value="总学分")
    private Double sumCredit;

    /**
     * 公共选修课
     */

    @ApiModelProperty(value="公共选修课")
    private Double pubEleCredit;

    /**
     * 公共通修课
     */

    @ApiModelProperty(value="公共通修课")
    private Double pubGenCredit;

    /**
     * 专业基础课
     */

    @ApiModelProperty(value="专业基础课")
    private Double proBasCredit;

    /**
     * 专业核心课
     */

    @ApiModelProperty(value="专业核心课")
    private Double proCoreCredit;

    /**
     * 专业任选课
     */

    @ApiModelProperty(value="专业任选课")
    private Double proEleCredit;

    /**
     * 专业限选课
     */

    @ApiModelProperty(value="专业限选课")
    private Double proLimCredit;

    /**
     * 实践教学环节
     */

    @ApiModelProperty(value="实践教学环节")
    private Double praTeachingCredit;
    @ApiModelProperty(value = "专业名称")
    private String majorName;
}
