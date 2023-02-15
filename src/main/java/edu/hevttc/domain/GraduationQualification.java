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

@ApiModel(value="edu-hevttc-domain-GraduationQualification")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_graduation_qualification")
public class GraduationQualification implements Serializable {
    /**
     * 学号
     */
    @TableId(value = "studnet_id", type = IdType.INPUT)
    @ApiModelProperty(value="学号")
    private String studnetId;

    /**
     * 学名
     */
    @TableField(value = "studnet_name")
    @ApiModelProperty(value="学名")
    private String studnetName;

    /**
     * 学院名称
     */
    @TableField(value = "college_name")
    @ApiModelProperty(value="学院名称")
    private String collegeName;

    /**
     * 专业名称
     */
    @TableField(value = "major_name")
    @ApiModelProperty(value="专业名称")
    private String majorName;

    /**
     * 班级名称
     */
    @TableField(value = "classes_name")
    @ApiModelProperty(value="班级名称")
    private String classesName;

    /**
     * 生源情况
     */
    @TableField(value = "student_source")
    @ApiModelProperty(value="生源情况")
    private String studentSource;

    /**
     * 总学分
     */
    @TableField(value = "total_credits")
    @ApiModelProperty(value="总学分")
    private Double totalCredits;

    /**
     * 公共选修课学分
     */
    @TableField(value = "pub_ele_credit")
    @ApiModelProperty(value="公共选修课学分")
    private Double pubEleCredit;

    /**
     * 专业选修课学分
     */
    @TableField(value = "pro_ele_credit")
    @ApiModelProperty(value="专业选修课学分")
    private Double proEleCredit;

    /**
     * 绩点
     */
    @TableField(value = "grade_point")
    @ApiModelProperty(value="绩点")
    private Double gradePoint;

    /**
     * 普通话证书
     */
    @TableField(value = "chinese_qua")
    @ApiModelProperty(value="普通话证书")
    private String chineseQua;

    /**
     * 计算机证书
     */
    @TableField(value = "computer_qua")
    @ApiModelProperty(value="计算机证书")
    private String computerQua;

    /**
     * 中级工
     */
    @TableField(value = "zjg")
    @ApiModelProperty(value="中级工")
    private String zjg;

    /**
     * 欠费情况
     */
    @TableField(value = "arrears")
    @ApiModelProperty(value="欠费情况")
    private String arrears;

    /**
     * 毕业证书
     */
    @TableField(value = "graduation")
    @ApiModelProperty(value="毕业证书")
    private String graduation;

    /**
     * 毕业证书确认
     */
    @TableField(value = "graduation_qua")
    @ApiModelProperty(value="毕业证书确认")
    private String graduationQua;

    /**
     * 学位证书
     */
    @TableField(value = "diploma")
    @ApiModelProperty(value="学位证书")
    private String diploma;

    /**
     * 学位证书确认
     */
    @TableField(value = "diploma_qua")
    @ApiModelProperty(value="学位证书确认")
    private String diplomaQua;

    private static final long serialVersionUID = 1L;
}