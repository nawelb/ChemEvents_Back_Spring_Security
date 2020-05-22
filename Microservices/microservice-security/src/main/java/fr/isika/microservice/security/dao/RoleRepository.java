package fr.isika.microservice.security.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.isika.microservice.security.model.Role;

public interface RoleRepository extends CrudRepository<Role, String>{

	Role findByRole(String role);
	
	Iterable<Role> findAll();

	void deleteByRole(String role);
}
