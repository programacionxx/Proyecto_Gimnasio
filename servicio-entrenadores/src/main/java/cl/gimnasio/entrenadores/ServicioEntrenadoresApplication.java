package cl.gimnasio.entrenadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServicioEntrenadoresApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioEntrenadoresApplication.class, args);
    }
}
