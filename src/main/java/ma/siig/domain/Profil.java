package ma.siig.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the profil database table.
 * 
 */
@Entity
@Table(name="profil",catalog="siig")
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idProfil;
	private String code;
	private String libelle;
	private Set<Privilege> privileges;

    public Profil() {
    }
    
	/**
	 * @param code
	 * @param libelle
	 * @param privileges
	 */
	public Profil(String code, String libelle, Set<Privilege> privileges) {
		this.code = code;
		this.libelle = libelle;
		this.privileges = privileges;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdProfil() {
		return this.idProfil;
	}

	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}


	@Column(length=254)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
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
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="profil")
	public Set<Privilege> getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	
}