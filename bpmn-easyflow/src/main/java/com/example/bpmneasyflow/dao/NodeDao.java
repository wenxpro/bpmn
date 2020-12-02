package com.example.bpmneasyflow.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bpmneasyflow.entity.NodeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuchengbiao
 * @date 2020-05-22 21:26
 */
@Mapper
public interface NodeDao extends BaseMapper<NodeEntity> {
}
