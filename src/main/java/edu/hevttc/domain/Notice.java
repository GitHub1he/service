package edu.hevttc.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="edu-hevttc-domain-Notice")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_notice")
public class Notice implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "urole")
    @ApiModelProperty(value="")
    private String urole;

    @TableField(value = "publisher")
    @ApiModelProperty(value="")
    private String publisher;

    @TableField(value = "title")
    @ApiModelProperty(value="")
    private String title;

    @TableField(value = "content")
    @ApiModelProperty(value="")
    private String content;

    @TableField(value = "release_time")
    @ApiModelProperty(value="")
    private Date releaseTime;

    @TableField(value = "caution_college")
    @ApiModelProperty(value="")
    private String cautionCollege;

    @TableField(value = "caution_major")
    @ApiModelProperty(value="")
    private String cautionMajor;

    @TableField(value = "caution_class")
    @ApiModelProperty(value="")
    private String cautionClass;

    @TableField(value = "caution_year")
    @ApiModelProperty(value="")
    private String cautionYear;

    @TableField(value = "caution_student")
    @ApiModelProperty(value="")
    private String cautionStudent;

    @TableField(value = "isAck")
    @ApiModelProperty(value="")
    private String isAck;

    private static final long serialVersionUID = 1L;
}
