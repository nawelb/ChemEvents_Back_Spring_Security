package fr.isika.microservice.evenement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
//@EnableDiscoveryClient
public class MicroserviceEvenementApplication {

//	@Bean
//	public WebClient.Builder getWebClientBuilder(){
//		return WebClient.builder();
//	}
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEvenementApplication.class, args);
	}

}
