package com.dveamer.contract.comment;

public class ArticleCommentCountDto {
    private String articleId;
    private int commentCount;


    public ArticleCommentCountDto() {
    }

    public ArticleCommentCountDto(String articleId, int commentCount) {
        this.articleId = articleId;
        this.commentCount = commentCount;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getArticleId() {
        return articleId;
    }

    public int getCommentCount() {
        return commentCount;
    }

    @Override
    public String toString() {
        return "ArticleCommentCountDto{" +
                "articleId='" + articleId + '\'' +
                ", commentCount=" + commentCount +
                '}';
    }
}
