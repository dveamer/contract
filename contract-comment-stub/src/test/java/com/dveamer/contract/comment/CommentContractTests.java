package com.dveamer.contract.comment;

import com.dveamer.contract.comment.stub.ArticleCommentCountFixture;
import com.dveamer.contract.comment.stub.ArticleFixture;
import com.dveamer.contract.comment.stub.CommentContractStub;
import com.dveamer.contract.comment.stub.ConditionFixture;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.util.List;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.core.Is.is;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommentContractTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private CommentContract commentContract;

	@BeforeAll
	void setup() {
//		commentContract = new CommentContractStub();
		Properties properties = System.getProperties();
		String url = properties.getProperty("api.contract.comment.url");
		commentContract = Feign.builder()
				.contract(new SpringMvcContract())
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(CommentContract.class, url);
	}

	@Test
	void loadCommentsByArticleIdTest() {
		List<CommentDto> expectedList = new CommentContractStub().loadCommentsByArticleId(ArticleFixture.articleId1());
		List<CommentDto> actualList = commentContract.loadCommentsByArticleId(ArticleFixture.articleId1());
		assertThat(actualList, is(samePropertyValuesAs(expectedList)));
	}

	@Test
	void loadArticleIdHavingNumerousCommentsTest() {
		ConditionDto condition = ConditionFixture.conditionDto();
		List<ArticleCommentCountDto> expectedList = ArticleCommentCountFixture.articleCommentCountList(condition.getBiggerThan(), condition.getBeforeDays());
		List<ArticleCommentCountDto> actualList = commentContract.loadArticleIdHavingNumerousComments(condition);
		assertThat(actualList, is(samePropertyValuesAs(expectedList)));
	}

}
