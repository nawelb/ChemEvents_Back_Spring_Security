package fr.isika.microservice.evenement.model;

//import java.time.LocalDate;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import org.springframework.format.annotation.DateTimeFormat;

//@Entity
public class Event {
	
	private String _id; 
	private String title1;
	private String title2;
	private String img1;
	private String img2;
	private String description;
	private String date;
	private String lieu;
	private String email;
    private String siteWeb;
    private String tags;
    
    public Event() {
		super();
	}
    
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSiteWeb() {
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [_id=");
		builder.append(_id);
		builder.append(", title1=");
		builder.append(title1);
		builder.append(", title2=");
		builder.append(title2);
		builder.append(", img1=");
		builder.append(img1);
		builder.append(", img2=");
		builder.append(img2);
		builder.append(", description=");
		builder.append(description);
		builder.append(", date=");
		builder.append(date);
		builder.append(", lieu=");
		builder.append(lieu);
		builder.append(", email=");
		builder.append(email);
		builder.append(", siteWeb=");
		builder.append(siteWeb);
		builder.append(", tags=");
		builder.append(tags);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long idEvent;
//	///////////
//	private String title;
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	///////////
//	private String firstImage;
//	private String secondImage;
//	private String titreMajeur; 
//	private String titreMineur; 
//	private String sousTitre; 
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private LocalDate dateDebutEvent;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private LocalDate dateFinEvent;
//	private String ville;
//	private String pays;
//	private String submit;
//	private String register; 
//	private String website;
//	private String email;
//	
//	public Event() {
//		super();
//	}
//	
//	public Long getIdEvent() {
//		return idEvent;
//	}
//	public String getTitreMajeur() {
//		return titreMajeur;
//	}
//	public void setTitreMajeur(String titreMajeur) {
//		this.titreMajeur = titreMajeur;
//	}
//	public String getTitreMineur() {
//		return titreMineur;
//	}
//	public void setTitreMineur(String titreMineur) {
//		this.titreMineur = titreMineur;
//	}
//	public String getSousTitre() {
//		return sousTitre;
//	}
//	public void setSousTitre(String sousTitre) {
//		this.sousTitre = sousTitre;
//	}
//	public LocalDate getDateDebutEvent() {
//		return dateDebutEvent;
//	}
//	public void setDateDebutEvent(LocalDate dateDebutEvent) {
//		this.dateDebutEvent = dateDebutEvent;
//	}
//	public LocalDate getDateFinEvent() {
//		return dateFinEvent;
//	}
//	public void setDateFinEvent(LocalDate dateFinEvent) {
//		this.dateFinEvent = dateFinEvent;
//	}
//	public String getVille() {
//		return ville;
//	}
//	public void setVille(String ville) {
//		this.ville = ville;
//	}
//	public String getSubmit() {
//		return submit;
//	}
//	public void setSubmit(String submit) {
//		this.submit = submit;
//	}
//	public String getRegister() {
//		return register;
//	}
//	public void setRegister(String register) {
//		this.register = register;
//	}
//	
//	public String getWebsite() {
//		return website;
//	}
//
//	public void setWebsite(String website) {
//		this.website = website;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getFirstImage() {
//		return firstImage;
//	}
//	public void setFirstImage(String firstImage) {
//		this.firstImage = firstImage;
//	}
//	public String getSecondImage() {
//		return secondImage;
//	}
//	public void setSecondImage(String secondImage) {
//		this.secondImage = secondImage;
//	}
//	public String getPays() {
//		return pays;
//	}
//	public void setPays(String pays) {
//		this.pays = pays;
//	}
	
	
	
	
	
}
