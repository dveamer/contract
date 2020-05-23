package com.dveamer.comment.component;

import java.time.LocalDateTime;

public class Comment {

    private String writerId;
    private String writerName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Comment(String writerId, String writerName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.writerId = writerId;
        this.writerName = writerName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public String getWriterId() {
        return writerId;
    }

    public String getWriterName() {
        return writerName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
}
