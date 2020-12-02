package com.example.bpmneasyflow.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bpmneasyflow.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuchengbiao
 * @date 2020-05-22 21:26
 */
@Mapper
public interface ProjectDao extends BaseMapper<ProjectEntity> {
}
