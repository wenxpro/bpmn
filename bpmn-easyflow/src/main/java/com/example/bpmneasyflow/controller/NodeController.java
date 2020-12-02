package com.example.bpmneasyflow.controller;

import com.example.bpmneasyflow.entity.NodeEntity;
import com.example.bpmneasyflow.service.INodeService;
import com.example.bpmneasyflow.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuchengbiao
 * @date 2020-05-23 20:34
 */
@RestController
@RequestMapping("/node")
public class NodeController extends SuperController<NodeEntity> {

    @Autowired
    private INodeService nodeService;

    @GetMapping("/{id}")
    public R save(@PathVariable("id") String id) {
        NodeEntity nodeEntity = nodeService.getById(id);
        return success(nodeEntity);
    }

    /**
     * 新增
     *
     * @param node
     * @return
     */
    @PostMapping
    public R save(@RequestBody NodeEntity node) {
        nodeService.save(node);
        return success();
    }

    /**
     * 更新
     *
     * @param node
     * @return
     */
    @PutMapping
    public R update(@RequestBody NodeEntity node) {
        nodeService.updateById(node);
        return success();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") String id) {
        nodeService.delete(id);
        return success();
    }

    /**
     * 更改位置坐标
     *
     * @param node
     * @return
     */
    @PutMapping("/changeSite")
    public R changeSite(@RequestBody NodeEntity node) {
        nodeService.changeSite(node.getId(), node.getLeft(), node.getTop());
        return success();
    }
}
