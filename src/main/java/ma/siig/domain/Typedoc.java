package ma.siig.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the typedoc database table.
 * 
 */
@Entity
@Table(name="typedoc",catalog="siig")
public class Typedoc implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idType;
	private String description;
	private String libelle;
	private Set<Soustypedoc> soustypedocs;

    public Typedoc() {
    }
    
	/**
	 * @param description
	 * @param libelle
	 * @param soustypedocs
	 */
    
    
	public Typedoc(String description, String libelle,
			Set<Soustypedoc> soustypedocs) {
		this.description = description;
		this.libelle = libelle;
		this.soustypedocs = soustypedocs;
	}

	/**
	 * @param libelle
	 */
	public Typedoc(String libelle) {
		super();
		this.libelle = libelle;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdType() {
		return this.idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}


	@Column(length=254)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(length=254)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	//bi-directional many-to-one association to Soustypedoc
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="typedoc")
	public Set<Soustypedoc> getSoustypedocs() {
		return this.soustypedocs;
	}

	public void setSoustypedocs(Set<Soustypedoc> soustypedocs) {
		this.soustypedocs = soustypedocs;
	}
	
}