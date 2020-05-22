package fr.isika.microservice.security.service;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.isika.microservice.security.dao.ParticulierRepository;
import fr.isika.microservice.security.dao.RoleRepository;
import fr.isika.microservice.security.dao.UserRepository;
import fr.isika.microservice.security.model.Particulier;
import fr.isika.microservice.security.model.Role;
import fr.isika.microservice.security.model.User;

@RestController
@RequestMapping(path="/user")
//@Secured(value = {"ROLE_ADMIN"})
public class UserRoleService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ParticulierRepository particulierRepository; 
	
	// CRUD USER
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public User saveUser (@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@RequestMapping(value="/findUsers")
	public Iterable<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	@DeleteMapping(path="/supprimerUser/{username}")
	public void supprimerUser(@PathVariable String username){
		userRepository.deleteById(username);
	}
	@PutMapping(path="/modifierUser")
	public void modifierUser(@RequestBody User user){
		userRepository.save(user);
	}
	
	// CRUD ROLE	
	
	@RequestMapping(value="/saveRole")
	private Role saveRole (@RequestBody Role role) {
		return roleRepository.save(role);
	}
	
	@GetMapping(path="/findRoles")
	private Iterable<Role> findAllRoles(){
		return roleRepository.findAll();
	}
	@GetMapping(path="/findRoleByRole/{role}")
	private Role findByRole(@PathVariable String role){
		return roleRepository.findByRole(role);
	}
	
	@DeleteMapping(path="/supprimerRole/{role}")
	public void supprimerRole(@PathVariable String role){
		roleRepository.deleteById(role);
	}
	@PutMapping(path="/modifierRole")
	public void modifierRole(@RequestBody Role role){
		roleRepository.save(role);
	}
	
	// LINK USER - ROLE
	
	@RequestMapping(value=("/addRoleToUser"))
	public User addRoleToUser(String username, String role) {
		User u = userRepository.findByUsername(username);
		Role r = roleRepository.findByRole(role);
		u.getRoles().add(r);
		userRepository.save(u);
		return u;
	}
	
	// LINK USER - PARTICULIER
	
		@RequestMapping(value=("/addParticulierToUser"))
		public User addParticulierToUser(String username, Long idParticulier) {
			User u = userRepository.findByUsername(username);
			Particulier p = particulierRepository.findByIdParticulier(idParticulier);
			u.setParticulier(p);
			userRepository.save(u);
			return u;
		}
		
//		@RequestMapping(value=("/addParticulierToUser/{idParticulier}/{username}"))
//		public User addParticulierToUser(@PathVariable String username, @PathVariable Long idParticulier) {
//			User u = userRepository.findByUsername(username);
//			Particulier p = particulierRepository.findByIdParticulier(idParticulier);
//			u.setParticulier(p);
//			userRepository.save(u);
//			return u;
//		}
	
	
//	@PostMapping(path="/addRoleToUser")
//	ResponseEntity<Void> creerContrat(@RequestBody String username, String role) {
//
//		User u=userRepository.findByUsername(username);
//		Role r = roleRepository.findByRole(role);
//		u.getRoles().add(r);
//		userRepository.save(u);
//		
//		if (username == null || role == null)
//            return ResponseEntity.noContent().build();
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(u.getUsername())
//                .toUri();
//        return ResponseEntity.created(uri).build();
//	}
}
