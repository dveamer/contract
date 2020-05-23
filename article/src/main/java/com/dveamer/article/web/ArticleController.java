package com.dveamer.article.web;

import com.dveamer.article.component.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles/{articleId}/comments/count")
    public int loadCountOfComments(@PathVariable("articleId") String articleId) {
        return articleService.loadCountOfComments(articleId);
    }

    @GetMapping("/famous-articles/count")
    public int loadCountOfFamousArticle() {
        return articleService.loadCountOfFamousArticle();
    }


}
