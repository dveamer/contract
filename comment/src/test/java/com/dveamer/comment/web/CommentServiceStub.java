package com.dveamer.comment.web;

import com.dveamer.comment.component.Article;
import com.dveamer.comment.component.Comment;
import com.dveamer.comment.component.CommentService;
import com.dveamer.comment.component.ConditionVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommentServiceStub implements CommentService {

    private boolean loadCommentsByArticleId_wasCalled = false;
    private boolean loadArticleIdHavingNumerousComments_wasCalled = false;

    @Override
    public List<Comment> loadCommentsByArticleId(String articleId) {
        loadCommentsByArticleId_wasCalled = true;
        return loadCommentsByArticle0(articleId);
    }

    @Override
    public List<Article> loadArticleIdHavingNumerousComments(ConditionVo conditionVo) {
        loadArticleIdHavingNumerousComments_wasCalled = true;
        return loadArticleIdHavingNumerousComments(conditionVo.getBiggerThan(), conditionVo.getBeforeDays());
    }

    public boolean loadCommentsByArticleId_wasCalled() {
        return loadCommentsByArticleId_wasCalled;
    }

    public boolean loadArticleIdHavingNumerousComments_wasCalled() {
        return loadArticleIdHavingNumerousComments_wasCalled;
    }


    private List<Comment> loadCommentsByArticle0(String articleId) {
        if("A0001".equals(articleId)) {
            return Arrays.asList(CommentFixture.createComment1(), CommentFixture.createComment3());
        }
        return Arrays.asList(CommentFixture.createComment2(), CommentFixture.createComment4());
    }

    public List<Article> loadArticleIdHavingNumerousComments(final int biggerThan, final int beforeDays) {
        Article ac1 = CommentFixture.articleCommentCount1();
        Article ac2 = CommentFixture.articleCommentCount2();
        Article ac3 = CommentFixture.articleCommentCount3();

        List<Article> list = new ArrayList<>();
        list.add(ac1);
        list.add(ac2);
        list.add(ac3);

        list = list.stream().filter(a->a.getComments().size()>biggerThan).collect(Collectors.toList());
        if(beforeDays<10 && list.contains(ac2)) {
            list.remove(ac2);
        }

        return list;
    }


}
