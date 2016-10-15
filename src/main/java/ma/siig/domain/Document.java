package ma.siig.domain;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the document database table.
 * 
 */
@Entity
@Table(name="document",catalog="siig")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDoc;
	private Date dateAjout;
	private String description;
	
	private byte[] doc;
	
	private String titre;
	private Set<Consultation> consultations;
	private Soustypedoc soustypedoc;
	private Set<Missionpj> missionpjs;

    public Document() {
    }
    
    /**
	 * @param dateAjout
	 * @param description
	 * @param doc
	 * @param titre
	 * @param consultations
	 * @param soustypedoc
	 * @param missionpjs
	 */
	public Document(Date dateAjout, String description, byte[] doc,
			String titre, Set<Consultation> consultations,
			Soustypedoc soustypedoc, Set<Missionpj> missionpjs) {
		this.dateAjout = dateAjout;
		this.description = description;
		this.doc = doc;
		this.titre = titre;
		this.consultations = consultations;
		this.soustypedoc = soustypedoc;
		this.missionpjs = missionpjs;
	}

	@PostConstruct
    public void init(){
    	soustypedoc = new Soustypedoc();
    }

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdDoc() {
		return this.idDoc;
	}

	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}


    @Temporal( TemporalType.DATE)
	public Date getDateAjout() {
		return this.dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}


	@Column(length=254)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


    @Lob()
	public byte[] getDoc() {
		return this.doc;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}


	@Column(length=254)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	//bi-directional many-to-one association to Consultation
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy="document")
	public Set<Consultation> getConsultations() {
		return this.consultations;
	}

	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}
	

	//bi-directional many-to-one association to Soustypedoc
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idSousType")
	public Soustypedoc getSoustypedoc() {
		return this.soustypedoc;
	}

	public void setSoustypedoc(Soustypedoc soustypedoc) {
		this.soustypedoc = soustypedoc;
	}
	

	//bi-directional many-to-one association to Missionpj
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy="document")
	public Set<Missionpj> getMissionpjs() {
		return this.missionpjs;
	}

	public void setMissionpjs(Set<Missionpj> missionpjs) {
		
		this.missionpjs = missionpjs;
	}
	
}