package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.EntiteDao;
import ma.siig.domain.Entite;


@Transactional
public class EntiteDaoImpl implements EntiteDao {

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	public Entite save(Entite entite) {
		if(entite == null){
			getEntityManager().persist(entite);
		}else{
		getEntityManager().merge(entite);
		}
		return entite;
	}

	
	public Entite update(Entite entite) {
		Entite en = getEntityManager().merge(entite);
		return en;
	}

	
	public void delete(Entite entite) {
		
		if(entite.getClass().isAssignableFrom(entite.getClass())){
			getEntityManager().remove(getEntityManager().getReference(entite.getClass(), entite.getIdEntite()));
		}else{
			entite = getEntityManager().merge(entite);
		getEntityManager().remove(entite);
		}

	}

	
	public Entite findById(Integer id) {
		Entite en = getEntityManager().find(Entite.class, id);
		return en;
	}

	
	@SuppressWarnings("unchecked")
	public List<Entite> findAll() {
		
		return getEntityManager().createQuery("select t from "+ Entite.class.getSimpleName() +" t").getResultList();
	}

	
	public void flush() {
		getEntityManager().flush();

	}




}
