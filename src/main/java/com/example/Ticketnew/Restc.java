package com.example.Ticketnew;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Restc {
	
	@Bean
	RestTemplate resttemplate() {
		return new RestTemplate();
		
	}

}