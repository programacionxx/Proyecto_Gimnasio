package cl.gimnasio.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServicioInventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioInventarioApplication.class, args);
    }
}
