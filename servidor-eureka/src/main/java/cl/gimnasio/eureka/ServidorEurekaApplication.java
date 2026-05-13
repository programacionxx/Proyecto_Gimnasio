package cl.gimnasio.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaServer
@SpringBootApplication
public class ServidorEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorEurekaApplication.class, args);
	}

}
