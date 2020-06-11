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

    String PV_articleId = "articleId";

    String PATH_loadCommentsByArticleId = "/articles/{articleId}/comments";
    @GetMapping(path= PATH_loadCommentsByArticleId)
    List<CommentDto> loadCommentsByArticleId(@PathVariable(PV_articleId) String articleId);

    String PATH_loadArticleIdHavingNumerousComments = "/articles";
    @GetMapping(path= PATH_loadArticleIdHavingNumerousComments)
    List<ArticleCommentCountDto> loadArticleIdHavingNumerousComments(@SpringQueryMap ConditionDto conditionDto);

}
