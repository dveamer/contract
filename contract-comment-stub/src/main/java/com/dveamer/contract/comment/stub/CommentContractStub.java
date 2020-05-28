package com.dveamer.contract.comment.stub;

import com.dveamer.contract.comment.ArticleCommentCountDto;
import com.dveamer.contract.comment.CommentContract;
import com.dveamer.contract.comment.CommentDto;
import com.dveamer.contract.comment.ConditionDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class CommentContractStub implements CommentContract {

    @Override
    @GetMapping(path="/articles/{articleId}/comments")
    public List<CommentDto> loadCommentsByArticleId(String articleId) {
            if(articleId.equals(ArticleFixture.articleId1())) {
            return CommentFixture.commentList1();
        }

        return CommentFixture.commentList2();
    }

    @Override
    @GetMapping(path="/articles")
    public List<ArticleCommentCountDto> loadArticleIdHavingNumerousComments(ConditionDto conditionDto) {
        return ArticleCommentCountFixture.articleCommentCountList(conditionDto.getBiggerThan(), conditionDto.getBeforeDays());
    }

}
