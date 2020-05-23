package com.dveamer.article.component;

import com.dveamer.contract.comment.CommentContract;
import com.dveamer.contract.comment.ConditionDto;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final CommentContract commentContract;

    ArticleServiceImpl(CommentContract commentContract) {
        this.commentContract = commentContract;
    }

    @Override
    public int loadCountOfComments(String articleId) {
        return commentContract.loadCommentsByArticleId(articleId).size();
    }

    @Override
    public int loadCountOfFamousArticle() {
        ConditionDto conditionDto = new ConditionDto();
        conditionDto.setBiggerThan(2);
        conditionDto.setBeforeDays(3);
        return commentContract.loadArticleIdHavingNumerousComments(conditionDto).size();
    }
}
