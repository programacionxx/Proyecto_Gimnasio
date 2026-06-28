package cl.gimnasio.clases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServicioClasesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioClasesApplication.class, args);
    }
}
