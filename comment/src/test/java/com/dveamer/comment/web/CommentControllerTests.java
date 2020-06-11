package com.dveamer.comment.web;

import com.dveamer.comment.JsonConverterUtil;
import com.dveamer.contract.comment.ArticleCommentCountDto;
import com.dveamer.contract.comment.CommentContract;
import com.dveamer.contract.comment.CommentDto;
import com.dveamer.contract.comment.ConditionDto;
import com.dveamer.contract.comment.stub.ArticleFixture;
import com.dveamer.contract.comment.stub.CommentContractStub;
import com.dveamer.contract.comment.stub.ConditionFixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommentControllerTests {

	private MockMvc mockMvc;
	private CommentServiceStub commentService;

	@BeforeAll
	public void setup() {
		commentService= new CommentServiceStub();
		mockMvc = MockMvcBuilders.standaloneSetup(new CommentController(commentService)).build();
	}


	@Test
	public void loadCommentsByArticleId_success() throws Exception {
		List<CommentDto> expectedCommentDtoList = new CommentContractStub().loadCommentsByArticleId(ArticleFixture.articleId1());
		mockMvc.perform(get(CommentContract.PATH_loadCommentsByArticleId, ArticleFixture.articleId1()))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(JsonConverterUtil.toJson(expectedCommentDtoList)));

		assertThat(commentService.loadCommentsByArticleId_wasCalled(), equalTo(true));
	}

	@Test
	public void loadArticleIdHavingNumerousComments_success() throws Exception {
		ConditionDto condition = ConditionFixture.conditionDto();
		List<ArticleCommentCountDto> expectedArticleCommentCountDtoList = new CommentContractStub().loadArticleIdHavingNumerousComments(condition);
		mockMvc.perform(get(CommentContract.PATH_loadArticleIdHavingNumerousComments)
							.queryParam("beforeDays", Integer.toString(condition.getBeforeDays()))
							.queryParam("biggerThan", Integer.toString(condition.getBiggerThan())))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(JsonConverterUtil.toJson(expectedArticleCommentCountDtoList)));

		assertThat(commentService.loadArticleIdHavingNumerousComments_wasCalled(), equalTo(true));
	}

}
