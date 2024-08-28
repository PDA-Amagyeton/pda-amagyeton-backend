package com.example.stock_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class StockSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockSystemApplication.class, args);
	}

}
