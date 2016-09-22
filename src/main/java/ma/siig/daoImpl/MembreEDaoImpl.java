package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.MemebreEDao;
import ma.siig.domain.Membreequipe;
@Transactional
public class MembreEDaoImpl implements MemebreEDao {

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Membreequipe save(Membreequipe membre) {
		if(membre == null){
		getEntityManager().persist(membre);
		}else{
			getEntityManager().merge(membre);
		}
		return membre;
	}

	
	public Membreequipe update(Membreequipe membre) {
		Membreequipe me = getEntityManager().merge(membre);
		return me;
	}

	
	public void delete(Membreequipe membre) {
		if(membre.getClass().isAssignableFrom(membre.getClass())){
			getEntityManager().remove(getEntityManager().getReference(membre.getClass(), membre.getIdMe()));
		}else{
			membre = getEntityManager().merge(membre);
		getEntityManager().remove(membre);
		}

	}

	
	public Membreequipe findById(Integer id) {
		Membreequipe m = getEntityManager().find(Membreequipe.class, id);
		return m;
	}

	
	@SuppressWarnings("unchecked")
	public List<Membreequipe> findAll() {
		
		return getEntityManager().createQuery("select m from "+ Membreequipe.class.getSimpleName() +" m").getResultList();
	}

	
	public void flush() {
		getEntityManager().flush();

	}

}
