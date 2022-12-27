package com.gdsc.homework.firstAssignment.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    private final TypeResolver typeResolver;

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
//                .alternateTypeRules(
//                        AlternateTypeRules.newRule(typeResolver.resolve(Pageable.class), typeResolver.resolve(Page.class)))
                .useDefaultResponseMessages(false)
                .select()
                .apis(withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("gdsc backend")
                .description("요구사항 1차 API 명세서")
                .version("1.0.0")
                .build();
    }

//    @Getter
//    @ApiModel
//    static class Page {
//        @ApiModelProperty(value = "페이지 번호(0..N)", example = "0")
//        private Integer page;
//
//        @ApiModelProperty(value = "페이지 크기", allowableValues="range[0, 100]", example = "6")
//        private Integer size;
//
//        @ApiModelProperty(value = "정렬(사용법: 컬럼명,ASC|DESC)")
//        private List<String> sort;
//    }
}
