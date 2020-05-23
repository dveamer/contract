package com.dveamer.contract.comment.stub;

import com.dveamer.contract.comment.ArticleCommentCountDto;
import com.dveamer.contract.comment.CommentContract;
import com.dveamer.contract.comment.CommentDto;
import com.dveamer.contract.comment.ConditionDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentContractStub implements CommentContract {

    @Override
    public List<CommentDto> loadCommentsByArticleId(String articleId) {
        if(articleId.equals(ArticleFixture.articleId1())) {
            return CommentFixture.commentList1();
        }

        return CommentFixture.commentList2();
    }

    @Override
    public List<ArticleCommentCountDto> loadArticleIdHavingNumerousComments(ConditionDto conditionDto) {
        return ArticleCommentCountFixture.articleCommentCountList(conditionDto.getBiggerThan(), conditionDto.getBeforeDays());
    }

}
