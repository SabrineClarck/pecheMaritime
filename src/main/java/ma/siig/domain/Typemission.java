package ma.siig.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the typemission database table.
 * 
 */
@Entity
@Table(name="typemission",catalog="siig")
public class Typemission implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idType;
	private String description;
	private String type;
	private Set<Mission> missions;

    public Typemission() {
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
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	//bi-directional many-to-one association to Mission
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="typemission")
	public Set<Mission> getMissions() {
		return this.missions;
	}

	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}
	
}