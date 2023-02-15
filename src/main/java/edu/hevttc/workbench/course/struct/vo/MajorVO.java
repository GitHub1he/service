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
 * @ClassName MajorVO
 * @description: major
 * @date 2023年02月05日
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MajorVO implements Serializable {

    @ApiModelProperty(value="majorId")
    private String majorId;


    @ApiModelProperty(value="majorName")
    private String majorName;

    @ApiModelProperty(value="collegeId")
    private String collegeId;

    @ApiModelProperty(value="ClassesList")
    private List<ClassesVO> classesVOList ;
    private static final long serialVersionUID = 1L;
}
