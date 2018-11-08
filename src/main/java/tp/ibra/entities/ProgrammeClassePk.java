package tp.ibra.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;




@Embeddable
public class ProgrammeClassePk implements Serializable{
	@Column(name="id_programme", insertable=false,updatable=false)
	private int id_programme;
	@Column(name="id_classe", insertable=false,updatable=false)
	private int id_classe;
	public ProgrammeClassePk(int id_programme, int id_classe) {
		super();
		this.id_programme = id_programme;
		this.id_classe = id_classe;
	}
	public ProgrammeClassePk() {
		super();
	}
	public int getId_programme() {
		return id_programme;
	}
	public void setId_programme(int id_programme) {
		this.id_programme = id_programme;
	}
	public int getId_classe() {
		return id_classe;
	}
	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProgrammeClassePk)) {
			return false;
		}
		ProgrammeClassePk castOther= (ProgrammeClassePk) other;
		
		return 
				this.id_programme==castOther.id_programme
				&& this.id_classe==castOther.id_classe;
	}
	
}
