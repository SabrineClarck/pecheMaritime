package ma.siig.services.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ma.siig.dao.AccountDao;
import ma.siig.domain.Account;
import ma.siig.services.AccountService;

public class AccountServiceImpl implements AccountService, UserDetailsService {

	private AccountDao accountDao;
	
	
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	public AccountDao getAccountDao() {
		return accountDao;
	}


	public Account save(Account account) {
		
		if(account != null){
			FacesMessage msg = new FacesMessage("Compte crée avec succès!");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}
		
		return accountDao.save(account);
	}

	
	public Account update(Account account) {
		
		return accountDao.update(account);
	}

	
	public void delete(Account account) {
		accountDao.delete(account);
		FacesMessage msg = new FacesMessage("Compte supprimé");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	
	public Account findById(Integer id) {
		
		return accountDao.findById(id);
	}

	
	public List<Account> findAll() {
		
		return accountDao.findAll();
	}

	
	public void flush() {
		
		accountDao.flush();
	}

	
	 public void onRowEdit(RowEditEvent event) {
		 Account vi = new Account();
		 vi = (Account) event.getObject();
		 	update(vi);
	        FacesMessage msg = new FacesMessage("Compte modifié");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Modification annulée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }


		
		public Account loadUserEntityByUsername(String userName) {

			return accountDao.loadUserByUserName(userName);
		}


		
		public UserDetails loadUserByUsername(String userName)
				throws UsernameNotFoundException {
			Account account = accountDao.loadUserByUserName(userName);
			
			if(account == null){
				throw new UsernameNotFoundException("Il n'y a pas de compte associé au login entré");
			}
			
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			User accountDetails = new User(account.getLogin(), account.getPw(), authorities);
			
			return accountDetails;
		}
	
}
