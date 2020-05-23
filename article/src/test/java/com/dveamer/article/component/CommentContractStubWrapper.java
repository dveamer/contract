package com.dveamer.article.component;

import com.dveamer.contract.comment.ArticleCommentCountDto;
import com.dveamer.contract.comment.CommentDto;
import com.dveamer.contract.comment.ConditionDto;
import com.dveamer.contract.comment.stub.CommentContractStub;
import com.dveamer.contract.comment.stub.ConditionFixture;

import java.util.List;

public class CommentContractStubWrapper extends CommentContractStub {

    private boolean loadCommentsByArticleId_wasCalled = false;
    private boolean loadArticleIdHavingNumerousComments_wasCalled = false;

    public boolean loadCommentsByArticleId_wasCalled() {
        return loadCommentsByArticleId_wasCalled;
    }

    public boolean loadArticleIdHavingNumerousComments_wasCalled() {
        return loadArticleIdHavingNumerousComments_wasCalled;
    }

    @Override
    public List<CommentDto> loadCommentsByArticleId(String articleId) {
        loadCommentsByArticleId_wasCalled = true;
        return super.loadCommentsByArticleId(articleId);
    }

    @Override
    public List<ArticleCommentCountDto> loadArticleIdHavingNumerousComments(ConditionDto conditionDto) {
        loadArticleIdHavingNumerousComments_wasCalled = true;
        return super.loadArticleIdHavingNumerousComments(ConditionFixture.conditionDto());
    }
}
