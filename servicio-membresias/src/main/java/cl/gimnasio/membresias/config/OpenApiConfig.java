package cl.gimnasio.membresias.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI membresiasOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Servicio de Membresías")
                        .version("1.0.0")
                        .description("API para gestión de membresías del gimnasio")
                        .license(new License().name("MIT").url("https://opensource.org/licenses/MIT")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación del sistema de microservicios")
                        .url("https://example.com/docs"));
    }
}
