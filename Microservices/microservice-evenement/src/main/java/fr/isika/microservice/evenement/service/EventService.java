package fr.isika.microservice.evenement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.microservice.evenement.dao.EventRepository;
import fr.isika.microservice.evenement.model.Event;

@RequestMapping(path="/event")
@RestController
public class EventService {

	@Autowired
	private EventRepository eventRepository; 
	
	// CRUD PARTICULIER
	
		@RequestMapping(value ="/ajouterEvent",method=RequestMethod.POST)
		public Event saveEvent(@RequestBody Event event) {
			return eventRepository.save(event);
		}
		@GetMapping(path="/listerLesEvents")  
		public @ResponseBody Iterable<Event> getAllEvents() {
			return eventRepository.findAll();
		}
		@PutMapping(path="/modifierEvent")
		public void modifierEvent(@RequestBody Event event){
			eventRepository.save(event);
		}
		@DeleteMapping(path="/supprimerEvent/{idEvent}")
		public void supprimerEvent(@PathVariable Long idEvent){
			eventRepository.deleteById(idEvent);
		}
		
		@GetMapping(path="/rechercherEventById/{idEvent}")
		public Optional<Event> rechercherEventById(@PathVariable Long idEvent){
				return eventRepository.findById(idEvent);
		}
		
		@GetMapping(path="/rechercherEventByPays/{pays}")
		public List<Event> rechercherParticulierByPays(@PathVariable String pays){
				return eventRepository.findByPays(pays);
		}
		@GetMapping(path="/rechercherEventByVille/{ville}")
		public List<Event> rechercherEventByVille(@PathVariable String ville){
			return eventRepository.findByVille(ville);
		}
	
		@GetMapping(path="/rechercherEventByDate")
		public List<Event> rechercherEventByDate(LocalDate dateDebutEvent){
			return eventRepository.findByDateDebutEvent(dateDebutEvent);
		}
//		@GetMapping(path="/rechercherEventByDate/{dateDebutEvent}")
//		public List<Event> rechercherEventByDate(@PathVariable LocalDate dateDebutEvent){
//			return eventRepository.findByDateDebutEvent(dateDebutEvent);
//		}
}
