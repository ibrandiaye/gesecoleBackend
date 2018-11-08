package tp.ibra.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Table(name="niveau")
public class Niveau implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private String nom;
	@OneToMany(mappedBy="niveau")
	@JsonBackReference
	private List<Classe> classes;
	public Niveau(int id, String nom, List<Classe> classes) {
		super();
		this.code= id;
		this.nom = nom;
		this.classes = classes;
	}
	public Niveau() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int id) {
		this.code = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Classe> getClasses() {
		return classes;
	}
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	

}
