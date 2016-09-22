package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.UtilisateurDao;
import ma.siig.domain.User;


@Transactional
public class UtilisateurDaoImpl implements UtilisateurDao {

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}


	public User save(User user) {
		if(user == null){
		getEntityManager().persist(user);
		}else{
			getEntityManager().merge(user);
		}
		return user;
	}

	
	public User update(User user) {
		getEntityManager().merge(user);
		return user;
	}

	
	public void delete(User user) {
		
		if(user.getClass().isAssignableFrom(user.getClass())){
			getEntityManager().remove(getEntityManager().getReference(user.getClass(), user.getIdUser()));
		}else{
			user = getEntityManager().merge(user);
			getEntityManager().remove(user);
		}
	}

	
	public User findById(Integer id) {
		User a = getEntityManager().find(User.class, id);
		return a;
	}

	
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		
		return getEntityManager().createQuery("select p from "+ User.class.getSimpleName() +" p").getResultList();
	}

	
	public void flush() {
		
		getEntityManager().flush();
	}

}
