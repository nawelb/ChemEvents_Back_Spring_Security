package fr.isika.microservice.security.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.isika.microservice.security.model.Particulier;

public interface ParticulierRepository extends CrudRepository<Particulier, Long> {


	Particulier findByIdParticulier(Long idParticulier);

	List<Particulier> findByNom(String nom);

	List<Particulier> findByEmail(String email);

}
