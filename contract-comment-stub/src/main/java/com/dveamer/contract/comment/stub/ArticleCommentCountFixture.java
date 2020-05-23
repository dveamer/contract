package com.dveamer.contract.comment.stub;

import com.dveamer.contract.comment.ArticleCommentCountDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArticleCommentCountFixture {

    public static ArticleCommentCountDto articleCommentCount1() {
        return new ArticleCommentCountDto("A0001", 3);
    }

    public static ArticleCommentCountDto articleCommentCount2() {
        return new ArticleCommentCountDto("A0010", 10);
    }

    public static ArticleCommentCountDto articleCommentCount3() {
        return new ArticleCommentCountDto("A0012", 8);
    }

    public static List<ArticleCommentCountDto> articleCommentCountList(final int biggerThan, final int beforeDays) {

        ArticleCommentCountDto ac1 = articleCommentCount1();
        ArticleCommentCountDto ac2 = articleCommentCount2();
        ArticleCommentCountDto ac3 = articleCommentCount3();

        List<ArticleCommentCountDto> list = new ArrayList<>();
        list.add(ac1);
        list.add(ac2);
        list.add(ac3);

        list = list.stream().filter(a->a.getCommentCount()>biggerThan).collect(Collectors.toList());

        if(beforeDays<10 && list.contains(ac2)) {
            list.remove(ac2);
        }

        return list;
    }

}
