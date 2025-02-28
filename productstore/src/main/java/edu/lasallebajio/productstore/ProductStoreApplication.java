package edu.lasallebajio.productstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "edu.lasallebajio.productstore.repository")
@EntityScan(basePackages = "edu.lasallebajio.productstore.model")
@SpringBootApplication
public class ProductStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductStoreApplication.class, args);
	}
}