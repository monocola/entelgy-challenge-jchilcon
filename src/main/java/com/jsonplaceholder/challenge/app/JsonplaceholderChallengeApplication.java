package com.jsonplaceholder.challenge.app;

import com.jsonplaceholder.challenge.app.repositories.impl.PostRepositrotyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JsonplaceholderChallengeApplication {

	@Bean
	public RestTemplate getRestemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(JsonplaceholderChallengeApplication.class, args);




	}

}
