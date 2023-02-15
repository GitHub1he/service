package edu.hevttc.workbench.notice.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Pc.dragon
 * @ClassName NoticeVO
 * @description: noticevo
 * @date 2023年02月14日
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVO implements Serializable {

    private Integer id;


    private String urole;


    private String publisher;


    private String title;


    private String content;


    private Date releaseTime;


    private String cautionCollege;


    private String cautionMajor;


    private String cautionClass;


    private String cautionYear;



    private String cautionStudent;



    private String isAck;

    private Long ackCount;
    private Long unAckCount;

    private static final long serialVersionUID = 1L;

}
