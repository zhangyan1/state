package com.shinemo.score.core.user.service;

import com.shinemo.client.common.ListVO;
import com.shinemo.score.client.comment.domain.CommentDO;
import com.shinemo.score.client.comment.query.CommentQuery;
import com.shinemo.score.client.comment.query.CommentRequest;

/**
 * 评论服务
 *
 * @author wenchao.li
 * @since 2019-06-06
 */
public interface CommentService {


    /**
     * 创建评论
     *
     * @param request
     */
    CommentDO create(CommentRequest request);

    /**
     * @param commentId 评论id
     * @return 根据评论id查找评论
     */
    CommentDO getById(Long commentId);

    /**
     * @return 查询评论
     */
    CommentDO getByQuery(CommentQuery query);


    /**
     * @return 查询评论列表
     */
    ListVO<CommentDO> findByQuery(CommentQuery query);

}
