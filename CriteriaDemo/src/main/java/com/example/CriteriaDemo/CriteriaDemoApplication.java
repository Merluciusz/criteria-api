package com.example.CriteriaDemo;

import com.example.CriteriaDemo.model.entities.Product;
import com.example.CriteriaDemo.service.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CriteriaDemoApplication {
	private final ProductRepository repository;

	public CriteriaDemoApplication(ProductRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CriteriaDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner dataLoader() {
		return args -> {
			repository.saveAll(List.of(
					Product.builder().brand("Asus").category("Gaming").chipsetVideo("Nvidia").model("ROG").price(4500.1).os("Windows").build(),
					Product.builder().brand("Lenovo").model("T15").category("Workstation").chipsetVideo("Nvidia").price(7000.5).os("Windows").build(),
					Product.builder().brand("Apple").category("Workstation").chipsetVideo("integrated").model("Mac-Pro").price(12000.1).os("MacOs").build(),
					Product.builder().brand("Dell").category("Home").chipsetVideo("Nvidia").model("ROG").price(4500.1).os("Windows").build(),
					Product.builder().brand("Dell").category("Workstation").chipsetVideo("integrated").model("Precision").price(8949.5).os("Windows").build(),
					Product.builder().brand("Apple").category("Home").chipsetVideo("integrated").model("Mac-Home").price(5788.5).os("MacOs").build(),
					Product.builder().brand("Acer").category("Home").chipsetVideo("integrated").model("Aspire").price(2555.0).os("Linux").build(),
					Product.builder().brand("Apple").category("Home").chipsetVideo("integrated").model("Mac-Home").price(5788.5).os("MacOs").build(),
					Product.builder().brand("Lenovo").category("P1").chipsetVideo("integrated").model("P1").price(7700.0).os("Windows").build()
			));
		};
	}

}
