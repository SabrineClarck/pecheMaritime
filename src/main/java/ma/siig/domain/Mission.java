package ma.siig.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the mission database table.
 * 
 */
@Entity
@Table(name="mission",catalog="siig")
public class Mission implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idMission;
	private Date debut;
	private String detail;
	private String etat;
	private Date fin;
	private String objet;
	private String titre;
	private Set<Destination> destinations;
	private Set<Membreequipe> membreequipes;
	private Typemission typemission;
	private Set<Missionpj> missionpjs;

    public Mission() {
    }

    /**
	 * @param debut
	 * @param detail
	 * @param etat
	 * @param fin
	 * @param objet
	 * @param titre
	 * @param destinations
	 * @param membreequipes
	 * @param typemission
	 * @param missionpjs
	 */
	public Mission(Date debut, String detail, String etat, Date fin,
			String objet, String titre, Set<Destination> destinations,
			Set<Membreequipe> membreequipes, Typemission typemission,
			Set<Missionpj> missionpjs) {
		this.debut = debut;
		this.detail = detail;
		this.etat = etat;
		this.fin = fin;
		this.objet = objet;
		this.titre = titre;
		this.destinations = destinations;
		this.membreequipes = membreequipes;
		this.typemission = typemission;
		this.missionpjs = missionpjs;
	}

	@PostConstruct
    public void init(){
    	typemission = new Typemission();
    }
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdMission() {
		return this.idMission;
	}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}


    @Temporal( TemporalType.DATE)
	public Date getDebut() {
		return this.debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}


	@Column(length=254)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}


	@Column(length=254)
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}


    @Temporal( TemporalType.DATE)
	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}


	@Column(length=254)
	public String getObjet() {
		return this.objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}


	@Column(length=254)
	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	//bi-directional many-to-one association to Destination
	@OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER,mappedBy="mission")
	public Set<Destination> getDestinations() {
		return this.destinations;
	}

	public void setDestinations(Set<Destination> destinations) {
		this.destinations = destinations;
	}
	

	//bi-directional many-to-one association to Membreequipe
	@OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER,mappedBy="mission")
	public Set<Membreequipe> getMembreequipes() {
		return this.membreequipes;
	}

	public void setMembreequipes(Set<Membreequipe> membreequipes) {
		this.membreequipes = membreequipes;
	}
	

	//bi-directional many-to-one association to Typemission
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idType")
	public Typemission getTypemission() {
		return this.typemission;
	}

	public void setTypemission(Typemission typemission) {
		this.typemission = typemission;
	}
	

	//bi-directional many-to-one association to Missionpj
	@OneToMany(cascade=CascadeType.REMOVE,fetch = FetchType.EAGER,mappedBy="mission")
	public Set<Missionpj> getMissionpjs() {
		return this.missionpjs;
	}

	public void setMissionpjs(Set<Missionpj> missionpjs) {

		this.missionpjs = missionpjs;
	}
	
}