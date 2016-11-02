package ma.siig.services;

import ma.siig.domain.Account;

/**
 * provides processing service to set user authentication session
 * 
 * @author SabrineMac
 *
 */

public interface UserAuthenticationProviderService {

	/**
	 * Process user authentication
	 * 
	 * @param user
	 * @return
	 */
	
	public boolean processUserAuthentication(Account account);
	
}
