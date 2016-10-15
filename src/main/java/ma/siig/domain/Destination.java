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
 * The persistent class for the destination database table.
 * 
 */
@Entity
@Table(name="destination",catalog="siig")
public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDestination;
	private String description;
	private Ville ville;
	private Entite entite;
	private Mission mission;

    public Destination() {
    }
    
    /**
	 * @param description
	 * @param ville
	 * @param entite
	 * @param mission
	 */
	public Destination(String description, Ville ville, Entite entite,
			Mission mission) {
		this.description = description;
		this.ville = ville;
		this.entite = entite;
		this.mission = mission;
	}



	@PostConstruct
    public void init(){
    	ville = new Ville();
    	entite = new Entite();
    	mission = new Mission();
    }
    
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdDestination() {
		return this.idDestination;
	}

	public void setIdDestination(int idDestination) {
		this.idDestination = idDestination;
	}


	@Column(length=254)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	//bi-directional many-to-one association to Ville
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idVille")
	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	

	//bi-directional many-to-one association to Entite
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idEntite")
	public Entite getEntite() {
		return this.entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
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
	
}