package ma.siig.services.Impl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import ma.siig.domain.Account;
import ma.siig.services.UserAuthenticationProviderService;

public class UserAuthenticationProviderServiceImpl implements UserAuthenticationProviderService {

	
	private AuthenticationManager authenticationManager;
		

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	
	public boolean processUserAuthentication(Account account) {
		
		try{
			Authentication request = new UsernamePasswordAuthenticationToken(account.getLogin(),account.getPw());
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
			return true;
		}catch(AuthenticationException e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"Désolé !"));
			return false;
		}
		
	}



	
	
}
