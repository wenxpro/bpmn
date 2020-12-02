package com.example.bpmneasyflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xioaka.easy.flow.sdk.dao.LineDao;
import com.xioaka.easy.flow.sdk.entity.LineEntity;
import com.xioaka.easy.flow.sdk.service.ILineService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuchengbiao
 * @date 2020-05-22 21:30
 */
@Service
public class LineServiceImpl extends ServiceImpl<LineDao, LineEntity> implements ILineService {

    @Override
    public List<LineEntity> queryByProjectId(String projectId) {
        LambdaQueryWrapper<LineEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LineEntity::getProjectId, projectId);
        return list(queryWrapper);
    }

    @Override
    public void deleteByProjectId(String projectId) {
        LambdaQueryWrapper<LineEntity> deleteWrapper = new LambdaQueryWrapper<>();
        deleteWrapper.eq(LineEntity::getProjectId, projectId);
        remove(deleteWrapper);
    }

    @Override
    public void delete(String from, String to) {
        LambdaQueryWrapper<LineEntity> delWrapper = new LambdaQueryWrapper<>();
        delWrapper.eq(LineEntity::getFrom, from).eq(LineEntity::getTo, to);
        remove(delWrapper);
    }

    @Override
    public void deleteByNodeId(String nodeId) {
        LambdaQueryWrapper<LineEntity> delWrapper = new LambdaQueryWrapper<>();
        delWrapper.or().eq(LineEntity::getFrom, nodeId).or().eq(LineEntity::getTo, nodeId);
        remove(delWrapper);
    }

    @Override
    public void changeLabel(String from, String to, String label) {
        LambdaUpdateWrapper<LineEntity> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(LineEntity::getLabel, label).eq(LineEntity::getFrom, from).eq(LineEntity::getTo, to);
        update(updateWrapper);
    }
}
