package com.dveamer.contract.comment.stub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/*
* This SpringBootApplication is for Swagger Page of Contract.
* Boot this application and then go to localhost:8080/swagger-ui.html in browser.
* */

@EnableSwagger2
@SpringBootApplication
public class CommentContractStubApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentContractStubApplication.class, args);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Comment Contract")
                .description("Comment Contract - API Example")
                .build();
    }

    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("example")
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.dveamer.contract.comment.stub"))
                .paths(PathSelectors.ant("/**"))
                .build();
    }

}
