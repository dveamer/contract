package com.dveamer.contract.comment.stub;


import com.dveamer.contract.comment.CommentDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommentFixture {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static List<CommentDto> commentList1() {
        return new ArrayList<>(Arrays.asList(comment1(), comment3()));
    }

    public static List<CommentDto> commentList2() {
        return new ArrayList<>(Arrays.asList(comment2(), comment4()));
    }

    public static CommentDto comment1() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,20,13,20,5);
        return new CommentDto("u0001", "user01", createdAt.format(formatter), createdAt.format(formatter));
    }

    public static CommentDto comment2() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,21,15,22,5);
        return new CommentDto("u0002", "user02", createdAt.format(formatter), createdAt.plusDays(3).format(formatter));
    }

    public static CommentDto comment3() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,22,17,20,5);
        return new CommentDto("u0001", "user01", createdAt.format(formatter), createdAt.plusDays(3).format(formatter));
    }

    public static CommentDto comment4() {
        LocalDateTime createdAt = LocalDateTime.of(2020, 3 ,23,18,21,5);
        return new CommentDto("u0004", "user04", createdAt.format(formatter), createdAt.format(formatter));
    }
}
