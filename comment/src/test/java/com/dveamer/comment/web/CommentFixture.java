package com.dveamer.comment.web;

import com.dveamer.comment.component.Article;
import com.dveamer.comment.component.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentFixture {

    public static Comment createComment1() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,20,13,20,5);
        return new Comment("u0001", "user01", createdAt, createdAt);
    }

    public static Comment createComment2() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,21,15,22,5);
        return new Comment("u0002", "user02", createdAt, createdAt.plusDays(3));
    }

    public static Comment createComment3() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,22,17,20,5);
        return new Comment("u0001", "user01", createdAt, createdAt.plusDays(3));
    }

    public static Comment createComment4() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,23,18,21,5);
        return new Comment("u0004", "user04", createdAt, createdAt);
    }


    public static Article articleCommentCount1() {
        return createArticle("A0001", 3);
    }

    public static Article articleCommentCount2() {
        return createArticle("A0010", 10);
    }

    public static Article articleCommentCount3() {
        return createArticle("A0012", 8);
    }

    public static Article createArticle(String articleId, int commentCount) {
        List<Comment> comments = new ArrayList<>();
        for(int i=0; i<commentCount; i++) {
            comments.add(createComment1());
        }
        return new Article(articleId, comments);
    }

}
