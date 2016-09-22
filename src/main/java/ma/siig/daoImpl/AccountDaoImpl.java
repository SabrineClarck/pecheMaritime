package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.AccountDao;
import ma.siig.domain.Account;

@Transactional
public class AccountDaoImpl implements AccountDao {

	
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}


	public Account save(Account account) {
		if(account == null){
		getEntityManager().persist(account);
		}else{
			getEntityManager().merge(account);
		}
		return account;
	}

	
	public Account update(Account account) {

		getEntityManager().merge(account);
		return account;
	}

	
	public void delete(Account account) {
		
		if(account.getClass().isAssignableFrom(account.getClass())){
			getEntityManager().remove(getEntityManager().getReference(account.getClass(), account.getIdAccount()));
		}else{
			account = getEntityManager().merge(account);
			getEntityManager().remove(account);
		}

		getEntityManager().remove(account);
		
	}

	
	public Account findById(Integer id) {
		
		Account account = getEntityManager().find(Account.class, id);

		return account;
	}

	
	@SuppressWarnings("unchecked")
	public List<Account> findAll() {
		
		return getEntityManager().createQuery("select x from "+ Account.class.getSimpleName() +" x").getResultList();
	}

	
	public void flush() {
			
			getEntityManager().flush();
	}

}
