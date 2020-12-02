package com.example.bpmneasyflow.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author liuchengbiao
 * @date 2020-05-23 21:09
 */
@Data
@Accessors(chain = true)
public class R<T> {
    private Integer code;
    private String desc;
    private T data;
}
