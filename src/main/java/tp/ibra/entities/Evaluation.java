package tp.ibra.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="evaluation")
@JsonIgnoreProperties("notes")
public class Evaluation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private Date date;
	private String semestre;
	private String libelle;
	@ManyToOne
	@JoinColumn(name="id_matiere")
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name="id_type_evaluation")
	private TypeEvaluation type_evaluation;
	@ManyToOne
	@JoinColumn(name="id_classe")
	private Classe classe;
	@OneToMany(mappedBy="evaluation")
	@JsonManagedReference
	private List<Note> notes;
	
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Evaluation(int code, Date date, String semestre, String libelle, Matiere matiere) {
		super();
		this.code = code;
		this.date = date;
		this.semestre = semestre;
		this.libelle = libelle;
		this.matiere = matiere;
	}
	public Evaluation() {
		super();
	}
	
	public TypeEvaluation getType_evaluation() {
		return type_evaluation;
	}
	public void setType_evaluation(TypeEvaluation type_evaluation) {
		this.type_evaluation = type_evaluation;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	

}
