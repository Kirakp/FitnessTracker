package com.cg.ft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*")

@SpringBootApplication
public class FitnesstrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnesstrackerApplication.class, args);
	}

}
