package cl.gimnasio.socios.demo.socios.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
public class ServicioSociosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioSociosApplication.class, args);
	}

}
