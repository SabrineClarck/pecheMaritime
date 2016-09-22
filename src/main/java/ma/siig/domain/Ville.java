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

/*
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idVille;
		result = prime * result
				+ ((intitule == null) ? 0 : intitule.hashCode());
		return result;
	}

*/
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ville))
			return false;
		Ville other = (Ville) obj;
		if (idVille != other.idVille)
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		return true;
	}
	
	
	*/
	
	
	
}