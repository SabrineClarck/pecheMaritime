package ma.siig.domain;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import java.util.Set;

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
 * The persistent class for the entite database table.
 * 
 */
@Entity
@Table(name="entite", catalog="siig")
public class Entite implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEntite;
	private String intitule;
	private Set<Destination> destinations;
	private Ville ville;

    public Entite() {
    }

    
    
    public Entite(String intitule, Set<Destination> destinations, Ville ville) {
		this.intitule = intitule;
		this.destinations = destinations;
		this.ville = ville;
	}



	@PostConstruct
	public void init(){
		ville = new Ville();
	} 

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdEntite() {
		return this.idEntite;
	}

	public void setIdEntite(int idEntite) {
		this.idEntite = idEntite;
	}


	@Column(length=254)
	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	//bi-directional many-to-one association to Destination
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="entite")
	public Set<Destination> getDestinations() {
		return this.destinations;
	}

	public void setDestinations(Set<Destination> destinations) {
		this.destinations = destinations;
	}
	

	//bi-directional many-to-one association to Ville
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idVille", nullable = false)
	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
}