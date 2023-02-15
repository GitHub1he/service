package edu.hevttc.workbench.course.struct.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Pc.dragon
 * @ClassName InitOption
 * @description: 条件封装
 * @date 2023年02月08日
 * @version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InitOption implements Serializable {
    private List<CollegeVO> collegeVOList;
    private static final long serialVersionUID = 1L;
}
