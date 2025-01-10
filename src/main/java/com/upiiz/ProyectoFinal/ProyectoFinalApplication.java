package com.upiiz.ProyectoFinal;

import com.upiiz.ProyectoFinal.entities.InvoiceEntity;
import com.upiiz.ProyectoFinal.entities.UserEntity;
import com.upiiz.ProyectoFinal.repositories.InvoiceRepository;
import com.upiiz.ProyectoFinal.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;

import java.sql.Date;
import java.util.List;

@SpringBootApplication
public class ProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, InvoiceRepository invoiceRepository) {
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

			InvoiceEntity invoice1 = InvoiceEntity
					.builder()
					.invoiceDate(Date.valueOf("2021-10-01"))
					.amount(1050.25)
					.CustomerId(68L)
					.build();

			InvoiceEntity invoice2 = InvoiceEntity
					.builder()
					.invoiceDate(Date.valueOf("2024-05-02"))
					.amount(2520.99)
					.CustomerId(8L)
					.build();

			InvoiceEntity invoice3 = InvoiceEntity
					.builder()
					.invoiceDate(Date.valueOf("2024-11-11"))
					.amount(750.25)
					.CustomerId(30L)
					.build();

			InvoiceEntity invoice4 = InvoiceEntity
					.builder()
					.invoiceDate(Date.valueOf("2021-10-04"))
					.amount(2371.00)
					.CustomerId(123L)
					.build();

			InvoiceEntity invoice5 = InvoiceEntity
					.builder()
					.invoiceDate(Date.valueOf("2025-01-05"))
					.amount(590.75)
					.CustomerId(12L)
					.build();

			InvoiceEntity invoice6 = InvoiceEntity
					.builder()
					.invoiceDate(Date.valueOf("2024-12-28"))
					.amount(900.25)
					.CustomerId(44L)
					.build();

			invoiceRepository.saveAll(List.of(invoice1, invoice2, invoice3, invoice4, invoice5, invoice6));
		};
	}

}
