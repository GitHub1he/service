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

@ApiModel(value="edu-hevttc-domain-College")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_college")
public class College implements Serializable {
    @TableId(value = "college_id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private String collegeId;

    @TableField(value = "college_name")
    @ApiModelProperty(value="")
    private String collegeName;

    private static final long serialVersionUID = 1L;
}