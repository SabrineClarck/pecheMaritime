package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.AccountDao;
import ma.siig.domain.Account;
import ma.siig.services.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	public AccountDao getAccountDao() {
		return accountDao;
	}


	public Account save(Account account) {
		
		return accountDao.save(account);
	}

	
	public Account update(Account account) {
		
		return accountDao.update(account);
	}

	
	public void delete(Account account) {
		accountDao.delete(account);

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
	
}
