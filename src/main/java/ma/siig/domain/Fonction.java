package ma.siig.domain;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * The persistent class for the fonction database table.
 * 
 */
@Entity
@Table(name="fonction",catalog="siig")
public class Fonction implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idFonction;
	private int code;
	private String libelle;
	private Element element;

    public Fonction() {
    }

    @PostConstruct
    public void init(){
    	element = new Element();
    }

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdFonction() {
		return this.idFonction;
	}

	public void setIdFonction(int idFonction) {
		this.idFonction = idFonction;
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


	//bi-directional many-to-one association to Element
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idElement", nullable=false)
	public Element getElement() {
		return this.element;
	}

	public void setElement(Element element) {
		this.element = element;
	}
	
}