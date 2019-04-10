package com.telecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;


@SpringBootApplication 
public class TelecomApplication {

	/*Main Application class*/
	public static void main(String[] args) 
	{
		SpringApplication.run(TelecomApplication.class, args);
	}
}