package ma.siig.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * The primary key class for the privileges database table.
 * 
 */
@Embeddable
public class PrivilegePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idModule;
	private int idProfil;

    public PrivilegePK() {
    }
    
	@Column(unique=true, nullable=false)
	public int getIdModule() {
		return this.idModule;
	}
	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}

	@Column(unique=true, nullable=false)
	public int getIdProfil() {
		return this.idProfil;
	}
	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrivilegePK)) {
			return false;
		}
		PrivilegePK castOther = (PrivilegePK)other;
		return 
			(this.idModule == castOther.idModule)
			&& (this.idProfil == castOther.idProfil);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idModule;
		hash = hash * prime + this.idProfil;
		
		return hash;
    }
}