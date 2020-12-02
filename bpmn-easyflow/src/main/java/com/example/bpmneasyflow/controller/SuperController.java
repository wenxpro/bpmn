package com.example.bpmneasyflow.controller;


import com.example.bpmneasyflow.vo.R;

/**
 * @author liuchengbiao
 * @date 2020-05-23 21:10
 */
public class SuperController<T> {

    public R<T> success() {
        R<T> r = new R();
        r.setCode(0);
        return r;
    }

    public R<T> success(T data) {
        R<T> r = new R();
        r.setCode(0);
        r.setData(data);
        return r;
    }

    public R<T> error(Integer code) {
        R<T> r = new R();
        r.setCode(code == null ? 500 : code);
        r.setDesc("服务器异常");
        return r;
    }

    public R<T> error(Integer code, String desc) {
        R<T> r = new R();
        r.setCode(code == null ? 500 : code);
        r.setDesc(desc);
        return r;
    }

}
