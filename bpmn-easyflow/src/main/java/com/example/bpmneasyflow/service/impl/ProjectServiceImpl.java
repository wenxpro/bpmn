package com.example.bpmneasyflow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xioaka.easy.flow.sdk.dao.ProjectDao;
import com.xioaka.easy.flow.sdk.entity.LineEntity;
import com.xioaka.easy.flow.sdk.entity.NodeEntity;
import com.xioaka.easy.flow.sdk.entity.ProjectEntity;
import com.xioaka.easy.flow.sdk.service.ILineService;
import com.xioaka.easy.flow.sdk.service.INodeService;
import com.xioaka.easy.flow.sdk.service.IProjectService;
import com.xioaka.easy.flow.sdk.vo.ProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuchengbiao
 * @date 2020-05-22 21:30
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, ProjectEntity> implements IProjectService {

    @Autowired
    private INodeService nodeService;
    @Autowired
    private ILineService lineService;

    @Override
    public ProjectVo queryData(String projectId) {
        ProjectEntity projectEntity = getById(projectId);
        if (projectEntity == null) {
            throw new IllegalArgumentException("项目不存在");
        }
        List<NodeEntity> nodeList = nodeService.queryByProjectId(projectId);
        List<LineEntity> lineList = lineService.queryByProjectId(projectId);
        ProjectVo projectVo = new ProjectVo();
        projectVo.setName(projectEntity.getName());
        projectVo.setNodeList(nodeList);
        projectVo.setLineList(lineList);
        return projectVo;
    }

    @Override
    public void delete(String projectId) {
        removeById(projectId);
        nodeService.deleteByProjectId(projectId);
        lineService.deleteByProjectId(projectId);
    }
}
