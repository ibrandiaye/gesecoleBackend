package tp.ibra.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="matiere")
@JsonIgnoreProperties({"evaluations","plannings"})
public class Matiere implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private String nom;
	private int coefficient;
	@ManyToOne
	@JoinColumn(name="professeur_id")
	private Professeur professeur;
	@OneToMany(mappedBy="matiere")
	@JsonManagedReference
	private List<Evaluation> evaluations;
	@ManyToOne
	@JoinColumn(name="id_programme")
	private Programme programme;
	@OneToMany(mappedBy="matiere")
	@JsonManagedReference
	private List<Planning> plannings;
	
	public List<Planning> getPlannings() {
		return plannings;
	}
	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}
	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
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
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	public Matiere(int code, String nom, int coefficient) {
		super();
		this.code = code;
		this.nom = nom;
		this.coefficient = coefficient;
	}
	public Matiere() {
		super();
	}
	
	

}
