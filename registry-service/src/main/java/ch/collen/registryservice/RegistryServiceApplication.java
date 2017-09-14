package ch.collen.registryservice;

import org.apache.el.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties
public class RegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner runner (CaisseRestRepository caisseRestRepository) {
		return args -> java.util.stream.Stream.of("CaisseBerne", "CaisseGenf", "CaisseZurich")
				.map(s -> new Caisse(s, null))
				.peek(System.out::println)
				.forEach(caisseRestRepository::save);
	}


}
