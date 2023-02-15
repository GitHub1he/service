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

@ApiModel(value="edu-hevttc-domain-Classes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_classes")
public class Classes implements Serializable {
    @TableId(value = "classes_id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private String classesId;

    @TableField(value = "classes_name")
    @ApiModelProperty(value="")
    private String classesName;

    @TableField(value = "major_id")
    @ApiModelProperty(value="")
    private String majorId;

    /**
     * 年级
     */
    @TableField(value = "year")
    @ApiModelProperty(value="年级")
    private String year;

    private static final long serialVersionUID = 1L;
}