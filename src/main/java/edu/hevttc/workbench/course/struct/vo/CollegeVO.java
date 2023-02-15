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
 * @ClassName CollegeVO
 * @description: 学院
 * @date 2023年02月05日
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollegeVO implements Serializable {

    @ApiModelProperty(value="collegeId")
    private String collegeId;


    @ApiModelProperty(value="collegeName")
    private String collegeName;
    @ApiModelProperty(value = "majorList")
    private List<MajorVO> majorVOList;
    private static final long serialVersionUID = 1L;
}
