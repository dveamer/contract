package com.dveamer.comment.component;

import java.util.List;

public interface CommentService {

    List<Comment> loadCommentsByArticleId(String articleId);

    List<Article> loadArticleIdHavingNumerousComments(ConditionVo conditionVo);
}
