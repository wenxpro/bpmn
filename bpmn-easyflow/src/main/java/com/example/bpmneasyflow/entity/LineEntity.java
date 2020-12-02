package com.example.bpmneasyflow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuchengbiao
 * @date 2020-05-22 21:22
 */
@Data
@TableName("flow_line")
public class LineEntity {
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    private String projectId;
    @TableField(value = "`from`")
    private String from;
    @TableField(value = "`to`")
    private String to;
    private String label;
}
