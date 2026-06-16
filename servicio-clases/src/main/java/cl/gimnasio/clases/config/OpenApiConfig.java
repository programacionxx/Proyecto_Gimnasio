package cl.gimnasio.clases.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
public OpenAPI claseOpenAPI() {
    return new OpenAPI()
            .info(new Info()
                    .title("Microservicio de Gestión de Clases")
                    .version("1.0.0")
                    .description("Microservicio encargado de administrar las clases y actividades disponibles en el gimnasio."));
}
}
