package fr.isika.jwtauthentication.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.jwtauthentication.model.User;
import fr.isika.jwtauthentication.repository.UserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/admin")
public class UsersController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/findUsers")
	public Iterable<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/findUser/{username}")
	public Optional<User> findByUsername(@PathVariable String username){
		return userRepository.findByUsername(username);
	}
	
	@Transactional
	@DeleteMapping(path="/deleteUser/{username}")
	public void supprimerUser(@PathVariable String username){
		userRepository.deleteByUsername(username);
	}
}
