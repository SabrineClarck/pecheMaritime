package ma.siig.domain;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * The persistent class for the privileges database table.
 * 
 */
@Entity
@Table(name="privileges",catalog="siig")
public class Privilege implements Serializable{
	private static final long serialVersionUID = 1L;
	private PrivilegePK id;
	private String libelle;
	private Module module;
	private Profil profil;

    public Privilege() {
    }
    
    /**
	 * @param libelle
	 * @param module
	 * @param profil
	 */
	public Privilege(String libelle, Module module, Profil profil) {
		this.libelle = libelle;
		this.module = module;
		this.profil = profil;
	}

	@PostConstruct
	public void init(){
		module = new Module();
		profil = new Profil();
	} 
    

	@EmbeddedId
	public PrivilegePK getId() {
		return this.id;
	}

	public void setId(PrivilegePK id) {
		this.id = id;
	}
	

	@Column(length=254)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	//bi-directional many-to-one association to Module
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idModule", nullable=false, insertable=false, updatable=false)
	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	

	//bi-directional many-to-one association to Profil
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idProfil", nullable=false, insertable=false, updatable=false)
	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
}