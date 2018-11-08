package tp.ibra.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="absence")
public class Abscence implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private String commentaire;
	private String type;
	@ManyToOne
	@JoinColumn(name="id_sceancecours")
	private SceanceCours sceanceCours;


	public Abscence() {
		super();
	}

	public Abscence(int code, String commentaire, String type,SceanceCours sceanceCours) {
		super();
		this.code = code;
		this.commentaire = commentaire;
		this.type = type;
		this.sceanceCours = sceanceCours;
	}
	

	public SceanceCours getSceanceCours() {
		return sceanceCours;
	}

	public void setSceanceCours(SceanceCours sceanceCours) {
		this.sceanceCours = sceanceCours;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
