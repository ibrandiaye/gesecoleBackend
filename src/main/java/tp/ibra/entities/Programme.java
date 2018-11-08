package tp.ibra.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="programme")
@JsonIgnoreProperties({"programme","matieres","programmeClasses","inscriptions"})
public class Programme implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private String nom;
	private Date dateCreation;
	private Date dateFin;
	@OneToMany(mappedBy="programme")
	@JsonManagedReference
	private List<Matiere> matieres;
	@OneToMany(mappedBy="programme")
	@JsonManagedReference
	private List<ProgrammeClasse> programmeClasses;
	@OneToMany(mappedBy="programme")
	@JsonManagedReference
	private List<Inscription> inscriptions;
	
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
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
	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public List<ProgrammeClasse> getProgrammeClasses() {
		return programmeClasses;
	}
	public void setProgrammeClasses(List<ProgrammeClasse> programmeClasses) {
		this.programmeClasses = programmeClasses;
	}
	
	
	public Programme(int code, Date dateCreation, Date dateFin, List<Matiere> matieres,
			List<ProgrammeClasse> programmeClasses) {
		super();
		this.code = code;
		this.dateCreation = dateCreation;
		this.dateFin = dateFin;
		this.matieres = matieres;
		this.programmeClasses = programmeClasses;
	}
	public Programme() {
		super();
	}
	
}
