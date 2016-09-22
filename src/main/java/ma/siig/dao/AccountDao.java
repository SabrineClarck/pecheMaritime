package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Account;

public interface AccountDao {

	public Account save (Account account);
	public Account update(Account account);
	public void delete(Account account);
	public Account findById(Integer id);
	public List<Account> findAll();
	public void flush();
	
}
