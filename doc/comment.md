## 评论，回复、赞方案

- **网络类型需要由客户端提供** 


![赞流程](image/miku_zan.png)


#### 表结构设计

评论表
```sql

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gmt_create`   datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `status` int  NOT NULL COMMENT '删除状态 1-正常 0-删除',
  `movie_id` varchar(128) not null comment '外部电影id',
  `movie_type` int  NOT NULL COMMENT '视频类型',
  `content` text  NOT NULL COMMENT '评论内容',
  `like_num` bigint  NOT NULL DEFAULT '0' COMMENT '赞数量',
  `uid`   bigint not null comment '用户id',
  `mobile`   bigint not null comment '手机号码',
  `name` varchar(256) DEFAULT null comment '用户名称',
  `avatar_url` varchar(256) DEFAULT null comment '头像',
  `device` varchar(80) DEFAULT null comment '设备',
  `net_type` varchar(80) DEFAULT null comment '网络类型',
  `sort` int default '0' comment '排序权重',
  `extend` text DEFAULT null comment '扩展字段',
  `history_reply` text DEFAULT null comment '最近的回复(最近3条)',
  `version` bigint not null default '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  KEY `idx_m_u` (`movie_id`,`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='评论表';

```

回复表

```sql
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gmt_create`   datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `status` int  NOT NULL COMMENT '删除状态 1-正常 0-删除',
  `comment_id`   bigint not null comment '主评论id',
  `content` text  NOT NULL COMMENT '回复内容',
  `uid`   bigint not null comment '用户id',
  `mobile`   bigint not null comment '手机号码',
  `name` varchar(256) DEFAULT null comment '用户名称',
  `avatar_url` varchar(256) DEFAULT null comment '头像',
  `device` varchar(80) DEFAULT null comment '设备',
  `net_type` varchar(80) DEFAULT null comment '网络类型',
  `extend` text DEFAULT null comment '扩展字段',
  PRIMARY KEY (`id`),
  key `idx_c_u`(`comment_id`,`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='回复表';

```

赞记录表

```sql

DROP TABLE IF EXISTS `like_log`;
CREATE TABLE `like_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gmt_create`   datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `comment_id`   bigint not null comment '主评论id',
  `uid`   bigint not null comment '用户id',
  `type`  int not null comment '1.赞 2.取消赞',
  PRIMARY KEY (`id`),
  UNIQUE key `uk_c_u`(`comment_id`,`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='赞记录表';


```