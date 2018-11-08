package tp.ibra.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;;
@Entity
@Table(name="anne_scolaire")
public class AnneScolaire implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private Date dateDebut;
	private Date dateFin;
	private String Statut;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getStatut() {
		return Statut;
	}
	public void setStatut(String statut) {
		Statut = statut;
	}
	public AnneScolaire(int code, Date dateDebut, Date dateFin, String statut) {
		super();
		this.code = code;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		Statut = statut;
	}
	public AnneScolaire() {
		super();
	}
	

}
