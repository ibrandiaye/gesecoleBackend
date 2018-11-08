package tp.ibra.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity()
@Table(name="eleve")
@JsonIgnoreProperties({"inscription","notes"})
public class Eleve implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private Date dateNaissance;
	private String lieuNaissance;
	@Lob
	private String image;
	@ManyToOne
	@JoinColumn(name="id_tuteur")
	private Tuteur tuteur;
	@OneToMany(mappedBy="eleve")
	@JsonManagedReference
	private List<Inscription> inscription;
	@OneToMany(mappedBy="eleve")
	@JsonManagedReference
	private List<Note> notes;
	
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public Tuteur getTuteur() {
		return tuteur;
	}
	public void setTuteur(Tuteur tuteur) {
		this.tuteur = tuteur;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	
	public List<Inscription> getInscription() {
		return inscription;
	}
	public void setInscription(List<Inscription> inscription) {
		this.inscription = inscription;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Eleve(int code, String nom, String prenom, String adresse, String telephone, Date dateNaissance,
			String lieuNaissance) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
	}
	public Eleve() {
		super();
	}
	

}
