package fr.isika.microservice.security.dao;

import org.springframework.data.repository.CrudRepository;
import fr.isika.microservice.security.model.User;

public interface UserRepository extends CrudRepository <User, String>{


	User findByUsername(String username);

	void deleteByUsername(String username);


}
