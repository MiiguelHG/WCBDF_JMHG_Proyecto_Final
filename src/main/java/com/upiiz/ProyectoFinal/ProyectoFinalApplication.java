package com.upiiz.ProyectoFinal;

import com.upiiz.ProyectoFinal.entities.UserEntity;
import com.upiiz.ProyectoFinal.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@SpringBootApplication
public class ProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			UserEntity admin = UserEntity
					.builder()
					.username("Admin")
					.password("1234")
					.build();

			UserEntity user = UserEntity
					.builder()
					.username("User")
					.password("1234")
					.build();

			UserEntity moderator = UserEntity
					.builder()
					.username("Moderator")
					.password("1234")
					.build();

			UserEntity editor = UserEntity
					.builder()
					.username("Editor")
					.password("1234")
					.build();

			UserEntity developer = UserEntity
					.builder()
					.username("Developer")
					.password("1234")
					.build();

			UserEntity analyst = UserEntity
					.builder()
					.username("Analyst")
					.password("1234")
					.build();

			userRepository.saveAll(List.of(admin, user, moderator, editor, developer, analyst));
		};
	}

}
