package ma.siig.services.Impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.inputtext.InputText;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ma.siig.dao.UserDao;
import ma.siig.domain.UserEntity;
import ma.siig.services.UserService;

/**
 * Service providing service methods to work with user data and entity
 * 
 * @author SabrineMac
 *
 */

public class UserServiceImpl implements UserService, UserDetailsService{

	//will be injected by spring in the file 
	//applicationContext.xml
	
	private UserDao userDao;
	
	
	
	 /**
	  * Create user-persist to database
	  * 
	  * 
	  */
	public boolean createUser(UserEntity userEntity){
		
		if(!userDao.checkAvailable(userEntity.getUserName())){
			FacesMessage msg = constructErrorMessage(String.format(getMessageBundle().getString("userExistsMsg"), userEntity.getUserName()), null);
			getFacesContext().addMessage(null, msg);
			
			return false;
		}
		
		try{
			
		userDao.save(userEntity);
		
		}catch(Exception e){
			
			FacesMessage msg = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, msg);
			
			return false;
		}
	
		
		return true;
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * Construct usrDtetails instance required by spring security
	 * 
	 * 
	 */
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserEntity user = userDao.loadUserByUserName(userName);
		
		if(user == null){
			
			throw new UsernameNotFoundException(String.format(getMessageBundle().getString("badCredentials"), userName));
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		
		User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
		
		return userDetails;
	}
	
	
	protected FacesMessage constructInfoMessage(String msg, String detail){
		return new FacesMessage(FacesMessage.SEVERITY_INFO, msg, detail);
		
	}
	
	
	protected FacesMessage constructErrorMessage(String msg, String detail){
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, detail);
		
	}
	
	
	protected FacesMessage constructFatalMessage(String msg, String detail){
		return new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, detail);
		
	}
	
	
	protected FacesContext getFacesContext(){
		
		return FacesContext.getCurrentInstance();
	}


	protected ResourceBundle getMessageBundle(){
		return ResourceBundle.getBundle("message-labels");
	}
	
	public boolean checkAvailable(AjaxBehaviorEvent event) {
	
		InputText inputText = (InputText) event.getSource();
		String value = (String) inputText.getValue();
		
		boolean available = userDao.checkAvailable(value);
		
		if(!available){
			FacesMessage msg = constructErrorMessage(null, String.format(getMessageBundle().getString("userExistsMsg"), value));
			getFacesContext().addMessage(event.getComponent().getClientId(), msg);
			
		}else{
			
			FacesMessage msg = constructInfoMessage(null, String.format(getMessageBundle().getString("UserAvailableMsg"), value));
			getFacesContext().addMessage(event.getComponent().getClientId(), msg);
		}
		
		return false;
	}


	
	public UserEntity loadUserEntityByUsername(String userName) {
		
		return userDao.loadUserByUserName(userName);
	}

	
	
	
}
