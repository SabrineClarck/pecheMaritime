package ma.siig.commons.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * 
 * @author SabrineMac
 *base  entity type to hold common Id property, to be extended
 *
 */
@MappedSuperclass//this to tell hibernate not to creat the table baseEntity, and that it only will use it to extends it
public class BaseEntity implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//la valeur de ID est générée comme une séquence de nombre incrémenté
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
