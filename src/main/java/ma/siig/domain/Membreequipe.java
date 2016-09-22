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
 * The persistent class for the membreequipe database table.
 * 
 */
@Entity
@Table(name="membreequipe",catalog="siig")
public class Membreequipe implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idMe;
	private String fonction;
	private Mission mission;
	private User user;

    public Membreequipe() {
    }

    @PostConstruct
    public void init(){
    	mission = new Mission();
    	user = new User();
    }

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdMe() {
		return this.idMe;
	}

	public void setIdMe(int idMe) {
		this.idMe = idMe;
	}


	@Column(length=254)
	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
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
	

	//bi-directional many-to-one association to User
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idUser", nullable=false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}