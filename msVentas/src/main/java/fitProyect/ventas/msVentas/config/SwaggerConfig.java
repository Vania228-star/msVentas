package fitProyect.ventas.msVentas.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Fit Project Sales Service API")
                .description("RESTful API para la comercialización y adquisición de tickets de gimnasios modulares.")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Fit Project Sales Team")
                    .email("sales@fitproject.com")
                    .url("https://fitproject.com")))
            .servers(List.of(
                new Server()
                    .url("http://localhost:8080/api")
                    .description("Development Server (Local)")
            ));
    }
}