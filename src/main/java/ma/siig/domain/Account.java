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
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="account",catalog="siig")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idAccount;
	private String login;
	private String pw;
	private User user;
	private Profil profil;

    public Account() {
    }
    
    /**
	 * @param login
	 * @param pw
	 * @param user
	 * @param profil
	 */
	public Account(String login, String pw, User user, Profil profil) {
		this.login = login;
		this.pw = pw;
		this.user = user;
		this.profil = profil;
	}



	@PostConstruct
    public void init(){
    	user = new User();
    	profil = new Profil();
    }

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}


	@Column(length=254)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	@Column(length=254)
	public String getPw() {
		return this.pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}


	//bi-directional many-to-one association to User
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idUser", nullable=false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	//bi-directional many-to-one association to Profil
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idProfil", nullable=false)
	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
}