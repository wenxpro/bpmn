package com.example.bpmneasyflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bpmneasyflow.entity.LineEntity;

import java.util.List;

/**
 * @author liuchengbiao
 * @date 2020-05-22 21:28
 */
public interface ILineService extends IService<LineEntity> {
    /**
     * 获取项目的所有连线
     *
     * @param projectId
     * @return
     */
    List<LineEntity> queryByProjectId(String projectId);

    void deleteByProjectId(String projectId);

    /**
     * 根据起始节点删除
     *
     * @param from
     * @param to
     */
    void delete(String from, String to);

    /**
     * 根据节点删除
     *
     * @param nodeId
     */
    void deleteByNodeId(String nodeId);

    /**
     * 更新条件
     *
     * @param from
     * @param to
     * @param label
     */
    void changeLabel(String from, String to, String label);
}
