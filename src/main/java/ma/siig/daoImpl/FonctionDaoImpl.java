package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.FonctionDao;
import ma.siig.domain.Fonction;

@Transactional
public class FonctionDaoImpl implements FonctionDao {

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManger) {
		this.entityManager = entityManger;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}


	public Fonction save(Fonction fonction) {
		if(fonction == null){
			getEntityManager().persist(fonction);
		}else{
			getEntityManager().merge(fonction);
		}
		return fonction;
	}

	
	public Fonction update(Fonction fonction) {
		Fonction f = getEntityManager().merge(fonction); 
		return f;
	}

	
	public void delete(Fonction fonction) {
		if(fonction.getClass().isAssignableFrom(fonction.getClass())){
			getEntityManager().remove(getEntityManager().getReference(fonction.getClass(), fonction.getIdFonction()));
		}else{
			fonction = getEntityManager().merge(fonction);
			getEntityManager().remove(fonction);

		}

	}

	
	public Fonction findById(Integer id) {
		Fonction f = getEntityManager().find(Fonction.class, id);
		return f;
	}

	@SuppressWarnings("unchecked")
	public List<Fonction> findAll() {
		
		return getEntityManager().createQuery("select f from "+ Fonction.class.getSimpleName() +" f").getResultList();
	}

	
	public void flush() {
		
		getEntityManager().flush();
	}

}
