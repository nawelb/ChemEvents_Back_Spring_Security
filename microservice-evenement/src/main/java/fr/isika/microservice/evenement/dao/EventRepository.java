package fr.isika.microservice.evenement.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.isika.microservice.evenement.model.Event;


public interface EventRepository extends CrudRepository<Event, Long>{

	List<Event> findByDateDebutEvent(LocalDate dateDebutEvent);

	List<Event> findByPays(String pays);

	List<Event> findByVille(String ville);


}
