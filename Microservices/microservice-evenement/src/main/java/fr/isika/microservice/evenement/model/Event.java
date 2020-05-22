package fr.isika.microservice.evenement.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEvent;
	private String firstImage;
	private String secondImage;
	private String titreMajeur; 
	private String titreMineur; 
	private String sousTitre; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDebutEvent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFinEvent;
	private String ville;
	private String pays;
	private String submit;
	private String register; 
	private String website;
	private String email;
	
	public Event() {
		super();
	}
	
	public Long getIdEvent() {
		return idEvent;
	}
	public String getTitreMajeur() {
		return titreMajeur;
	}
	public void setTitreMajeur(String titreMajeur) {
		this.titreMajeur = titreMajeur;
	}
	public String getTitreMineur() {
		return titreMineur;
	}
	public void setTitreMineur(String titreMineur) {
		this.titreMineur = titreMineur;
	}
	public String getSousTitre() {
		return sousTitre;
	}
	public void setSousTitre(String sousTitre) {
		this.sousTitre = sousTitre;
	}
	public LocalDate getDateDebutEvent() {
		return dateDebutEvent;
	}
	public void setDateDebutEvent(LocalDate dateDebutEvent) {
		this.dateDebutEvent = dateDebutEvent;
	}
	public LocalDate getDateFinEvent() {
		return dateFinEvent;
	}
	public void setDateFinEvent(LocalDate dateFinEvent) {
		this.dateFinEvent = dateFinEvent;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstImage() {
		return firstImage;
	}
	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}
	public String getSecondImage() {
		return secondImage;
	}
	public void setSecondImage(String secondImage) {
		this.secondImage = secondImage;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
	
	
	
}
