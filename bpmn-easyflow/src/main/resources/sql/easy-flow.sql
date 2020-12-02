DROP TABLE IF EXISTS `flow_project`;
CREATE TABLE `flow_project` (
  `id` varchar(64) NOT NULL COMMENT 'ID',
  `name` varchar(100) NOT NULL COMMENT '项目名称',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `flow_node`;
CREATE TABLE `flow_node` (
  `id` varchar(64) NOT NULL COMMENT 'ID',
  `project_id` varchar(64) NOT NULL COMMENT '项目ID',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `left` varchar(100) NOT NULL COMMENT '坐标',
  `top` varchar(100) NOT NULL COMMENT '坐标',
  `ico` varchar(100) NOT NULL COMMENT '图标',
  `state` varchar(100) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `flow_line`;
CREATE TABLE `flow_line` (
  `id` varchar(64) NOT NULL COMMENT 'ID',
  `project_id` varchar(64) NOT NULL COMMENT '项目ID',
  `from` varchar(64) NOT NULL COMMENT '开始节点ID',
  `to` varchar(64) NOT NULL COMMENT '结束节点ID',
  `label` varchar(100) NOT NULL COMMENT '条件',
  PRIMARY KEY (`id`),
  unique  key  `uni_line`(`from`,`to`)
);