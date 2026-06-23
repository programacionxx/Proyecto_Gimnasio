package cl.gimnasio.notificaciones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI notificacionesOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Servicio de Notificaciones")
                        .version("1.0.0")
                        .description("API para gestión de notificaciones del gimnasio"));
    }
}
