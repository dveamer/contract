package com.dveamer.comment.web;

import com.dveamer.comment.component.Article;
import com.dveamer.comment.component.Comment;
import com.dveamer.comment.component.CommentService;
import com.dveamer.comment.component.ConditionVo;
import com.dveamer.contract.comment.ArticleCommentCountDto;
import com.dveamer.contract.comment.CommentContract;
import com.dveamer.contract.comment.CommentDto;
import com.dveamer.contract.comment.ConditionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentController implements CommentContract {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final CommentService commentService;

    CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    @GetMapping("/articles/{articleId}/comments")
    public List<CommentDto> loadCommentsByArticleId(@PathVariable("articleId") String articleId) {
        List<Comment> comments = commentService.loadCommentsByArticleId(articleId);
        return comments.stream().map(c->convertFromCommentToCommentDto(c)).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/articles")
    public List<ArticleCommentCountDto> loadArticleIdHavingNumerousComments(ConditionDto conditionDto) {
        ConditionVo conditionVo = convertFromConditionDtoToConditionVo(conditionDto);
        List<Article> articles = commentService.loadArticleIdHavingNumerousComments(conditionVo);
        return articles.stream().map(a->convertFromArticleToArticleCommentCountDto(a)).collect(Collectors.toList());
    }

    private CommentDto convertFromCommentToCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setWriterId(comment.getWriterId());
        commentDto.setWriterName(comment.getWriterName());
        commentDto.setCreatedAt(comment.getCreatedAt().format(formatter));
        commentDto.setModifiedAt(comment.getModifiedAt().format(formatter));
        return commentDto;
    }
    private ArticleCommentCountDto convertFromArticleToArticleCommentCountDto(Article article) {
        ArticleCommentCountDto articleCommentCountDto = new ArticleCommentCountDto();
        articleCommentCountDto.setArticleId(article.getArticleId());
        articleCommentCountDto.setCommentCount(article.getComments().size());
        return articleCommentCountDto;
    }
    private ConditionVo convertFromConditionDtoToConditionVo(ConditionDto conditionDto) {
        ConditionVo conditionVo = new ConditionVo();
        conditionVo.setBeforeDays(conditionDto.getBeforeDays());
        conditionVo.setBeforeWeeks(conditionDto.getBeforeWeeks());
        conditionVo.setBiggerThan(conditionDto.getBiggerThan());
        return conditionVo;
    }

}
