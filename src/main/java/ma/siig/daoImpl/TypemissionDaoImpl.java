package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.TypemissionDao;
import ma.siig.domain.Typemission;

@Transactional
public class TypemissionDaoImpl implements TypemissionDao {
private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	public Typemission save(Typemission typemission) {
		if(typemission == null){
		getEntityManager().persist(typemission);
		}else{
			getEntityManager().merge(typemission);
		}
		return typemission;
	}

	
	public Typemission update(Typemission typemission) {
		Typemission tm = getEntityManager().merge(typemission);
		return tm;
	}

	
	public void delete(Typemission typemission) {
		
		if(typemission.getClass().isAssignableFrom(typemission.getClass())){
			getEntityManager().remove(getEntityManager().getReference(typemission.getClass(), typemission.getIdType()));
		}else{
		typemission = getEntityManager().merge(typemission);
		getEntityManager().remove(typemission);
		}
	}

	
	public Typemission findById(Integer id) {
		Typemission tm = getEntityManager().find(Typemission.class, id);
		return tm;
	}

	
	@SuppressWarnings("unchecked")
	public List<Typemission> findAll() {
		
		return getEntityManager().createQuery("select t from "+ Typemission.class.getSimpleName() +" t").getResultList();
	}

	
	public void flush() {
		getEntityManager().flush();

	}

}
