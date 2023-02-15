package edu.hevttc.workbench.course.struct.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Pc.dragon
 * @ClassName ClassesVO
 * @description: classes
 * @date 2023年02月05日
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassesVO implements Serializable {

    @ApiModelProperty(value="classesId")
    private String classesId;

    @ApiModelProperty(value="classesName")
    private String classesName;


    @ApiModelProperty(value="majorId")
    private String majorId;

    /**
     * 年级
     */
    @ApiModelProperty(value="年级")
    private String year;
    private static final long serialVersionUID = 1L;


}
