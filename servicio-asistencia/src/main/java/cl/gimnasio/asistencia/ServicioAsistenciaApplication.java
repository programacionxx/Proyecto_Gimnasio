package cl.gimnasio.asistencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServicioAsistenciaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioAsistenciaApplication.class, args);
    }
}
