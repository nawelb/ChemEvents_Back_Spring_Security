package fr.isika.microservice.security.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable{
	@Id
	private String username; 
	private String password; 
	@ManyToMany
	@JoinTable(name="USER_ROLE")
	private Collection<Role> roles;
	
	@OneToOne
	private Particulier particulier;
	
	public Particulier getParticulier() {
		return particulier;
	}

	public void setParticulier(Particulier particulier) {
		this.particulier = particulier;
	}

	public User() {
		super();
	}
	
	
	public User(String username, String password, Collection<Role> roles, Particulier particulier) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.particulier = particulier;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
}
