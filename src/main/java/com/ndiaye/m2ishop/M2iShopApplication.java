package com.ndiaye.m2ishop;

import com.ndiaye.m2ishop.model.Product;
import com.ndiaye.m2ishop.repository.ProductRepository;
import com.ndiaye.m2ishop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class M2iShopApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(M2iShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 = new Product("JORDAN_5", "Jordan 5", "Ma paire de Jordan 5",
				new BigDecimal("99.00"), new BigDecimal("20.00")
		);
		Product product2 = new Product("SUPRA_SKYTOP", "SUPRA Skytop", "SUPRA Skytop 2",
				new BigDecimal("89.00"), new BigDecimal("19.6")
		);
		Product product3 = new Product("LEVIS_501", "Levis 501", "Levi's 501 nouveau modèle",
				new BigDecimal("79.00"), new BigDecimal("20.00")
		);

		productRepository.deleteAll();
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
	}
}
