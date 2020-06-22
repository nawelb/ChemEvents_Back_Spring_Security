package fr.isika.microservice.security.controller;

import java.util.HashMap;
import java.util.Map;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.isika.microservice.security.model.User;

@Controller
public class HomeController {

//	 @Autowired
//	    AuthenticationManager authenticationManager;
//
//	
//	 @PostMapping("/login")
//	    public ResponseEntity login(@RequestBody User user) {
//	        String username = user.getUsername();
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, user.getPassword()));
//			//String token = jwtTokenProvider.createToken(username, this.users.findByEmail(username).getRoles());
//			Map<Object, Object> model = new HashMap<>();
//			model.put("username", username);
//			//model.put("token", token);
//			return (ResponseEntity) model;
//	    }

	
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login.jsp";
	}

	@RequestMapping("/logout-sucess")
	public String logoutPage() {
		return "logout.jsp";
	}

}
