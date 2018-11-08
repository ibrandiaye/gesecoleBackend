package tp.ibra.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="enseigner")
public class Enseigner implements Serializable{
	@EmbeddedId
	private EnseignerPk enseignerPk;
	@ManyToOne
	@JoinColumn(name="id_professeur",insertable=false,updatable=false)
	private Professeur professeur;
	@ManyToOne
	@JoinColumn(name="id_matiere",insertable=false,updatable=false)
	private Professeur id_matiere;
	public Enseigner(EnseignerPk enseignerPk, Professeur professeur, Professeur id_matiere) {
		super();
		this.enseignerPk = enseignerPk;
		this.professeur = professeur;
		this.id_matiere = id_matiere;
	}
	public Enseigner() {
		super();
	}
	public EnseignerPk getEnseignerPk() {
		return enseignerPk;
	}
	public void setEnseignerPk(EnseignerPk enseignerPk) {
		this.enseignerPk = enseignerPk;
	}
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	public Professeur getId_matiere() {
		return id_matiere;
	}
	public void setId_matiere(Professeur id_matiere) {
		this.id_matiere = id_matiere;
	}
	
	
}
