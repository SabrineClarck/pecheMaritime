package ma.siig.dao;

import ma.siig.commons.dao.GenericDao;
import ma.siig.domain.UserEntity;

/**
 * 
 * Data access object interface to work with User entity database operations
 * @author SabrineMac
 *
 */

public interface UserDao extends GenericDao<UserEntity, Long>{

	/**
	 * 
	 * @param userName
	 * @return true if available 
	 */
	
	boolean checkAvailable(String userName);
	
	/**
	 * 
	 * 
	 * @param userName
	 * @return UserEntity
	 */
	
	UserEntity loadUserByUserName(String userName);
	
	
}
