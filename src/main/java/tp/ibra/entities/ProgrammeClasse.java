package tp.ibra.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="programme_classe")
public class ProgrammeClasse implements Serializable {
	@EmbeddedId
	private ProgrammeClassePk classePk;
	@ManyToOne
	@JoinColumn(name="id_programme",insertable=false,updatable=false)
	private Programme programme;
	@ManyToOne
	@JoinColumn(name="id_classe",insertable=false,updatable=false)
	private Classe classe;
	public ProgrammeClasse(ProgrammeClassePk classePk, Programme programme, Classe classe) {
		super();
		this.classePk = classePk;
		this.programme = programme;
		this.classe = classe;
	}
	public ProgrammeClasse() {
		super();
	}
	public ProgrammeClassePk getClassePk() {
		return classePk;
	}
	public void setClassePk(ProgrammeClassePk classePk) {
		this.classePk = classePk;
	}
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	

}
