package io.github.bishion.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: guofangbi
 * @version: 1.0.0
 * @since 2022/7/2-19:17
 */
@EnableSwagger2
@Order(Integer.MIN_VALUE)
@PropertySource(value = "classpath:swagger.yml", factory = YamlPropertySourceFactory.class)
public class SwaggerConfiguration {
    @Value("${swagger.basePackage}")
    private String basePackage;
    @Value("${swagger.title}")
    private String title;
    @Value("${swagger.description}")
    private String description;
    @Value("${swagger.version:1.0.0}")
    private String version;
    @Value("${swagger.groupName:默认分组}")
    private String groupName;
    @Value("${swagger.maintainer:默认维护人}")
    private String maintainer;
    @Value("${swagger.termsOfServiceUrl:默认条款地址}")
    private String termsOfServiceUrl;
    @Value("${swagger.maintainerMail:null}")
    private String maintainerMail;
    @Value("${swagger.maintainerUrl:null}")
    private String maintainerUrl;

    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).groupName(groupName).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(maintainer, maintainerUrl, maintainerMail))
                .version(version)
                .build();
    }
}
