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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="classe")
@JsonIgnoreProperties({"inscriptions","evaluations","programmeClasses"})
public class Classe implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private String nom;
	@ManyToOne
	@JoinColumn(name="id_niveau")
	private Niveau niveau;
	@OneToMany(mappedBy="classe")
	@JsonManagedReference
	private List<Inscription> inscriptions;
	@OneToMany(mappedBy="classe")
	@JsonManagedReference
	private List<Evaluation> evaluations;
	@OneToMany(mappedBy="classe")
	@JsonManagedReference
	private List<ProgrammeClasse> programmeClasses;
	
	public List<ProgrammeClasse> getProgrammeClasses() {
		return programmeClasses;
	}
	public void setProgrammeClasses(List<ProgrammeClasse> programmeClasses) {
		this.programmeClasses = programmeClasses;
	}
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}
	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
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
	public Classe(int code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}
	public Classe() {
		super();
	}
	
	

}
