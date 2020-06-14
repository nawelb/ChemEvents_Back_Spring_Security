package fr.isika.microservice.security.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Particulier implements Serializable{
	
	
	private static final long serialVersionUID = -920068260712416133L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idParticulier; 
	private String nom; 
	private String prenom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDeNaissance; 
	private String email;
	private String adresse; 
	private String ville; 
	private String codePostal; 
	private String pays;
	
	
	
	
	
	public Particulier() {
		super();
	}
	public Particulier(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	public Long getIdParticulier() {
		return idParticulier;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	
	
	
}
