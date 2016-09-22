package ma.siig.services;

import javax.faces.event.AjaxBehaviorEvent;

import ma.siig.domain.UserEntity;

/**
 * Service providing service methods to work with user data and entity
 * 
 * @author SabrineMac
 *
 */

public interface UserService {

	/**
	 * Create user persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	
	boolean createUser(UserEntity userEntity);
	
	boolean checkAvailable(AjaxBehaviorEvent event);
	
	UserEntity loadUserEntityByUsername(String userName);
}
