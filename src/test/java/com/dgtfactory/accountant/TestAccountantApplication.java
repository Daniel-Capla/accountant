package com.dgtfactory.accountant;

import org.springframework.boot.SpringApplication;

public class TestAccountantApplication {

	public static void main(String[] args) {
		SpringApplication.from(AccountantApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
