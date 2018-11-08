package tp.ibra.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnseignerPk implements Serializable{
	@Column(name="id_professeur", insertable=false,updatable=false)
	private int id_professeur;
	@Column(name="id_matiere", insertable=false,updatable=false)
	private int id_matiere;
	

	public EnseignerPk(int id_professeur, int id_matiere) {
		super();
		this.id_professeur = id_professeur;
		this.id_matiere = id_matiere;
	}
	public int getId_professeur() {
		return id_professeur;
	}
	public void setId_professeur(int id_professeur) {
		this.id_professeur = id_professeur;
	}
	public int getId_matiere() {
		return id_matiere;
	}
	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}
	public EnseignerPk() {
		super();
	}
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProgrammeClassePk)) {
			return false;
		}
		EnseignerPk castOther= (EnseignerPk) other;
		
		return 
				this.id_professeur==castOther.id_professeur
				&& this.id_matiere==castOther.id_matiere;
	}

}
