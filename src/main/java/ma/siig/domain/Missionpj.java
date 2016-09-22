package ma.siig.domain;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the missionpj database table.
 * 
 */
@Entity
@Table(name="missionpj")
public class Missionpj implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idPj;
	private Date dateAjout;
	private String description;
	private String titre;
	private Mission mission;
	private Typepj typepj;
	private Document document;

    public Missionpj() {
    }

    @PostConstruct
    public void init(){
    	mission = new Mission();
    	typepj = new Typepj();
    	document = new Document();
    }

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdPj() {
		return this.idPj;
	}

	public void setIdPj(int idPj) {
		this.idPj = idPj;
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


	@Column(length=254)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	//bi-directional many-to-one association to Mission
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idMission", nullable=false)
	public Mission getMission() {
		return this.mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}
	

	//bi-directional many-to-one association to Typepj
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idType", nullable=false)
	public Typepj getTypepj() {
		return this.typepj;
	}

	public void setTypepj(Typepj typepj) {
		this.typepj = typepj;
	}
	

	//bi-directional many-to-one association to Document
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idDoc", nullable=false)
	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
}