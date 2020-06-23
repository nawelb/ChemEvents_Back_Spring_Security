package fr.isika.microservice.evenement.service;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.isika.microservice.evenement.dao.EventRepository;
import fr.isika.microservice.evenement.model.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
//import fr.isika.microservice.evenement.model.Events;
//import fr.isika.microservice.evenement.model.EventList;
@CrossOrigin("*")
@RequestMapping(path="/event-api")
@RestController
public class EventService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private WebClient client; //= WebClient.create("http://localhost:3000");
	
	
	public EventService(WebClient.Builder webClientBuilder) {
		this.client = webClientBuilder.baseUrl("http://localhost:3000").build();
	}
	
	
	@GetMapping(path="public/events") 
	public Flux<Event> getEvents(){
		return client.get()
				.uri("/event-api/public/events")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(Event.class)
				.log("heyy$*****"); 
	}
	 
	
	@GetMapping("public/event/{_id}")
	public Mono<Event>getEventById(@PathVariable("_id") String _id){
		return client.get().uri("/event-api/public/event/{_id}", _id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Event.class) 
				.log("********hey IIIIDDDDD************");	
	}
	
	@PostMapping("private/event")
	public Mono<Event>createEvent(@RequestBody Event event){
		return client.post().uri("/event-api/private/event")
				.accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(event))
				.retrieve()
				.bodyToMono(Event.class)
				.log("********hey CREATE ************");	
	}
	
	
	@PutMapping ("private/admin/event")
	public Mono<Event> updateEvent(@RequestBody Event event){
		return client.put().uri("event-api/private/role-admin/event")
				.accept(MediaType.APPLICATION_JSON)
				.syncBody(event)
				.retrieve()
				.bodyToMono(Event.class)
				.log("**Hey   UPDATE***********");
	}
	
	
	@RequestMapping(value = "public/event", params = "country" )
	public Flux<Event>getEventByCountry(@RequestParam String country){
		System.out.println("DANS COUNTRY !!!!");
		return client.get().uri("/event-api/public/event?country="+country)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve() 
				.bodyToFlux(Event.class) 
				.log("********COUUNTTRYY************");	
	}
	
	@RequestMapping(value = "public/event", params = "city" )
	public Flux<Event>getEventByCity(@RequestParam String city){
		System.out.println("DANS COUNTRY !!!!");
		return client.get().uri("/event-api/public/event?city="+city)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve() 
				.bodyToFlux(Event.class) 
				.log("********CCCIIIITTTYYYYY************");	
	}
	
	
	@DeleteMapping("private/admin/delete/{_id}")
	public Mono<Event> deleteEvent(@PathVariable("_id") String _id){
		return client.delete().uri("private/role-admin/event/{_id}", _id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Event.class)
				.log("**Hey   DELETE***********" + _id);
		
	}
	
	
	

//	@GetMapping("public/event")
//	public Flux<Event>getEventByCity(@RequestParam(value="city", required=false) String city){
//		System.out.println("DANS CITY !!!!");
//		return client.get().uri("/event-api/public/event?city="+city)
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.bodyToFlux(Event.class) 
//				.log("********CIIITYYYYY************");	
//	}
	 
	
	
	// ATTENTION RECHERCHE %Like%
	
//	@GetMapping(path="/public/event/{title1}")
//	public Mono<Event>getEventByTitle1(@PathVariable("title1") String title1){
//		return client.get().uri("/event-api/public/event/{title1}", title1)
//				.retrieve()
//				.onStatus(httpStatus -> HttpStatus.INTERNAL_SERVER_ERROR.equals(httpStatus),
//		                clientResponse -> Mono.empty())
//				.bodyToMono(Event.class)
//				.log("********hey IIIIDDDDD************");	
//	}
	
//	@GetMapping(path="/public/{title2}")
//	public Mono<Event>getEventByTitle2(@PathVariable("title2") String title2){
//		return client.get().uri("/event-api/public/event/{title2}", title2)
//				.retrieve()
//				.onStatus(httpStatus -> HttpStatus.INTERNAL_SERVER_ERROR.equals(httpStatus),
//		                clientResponse -> Mono.empty())
//				.bodyToMono(Event.class)
//				.log("********hey IIIIDDDDD************");	
//	}
	
	
	

	

	
	
	
	
	
	
	
	// CRUD PARTICULIER
	
//		@RequestMapping(value ="/ajouterEvent",method=RequestMethod.POST)
//		public Event saveEvent(@RequestBody Event event) {
//			return eventRepository.save(event);
//		}
		
	
//	@GetMapping(path="/listerLesEvents")  
//		public @ResponseBody Event[] getAllEvents() {
//			// RestTemplate String
//		   // RestTemplate restTemplate = new RestTemplate();
//		    String result = restTemplate.getForObject("http://localhost:3000/event-api/public/event", String.class);
//		    System.out.println("StringJson: " + result);
//			//return result;
//		    final Gson gson = new GsonBuilder()
//		    	//	.registerTypeAdapter(
////		    LocalDate.class, new JsonDeserializer<LocalDate>() {
////	            @Override
////	            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
////	                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
////	            
////		    		}
////	        }
////		    		)
//		    		.create();
//		    Event[] articleArray = gson.fromJson(result, Event[].class);
//		    System.out.println("Gson : " + articleArray.toString());
//		    return articleArray;
//		}
		
		
		
//		@GetMapping(path="/listerLesEvents")  
//		public @ResponseBody Iterable<Event> getAllEvents() {
//			//WebClient.Builder builder = WebClient.builder();
//			//return eventRepository.findAll();
////			EventList ratings = restTemplate.getForObject("http://localhost:3000/event-api/public/event", EventList.class);
////			
////			return ratings.getUserRating().stream().map(rating -> {
////				Event event=restTemplate.getForObject("http://localhost:3000/event-api/public/event", Event.class);
//////				Event event= webClientBuilder.build()
//////						.get()
//////						.uri("http://localhost:3000/event-api/public/event" + ratings.getTitreMajeur(), Event.class)
//////						.retrieve()
//////						.bodyToMono(Event.class)
//////						.block();
////				
////				return new Event();
////			})
////				.collect(Collectors.toList());
//			
//			
//			
//		}
//		@PutMapping(path="/modifierEvent")
//		public void modifierEvent(@RequestBody Event event){
//			eventRepository.save(event);
//		}
//		@DeleteMapping(path="/supprimerEvent/{idEvent}")
//		public void supprimerEvent(@PathVariable Long idEvent){
//			eventRepository.deleteById(idEvent);
//		}
//		
//		@GetMapping(path="/rechercherEventById/{idEvent}")
//		public Optional<Event> rechercherEventById(@PathVariable Long idEvent){
//				return eventRepository.findById(idEvent);
//		}
//		
//		@GetMapping(path="/rechercherEventByPays/{pays}")
//		public List<Event> rechercherParticulierByPays(@PathVariable String pays){
//				return eventRepository.findByPays(pays);
//		}
//		@GetMapping(path="/rechercherEventByVille/{ville}")
//		public List<Event> rechercherEventByVille(@PathVariable String ville){
//			return eventRepository.findByVille(ville);
//		}
//	
//		@GetMapping(path="/rechercherEventByDate")
//		public List<Event> rechercherEventByDate(LocalDate dateDebutEvent){
//			return eventRepository.findByDateDebutEvent(dateDebutEvent);
//		}
//		@GetMapping(path="/rechercherEventByDate/{dateDebutEvent}")
//		public List<Event> rechercherEventByDate(@PathVariable LocalDate dateDebutEvent){
//			return eventRepository.findByDateDebutEvent(dateDebutEvent);
//		}
}
