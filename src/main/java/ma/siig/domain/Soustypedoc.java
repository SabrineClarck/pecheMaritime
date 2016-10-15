package ma.siig.domain;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the soustypedoc database table.
 * 
 */
@Entity
@Table(name="soustypedoc")
public class Soustypedoc implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idSousType;
	private String description;
	private String libelle;
	private Set<Document> documents;
	private Typedoc typedoc; //

    public Soustypedoc() {
    }

	/**
	 * @param description
	 * @param libelle
	 * @param documents
	 * @param typedoc
	 */
	public Soustypedoc(String description, String libelle,
			Set<Document> documents, Typedoc typedoc) {
		this.description = description;
		this.libelle = libelle;
		this.documents = documents;
		this.typedoc = typedoc;
	}


	@PostConstruct
	public void init(){
		typedoc = new Typedoc();
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdSousType() {
		return this.idSousType;
	}

	public void setIdSousType(int idSousType) {
		this.idSousType = idSousType;
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


	//bi-directional many-to-one association to Document
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="soustypedoc")
	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	

	//bi-directional many-to-one association to Typedoc
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idType", nullable=false)
	public Typedoc getTypedoc() {
		return this.typedoc;
	}

	public void setTypedoc(Typedoc typedoc) {
		this.typedoc = typedoc;
	}
	
}