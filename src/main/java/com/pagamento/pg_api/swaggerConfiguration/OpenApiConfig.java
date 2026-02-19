package com.pagamento.pg_api.swaggerConfiguration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Pagamentos MercadoPago")
                        .version("1.0")
                        .description("API para processar pagamentos via MercadoPago usando Spring Boot"));
    }
}
