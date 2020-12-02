package com.example.bpmneasyflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bpmneasyflow.entity.NodeEntity;

import java.util.List;

/**
 * @author liuchengbiao
 * @date 2020-05-22 21:28
 */
public interface INodeService extends IService<NodeEntity> {
    /**
     * 根据项目ID查询所有的节点
     *
     * @param projectId
     * @return
     */
    List<NodeEntity> queryByProjectId(String projectId);

    void deleteByProjectId(String projectId);

    /**
     * 更改坐标
     *
     * @param nodeId
     * @param left
     * @param top
     */
    void changeSite(String nodeId, String left, String top);

    /**
     * 删除
     *
     * @param nodeId
     */
    void delete(String nodeId);
}
