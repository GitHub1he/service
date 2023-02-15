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

@ApiModel(value="edu-hevttc-domain-User")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user")
public class User implements Serializable {
    @TableId(value = "user_id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer userId;

    @TableField(value = "user_name")
    @ApiModelProperty(value="")
    private String userName;

    @TableField(value = "user_nickname")
    @ApiModelProperty(value="")
    private String userNickname;

    @TableField(value = "user_pwd")
    @ApiModelProperty(value="")
    private String userPwd;

    /**
     * 用户角色
     */
    @TableField(value = "user_role")
    @ApiModelProperty(value="用户角色")
    private String userRole;

    @TableField(value = "college_code")
    @ApiModelProperty(value="")
    private String collegeCode;

    @TableField(value = "major_code")
    @ApiModelProperty(value="")
    private String majorCode;

    /**
     * 年级
     */
    @TableField(value = "year")
    @ApiModelProperty(value="年级")
    private String year;

    @TableField(exist = false)
    @ApiModelProperty(value="token")
    private String token;

    private static final long serialVersionUID = 1L;
}
