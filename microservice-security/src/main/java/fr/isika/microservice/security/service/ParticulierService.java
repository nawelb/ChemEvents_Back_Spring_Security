package fr.isika.microservice.security.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.isika.microservice.security.dao.ParticulierRepository;
import fr.isika.microservice.security.dao.UserRepository;
import fr.isika.microservice.security.model.Particulier;

@RequestMapping(path="/particuliers")
@RestController
public class ParticulierService {
	@Autowired
	private ParticulierRepository particulierRepository;
	
	// CRUD PARTICULIER
	
	//@Secured(value= {"ROLE_ADMIN", "ROLE_PARTICULIER"})
	@RequestMapping(value ="/ajouterParticulier",method=RequestMethod.POST) 	//pour le moment GET
	public Particulier saveParticulier(@RequestBody Particulier particulier) {
		return particulierRepository.save(particulier);
	}
	@GetMapping(path="/listerLesParticuliers")  
	public @ResponseBody Iterable<Particulier> getAllParticuliers() {
		return particulierRepository.findAll();
	}
	
	@DeleteMapping(path="/supprimerParticulier/{idParticulier}")
	public void supprimerParticulier(@PathVariable Long idParticulier){
		particulierRepository.deleteById(idParticulier);
	}
	@PutMapping(path="/modifierParticulier")
	public void modifierParticulier(@RequestBody Particulier particulier){
		particulierRepository.save(particulier);
	}
	
	@GetMapping(path="/rechercherParticulierById/{idParticulier}")
	public Particulier rechercherParticulierById(@PathVariable Long idParticulier){
			return particulierRepository.findByIdParticulier(idParticulier);
	}
	
	@GetMapping(path="/rechercherParticulierByName/{nom}")
	public List<Particulier> rechercherParticulierByName(@PathVariable String nom){
			return particulierRepository.findByNom(nom);
	}
	
	@GetMapping(path="/rechercherParticulierByEmail/{email}")
	public List<Particulier> rechercherParticulierByEmail(@PathVariable String email){
			return particulierRepository.findByEmail(email);
	}
	
//	@Secured(value= {"ROLE_ADMIN", "ROLE_PARTICULIER"})
//	@PostMapping(path="/ajouterParticulier")
//	ResponseEntity<Void> creerContrat(@RequestBody Particulier particulier) {
//		Particulier particulierAjoute = particulierRepository.save(particulier);
//		if (particulierAjoute == null)
//            return ResponseEntity.noContent().build();
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(particulierAjoute.getIdParticulier())
//                .toUri();
//        return ResponseEntity.created(uri).build();
//	}
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value = "/getLogedUser")
//	public Map<String, Object> getLogedUser(HttpSession httpSession){
//		SecurityContext securityContext=(SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
//		
//		String username=securityContext.getAuthentication().getName();
//		List<String>roles=new ArrayList<>();
//		for (GrantedAuthority ga: securityContext.getAuthentication().getAuthorities()) {
//			roles.add(ga.getAuthority());
//		}
//		Map<String, Object> params = new HashMap<>();
//		params.put("username", username);
//		params.put("roles", roles);
//		
//		return params;
//		
//	}
	
}
