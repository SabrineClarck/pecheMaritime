package ma.siig.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
@Table(name="module",catalog="siig")
public class Module implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idModule;
	private int code;
	private String libelle;
	private Set<Privilege> privileges;

    public Module() {
    }

    

	/**
	 * @param code
	 * @param libelle
	 * @param privileges
	 */
	public Module(int code, String libelle, Set<Privilege> privileges) {
		this.code = code;
		this.libelle = libelle;
		this.privileges = privileges;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdModule() {
		return this.idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}


	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}


	@Column(length=254)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	//bi-directional many-to-one association to Privilege
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="module")
	public Set<Privilege> getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	
}