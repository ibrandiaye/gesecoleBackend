package tp.ibra.entities;

import java.io.Serializable;
import java.time.LocalTime;
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
@Table(name="sceanceCours")
@JsonIgnoreProperties("abscence")
public class SceanceCours implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private Date dateSceance =new Date();
	private LocalTime heureDebut;
	private LocalTime heureFin;
	private String observation;
	@ManyToOne()
	@JoinColumn(name="id_planning")
	private Planning planning;
	@OneToMany(mappedBy="sceanceCours")
	@JsonManagedReference
	private List<Abscence> abscence;
	
public Planning getPlanning() {
		return planning;
	}
	public void setPlanning(Planning planning) {
		this.planning = planning;
	}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public Date getDateSceance() {
	return dateSceance;
}
public void setDateSceance(Date dateSceance) {
	this.dateSceance = dateSceance;
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
public void setHeureFin(LocalTime heureFin) {
	this.heureFin = heureFin;
}
public String getObservation() {
	return observation;
}
public void setObservation(String observation) {
	this.observation = observation;
}

public SceanceCours(int code, Date dateSceance, LocalTime heureDebut, LocalTime heureFin, String observation,
		Planning planning, List<Abscence> abscence) {
	super();
	this.code = code;
	this.dateSceance = dateSceance;
	this.heureDebut = heureDebut;
	this.heureFin = heureFin;
	this.observation = observation;
	this.planning = planning;
	this.abscence = abscence;
	
}
public SceanceCours() {
this.dateSceance = new Date();
}

}
