package br.com.helo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author <a href="mailto:andrews.silva@accenture.com">andrews.silva</a>
 * @date 21 de set de 2017 10:41:46
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return Docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.helo.controller")).paths(PathSelectors.any()).build()
				.apiInfo(this.apiInfo());
	}

	/**
	 *
	 * <code><pre></pre></code>
	 *
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger API").description("Documentação da API de acesso aos endpoints com Swagger")
				.version("1.0").build();
	}

}
