package com.dveamer.comment.component;

import java.util.List;

public class Article {

    private String articleId;
    private List<Comment> comments;

    public Article(String articleId, List<Comment> comments) {
        this.articleId = articleId;
        this.comments = comments;
    }

    public String getArticleId() {
        return articleId;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
