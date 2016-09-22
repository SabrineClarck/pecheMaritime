package ma.siig.domain;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;


import ma.siig.commons.domain.BaseEntity;


@Entity
@Table(name="appuser")
public class UserEntity extends BaseEntity{

	// we're using the annotation @Table(name="appuser")
	//to specify to hibernate that it should look for a table called "appuser"
	//if we didn't specify the attribute name like below,hibernate will look 
	// for a table that has the same name as "UserEntity" the class

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		// pour encrypter le mot de passe
		// dans le mode deboggage, on va plus voir le mot de passe
		// dans le serveur, c pour sécuriser le mot de passe
		PasswordEncoder crypto = new Md5PasswordEncoder();
		this.password = crypto.encodePassword(password,null);
	}
	
	
	
	
	
	
}
