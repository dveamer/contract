package com.dveamer.contract.comment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${api.contract.commentClient.name}"
        , url = "${api.contract.commentClient.url}"
        , contextId = "${api.contract.commentClient.contextId}")
public interface CommentContract {

    @GetMapping(path="/articles/{articleId}/comments")
    List<CommentDto> loadCommentsByArticleId(@PathVariable("articleId") String articleId);

    @GetMapping(path="/articles")
    List<ArticleCommentCountDto> loadArticleIdHavingNumerousComments(@SpringQueryMap ConditionDto conditionDto);

}
