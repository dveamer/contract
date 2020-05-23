package com.dveamer.article.component;

import com.dveamer.contract.comment.stub.ArticleFixture;
import com.dveamer.contract.comment.stub.CommentContractStub;
import com.dveamer.contract.comment.stub.ConditionFixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArticleServiceTests {

	private CommentContractStubWrapper commentContract;
	private ArticleService articleService;

	@BeforeAll
	public void setup() {
		commentContract= new CommentContractStubWrapper();
		articleService = new ArticleServiceImpl(commentContract);
	}

	@Test
	public void loadCountOfComments_success() throws Exception {
		int expectedValue = new CommentContractStub().loadCommentsByArticleId(ArticleFixture.articleId1()).size();
		int actualValue = articleService.loadCountOfComments(ArticleFixture.articleId1());
		assertThat(actualValue, equalTo(expectedValue));

		assertThat(commentContract.loadCommentsByArticleId_wasCalled(), equalTo(true));
	}

	@Test
	public void loadArticleIdHavingNumerousComments_success() throws Exception {
		int expectedValue = new CommentContractStub().loadArticleIdHavingNumerousComments(ConditionFixture.conditionDto()).size();
		int actualValue = articleService.loadCountOfFamousArticle();
		assertThat(actualValue, equalTo(expectedValue));

		assertThat(commentContract.loadArticleIdHavingNumerousComments_wasCalled(), equalTo(true));
	}

}
