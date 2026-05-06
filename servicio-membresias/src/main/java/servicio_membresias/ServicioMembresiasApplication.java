package cl.gimnasio.membresias.demo.membresias.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
public class ServicioMembresiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioMembresiasApplication.class, args);
	}

}
