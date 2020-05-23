package com.dveamer.contract.comment;

public class CommentDto {
    private String writerId;
    private String writerName;
    private String createdAt;
    private String modifiedAt;

    public CommentDto() {
    }

    public CommentDto(String writerId, String writerName, String createdAt, String modifiedAt) {
        this.writerId = writerId;
        this.writerName = writerName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getWriterId() {
        return writerId;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "writerId='" + writerId + '\'' +
                ", writerName='" + writerName + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", modifiedAt='" + modifiedAt + '\'' +
                '}';
    }
}
