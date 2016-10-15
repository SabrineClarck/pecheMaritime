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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;


/**
 * The persistent class for the consultation database table.
 * 
 */
@Entity
@Table(name="consultation",catalog="siig")
public class Consultation implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idConsultation;
	private Date dateConsultation;
	private Document document;
	private User user;

    public Consultation() {
    }

    /**
	 * @param dateConsultation
	 * @param document
	 * @param user
	 */
	public Consultation(Date dateConsultation, Document document, User user) {
		super();
		this.dateConsultation = dateConsultation;
		this.document = document;
		this.user = user;
	}



	@PostConstruct
    public void init(){
    	document = new Document();
    	user = new User();
    }
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdConsultation() {
		return this.idConsultation;
	}

	public void setIdConsultation(int idConsultation) {
		this.idConsultation = idConsultation;
	}


    @Temporal( TemporalType.DATE)
	public Date getDateConsultation() {
		return this.dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}


	//bi-directional many-to-one association to Document
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idDoc", nullable=false)
	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
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