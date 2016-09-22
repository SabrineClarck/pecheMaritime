package ma.siig.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user",catalog="siig")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idUser;
	private String cin;
	private String nom;
	private BigDecimal ppr;
	private String prenom;
	private Set<Account> accounts;
	private Set<Consultation> consultations;
	private Set<Membreequipe> membreequipes;

    public User() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	@Column(length=254)
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}


	@Column(length=254)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@Column(precision=10)
	public BigDecimal getPpr() {
		return this.ppr;
	}

	public void setPpr(BigDecimal ppr) {
		this.ppr = ppr;
	}


	@Column(length=254)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	//bi-directional many-to-one association to Account
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="user")
	public Set<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	

	//bi-directional many-to-one association to Consultation
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="user")
	public Set<Consultation> getConsultations() {
		return this.consultations;
	}

	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}
	

	//bi-directional many-to-one association to Membreequipe
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="user")
	public Set<Membreequipe> getMembreequipes() {
		return this.membreequipes;
	}

	public void setMembreequipes(Set<Membreequipe> membreequipes) {
		this.membreequipes = membreequipes;
	}
	
}