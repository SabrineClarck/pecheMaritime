package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.DestinationDao;
import ma.siig.domain.Destination;

@Transactional
public class DestinationDaoImpl implements DestinationDao {
	
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	public Destination save(Destination destination) {
		if(destination == null){
		getEntityManager().persist(destination);
		}else{
			getEntityManager().merge(destination);
		}
		return destination;
	}

	
	public Destination update(Destination destination) {
		getEntityManager().merge(destination);
		return destination;
	}

	
	public void delete(Destination destination) {
		if(destination.getClass().isAssignableFrom(destination.getClass())){
			
			getEntityManager().remove(getEntityManager().getReference(destination.getClass(), destination.getIdDestination()));
		}else{
		
		destination = getEntityManager().merge(destination);
		getEntityManager().remove(destination);
		}

	}

	public Destination findById(Integer id) {
		Destination destination = getEntityManager().find(Destination.class, id);
		return destination;
	}

	
	@SuppressWarnings("unchecked")
	public List<Destination> findAll() {
		
		return getEntityManager().createQuery("select x from "+ Destination.class.getSimpleName() +" x").getResultList();
	}

	
	public void flush() {
		getEntityManager().flush();
	}

}
