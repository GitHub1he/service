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

@ApiModel(value="edu-hevttc-domain-Message")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_message")
public class Message implements Serializable {
    @TableId(value = "message_id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Long messageId;

    @TableField(value = "notice_id")
    @ApiModelProperty(value="")
    private Integer noticeId;

    @TableField(value = "student_id")
    @ApiModelProperty(value="")
    private String studentId;

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

    @TableField(value = "isAck")
    @ApiModelProperty(value="")
    private String isAck;

    @TableField(value = "ack_time")
    @ApiModelProperty(value="")
    private Date ackTime;

    /**
     * 消息类型，0 是信息 1 是提醒
     */
    @TableField(value = "message_type")
    @ApiModelProperty(value="消息类型，0 是信息 1 是提醒")
    private String messageType;

    private static final long serialVersionUID = 1L;
}
