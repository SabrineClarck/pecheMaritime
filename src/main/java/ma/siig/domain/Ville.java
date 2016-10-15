package ma.siig.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@Table(name="ville", catalog="siig")
public class Ville implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idVille;
	private String intitule;
	private Set<Destination> destinations;
	private Set<Entite> entites;

	
    public Ville() {
    }

    

	/**
	 * @param intitule
	 * @param destinations
	 * @param entites
	 */
	public Ville(String intitule, Set<Destination> destinations,
			Set<Entite> entites) {
		this.intitule = intitule;
		this.destinations = destinations;
		this.entites = entites;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	public int getIdVille() {
		return this.idVille;
	}

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}


	@Column(length=254,unique=true)
	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	//bi-directional many-to-one association to Destination
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="ville")
	public Set<Destination> getDestinations() {
		return this.destinations;
	}

	public void setDestinations(Set<Destination> destinations) {
		this.destinations = destinations;
	}
	

	//bi-directional many-to-one association to Entite
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="ville")
	public Set<Entite> getEntites() {
		return this.entites;
	}

	public void setEntites(Set<Entite> entites) {
		this.entites = entites;
	}

	
}