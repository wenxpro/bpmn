package com.example.bpmneasyflow.vo;

import com.example.bpmneasyflow.entity.LineEntity;
import com.example.bpmneasyflow.entity.NodeEntity;
import lombok.Data;

import java.util.List;

/**
 * @author liuchengbiao
 * @date 2020-05-22 22:00
 */
@Data
public class ProjectVo {
    private String name;
    private List<NodeEntity> nodeList;
    private List<LineEntity> lineList;
}
