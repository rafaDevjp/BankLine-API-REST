package com.dio.santander.bankLine.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@SpringBootApplication()
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BankLineApiApplication {

	public static void main(String[] args) {
 	System.out.println("Runing BankLineAPI");
		SpringApplication.run(BankLineApiApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoded(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}






}//END_CLAS
