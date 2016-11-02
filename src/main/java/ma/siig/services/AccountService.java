package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Account;

public interface AccountService {

	public Account save (Account account);
	public Account update(Account account);
	public void delete(Account account);
	public Account findById(Integer id);
	public List<Account> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
	 public Account loadUserEntityByUsername(String userName);
}
