package fr.isika.microservice.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.isika.microservice.security.dao.ParticulierRepository;
import fr.isika.microservice.security.model.Particulier;

@SpringBootApplication
public class MicroserviceSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSecurityApplication.class, args);
		
//		Alimentaion de la base de donnée
//		ApplicationContext ctx=SpringApplication.run(MicroserviceSecurityApplication.class, args);
//		ParticulierRepository particulierRepository = ctx.getBean(ParticulierRepository.class);
//		
//		particulierRepository.save(new Particulier("BERQOUCH", "Nawel", "n.b@gmail.com"));
		
	}

}
