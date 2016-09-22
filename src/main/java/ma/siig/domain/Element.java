package ma.siig.domain;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the element database table.
 * 
 */
@Entity
@Table(name="element",catalog="siig")
public class Element implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idElement;
	private int code;
	private String libelle;
	private Module module;
	private Set<Fonction> fonctions;

    public Element() {
    }

    @PostConstruct
    public void init(){
    	module = new Module();
    }
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdElement() {
		return this.idElement;
	}

	public void setIdElement(int idElement) {
		this.idElement = idElement;
	}


	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	@Column(length=254)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	//bi-directional many-to-one association to Module
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idModule", nullable=false)
	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	

	//bi-directional many-to-one association to Fonction
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy="element")
	public Set<Fonction> getFonctions() {
		return this.fonctions;
	}

	public void setFonctions(Set<Fonction> fonctions) {
		this.fonctions = fonctions;
	}
	
}