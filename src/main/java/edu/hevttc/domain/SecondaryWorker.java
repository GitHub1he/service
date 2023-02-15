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

@ApiModel(value="edu-hevttc-domain-SecondaryWorker")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_secondary_worker")
public class SecondaryWorker implements Serializable {
    @TableField(value = "student_id")
    @ApiModelProperty(value="")
    private String studentId;

    @TableField(value = "student_name")
    @ApiModelProperty(value="")
    private String studentName;

    @TableField(value = "cert_name")
    @ApiModelProperty(value="")
    private String certName;

    @TableField(value = "cert_code")
    @ApiModelProperty(value="")
    private String certCode;

    @TableField(value = "get_time")
    @ApiModelProperty(value="")
    private String getTime;

    @TableField(value = "issuing_authority")
    @ApiModelProperty(value="")
    private String issuingAuthority;

    @TableField(value = "state")
    @ApiModelProperty(value="")
    private String state;

    private static final long serialVersionUID = 1L;
}