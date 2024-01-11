package seorin.org.practice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@OpenAPIDefinition(
        info = @Info(
                title = "Swagger Document",
                description = "Seorin Spring Swagger Practice",
                version = "v1")
)
*/
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Swagger Document")
                .description("Seorin Spring Swagger Practice")
                .version("v1");
//        GroupedOpenApi
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
