package com.dveamer.comment.component;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
class CommentServiceImpl implements CommentService {

    @Override
    public List<Comment> loadCommentsByArticleId(String articleId) {
        return loadCommentsByArticle0(articleId);
    }

    @Override
    public List<Article> loadArticleIdHavingNumerousComments(ConditionVo conditionVo) {
        return loadArticleIdHavingNumerousComments(conditionVo.getBiggerThan(), conditionVo.getBeforeDays());
    }

    private List<Comment> loadCommentsByArticle0(String articleId) {
        if("A0001".equals(articleId)) {
            return Arrays.asList(createComment1(), createComment3());
        }
        return Arrays.asList(createComment2(), createComment4());
    }

    private Comment createComment1() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,20,13,20,5);
        return new Comment("u0001", "user01", createdAt, createdAt);
    }

    private Comment createComment2() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,21,15,22,5);
        return new Comment("u0002", "user02", createdAt, createdAt.plusDays(3));
    }

    private Comment createComment3() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,22,17,20,5);
        return new Comment("u0001", "user01", createdAt, createdAt.plusDays(3));
    }

    private Comment createComment4() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,23,18,21,5);
        return new Comment("u0004", "user04", createdAt, createdAt);
    }

    private List<Article> loadArticleIdHavingNumerousComments(final int biggerThan, final int beforeDays) {
        Article ac1 = articleCommentCount1();
        Article ac2 = articleCommentCount2();
        Article ac3 = articleCommentCount3();

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

    private Article articleCommentCount1() {
        return createArticle("A0001", 3);
    }

    private Article articleCommentCount2() {
        return createArticle("A0010", 10);
    }

    private Article articleCommentCount3() {
        return createArticle("A0012", 8);
    }

    private Article createArticle(String articleId, int commentCount) {
        List<Comment> comments = new ArrayList<>();
        for(int i=0; i<commentCount; i++) {
            comments.add(createComment1());
        }
        return new Article(articleId, comments);
    }

}
