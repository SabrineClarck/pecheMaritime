package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.TypedocDao;
import ma.siig.domain.Typedoc;

@Transactional
public class TypedocDaoImpl implements TypedocDao {
	
private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	public Typedoc save(Typedoc typedoc) {
		if(typedoc == null){
		getEntityManager().persist(typedoc);
		}else{
			getEntityManager().merge(typedoc);
		}
		return typedoc;
	}

	
	public Typedoc update(Typedoc typedoc) {
		Typedoc doc = getEntityManager().merge(typedoc);
		return doc;
	}

	
	public void delete(Typedoc typedoc) {
		if(typedoc.getClass().isAssignableFrom(typedoc.getClass())){
			getEntityManager().remove(getEntityManager().getReference(typedoc.getClass(), typedoc.getIdType()));
		}else{
		typedoc = getEntityManager().merge(typedoc);
		getEntityManager().remove(typedoc);
		}
	}

	
	public Typedoc findById(Integer id) {
		Typedoc tp = getEntityManager().find(Typedoc.class, id);
		return tp;
	}

	
	@SuppressWarnings("unchecked")
	public List<Typedoc> findAll() {
		
		return getEntityManager().createQuery("select t from "+ Typedoc.class.getSimpleName() +" t").getResultList();
	}

	
	public void flush() {
		getEntityManager().flush();

	}

}
