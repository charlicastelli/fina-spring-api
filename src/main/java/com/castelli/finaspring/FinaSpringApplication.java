package com.castelli.finaspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.castelli.finaspring.model.Fina;
import com.castelli.finaspring.repository.FinaRepository;

@SpringBootApplication
public class FinaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinaSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(FinaRepository finaRepository) {
		return args -> {
			finaRepository.deleteAll();

			Fina test = new Fina();
			test.setCredit(100.0);
			test.setDescription("Aluguel");
			test.setCategory("Moradia");

			finaRepository.save(test);
		};
	}

}
