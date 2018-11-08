package tp.ibra.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="inscription")
public class Inscription implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private Date date=new Date();
	private int montant;
	@ManyToOne
	@JoinColumn(name="id_eleve")
	private Eleve eleve;
	@ManyToOne
	@JoinColumn(name="id_classe")
	private Classe classe;
	@ManyToOne
	@JoinColumn(name="id_programme")
	private Programme programme;
	
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
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
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	
	public Classe getClasse() {
		return classe;
	}
	
	public Inscription(int code, int montant, Eleve eleve, Classe classe) {
		super();
		this.code = code;
		this.date = new Date();;
		this.montant = montant;
		this.eleve = eleve;
		this.classe = classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Inscription() {
		this.date = new Date();
	}
	
}
