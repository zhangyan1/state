package com.shinemo.score.client.video.query;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.shinemo.client.common.QueryBase;

/**
 * 查询类
 * @ClassName: VideoQuery
 * @author zhangyan
 * @Date 2019-06-12 09:51:48
 */
@Getter
@Setter
public class VideoQuery extends QueryBase {
	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
    /**
    * 删除状态 1-正常 0-删除
    */
	private Integer status;
    /**
    * 视频id
    */
	private String videoId;
    /**
    * 视频类型
    */
	private Integer videoType;
    /**
    * 视频名称
    */
	private String videoName;
    /**
    * 初始分数
    */
	private Long initScore;
    /**
    * 初始权重(人数)
    */
	private Long initWeight;
    /**
    * 当前电影分数
    */
	private Long score;
    /**
    * 当前权重
    */
	private Long weight;
    /**
    * 昨日分数
    */
	private Long yesterdayScore;
    /**
    * 昨日权重
    */
	private Long yesterdayWeight;
    /**
    * 视频扩展信息
    */
	private String extend;
    /**
    * 版本
    */
	private Long version;
    /**
    * 标位 1-是否支持评分
    */
	private Long flag;
}