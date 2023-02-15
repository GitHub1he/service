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

@ApiModel(value="edu-hevttc-domain-Major")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_major")
public class Major implements Serializable {
    @TableId(value = "major_id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private String majorId;

    @TableField(value = "major_name")
    @ApiModelProperty(value="")
    private String majorName;

    @TableField(value = "college_id")
    @ApiModelProperty(value="")
    private String collegeId;

    private static final long serialVersionUID = 1L;
}