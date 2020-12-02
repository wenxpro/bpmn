package com.example.bpmneasyflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xioaka.easy.flow.sdk.dao.NodeDao;
import com.xioaka.easy.flow.sdk.entity.NodeEntity;
import com.xioaka.easy.flow.sdk.service.ILineService;
import com.xioaka.easy.flow.sdk.service.INodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuchengbiao
 * @date 2020-05-22 21:30
 */
@Service
public class NodeServiceImpl extends ServiceImpl<NodeDao, NodeEntity> implements INodeService {

    @Autowired
    private ILineService lineService;

    @Override
    public List<NodeEntity> queryByProjectId(String projectId) {
        LambdaQueryWrapper<NodeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(NodeEntity::getProjectId, projectId);
        return list(queryWrapper);
    }

    @Override
    public void deleteByProjectId(String projectId) {
        LambdaQueryWrapper<NodeEntity> deleteWrapper = new LambdaQueryWrapper<>();
        deleteWrapper.eq(NodeEntity::getProjectId, projectId);
        remove(deleteWrapper);
    }

    @Override
    public void changeSite(String nodeId, String left, String top) {
        LambdaUpdateWrapper<NodeEntity> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(NodeEntity::getLeft, left).set(NodeEntity::getTop, top).eq(NodeEntity::getId, nodeId);
        update(updateWrapper);
    }

    @Override
    public void delete(String nodeId) {
        LambdaQueryWrapper<NodeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(NodeEntity::getId, nodeId);
        remove(queryWrapper);
        lineService.deleteByNodeId(nodeId);
    }
}
