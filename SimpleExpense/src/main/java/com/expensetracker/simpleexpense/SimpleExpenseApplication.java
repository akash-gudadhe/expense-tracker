package com.expensetracker.simpleexpense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SimpleExpenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleExpenseApplication.class, args);
		
	}

}
