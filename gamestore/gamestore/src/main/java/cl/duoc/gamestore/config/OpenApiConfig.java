package cl.duoc.gamestore.config;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api Gamestore")
                        .version("1.0.0")
                        .description("Documentacion de la API Gamestore para esta tienda de videjuegos puerto montt")
                        .contact(new Contact()
                                .name("Cristobal, Luxo")
                                .email("cr.valdebenitop@duocuc.cl")
                                .url("https://duoc.cl")

                        )
                );
    }
}
