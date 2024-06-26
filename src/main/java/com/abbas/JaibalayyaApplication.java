package com.abbas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JaibalayyaApplication {
	
	@GetMapping("/")
	public String test() {
		
		return "welcome to ci and cd";
	}

	public static void main(String[] args) {
		SpringApplication.run(JaibalayyaApplication.class, args);
	}

}
