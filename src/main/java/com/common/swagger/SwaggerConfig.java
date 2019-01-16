package com.common.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.apache.commons.lang3.StringUtils;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger2.host:none}")
    private String host;

    @Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com"))
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any()).build();
        if (!StringUtils.equals(host, "none")) {
            docket.host(host);
        }
        return  docket;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("电话簿 Api").description("").termsOfServiceUrl("").version("1.0").build();
    }

}