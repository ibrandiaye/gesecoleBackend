package tp.ibra.entities;

import java.io.Serializable;
import java.time.LocalTime;
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
@Table(name="planning")
@JsonIgnoreProperties("sceanceCours")
public class Planning implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private LocalTime heureDebut;
	private LocalTime heureFin;
	private String jour;
	@OneToMany(mappedBy="planning")
	@JsonManagedReference
	private List<SceanceCours> sceanceCours;
	@ManyToOne
	@JoinColumn(name="matiere_id")
	private Matiere matiere;
	
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}
	public List<SceanceCours> getSceanceCours() {
		return sceanceCours;
	}
	public void setSceanceCours(List<SceanceCours> sceanceCours) {
		this.sceanceCours = sceanceCours;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public LocalTime getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}
	public LocalTime getHeureFin() {
		return heureFin;
	}
	public void Time(LocalTime heureFin) {
		this.heureFin = heureFin;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public Planning(int code, LocalTime heureDebut, LocalTime heureFin, String jour) {
		super();
		this.code = code;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.jour = jour;
	}
	public Planning() {
		super();
	}
	
	

}
