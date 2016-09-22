package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.TypepjDao;
import ma.siig.domain.Typepj;

@Transactional
public class TypepjDaoImpl implements TypepjDao {
	
private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	public Typepj save(Typepj typepj) {
		if(typepj == null){
		getEntityManager().persist(typepj);
		}else{
			getEntityManager().merge(typepj);
		}
		return typepj;
	}

	
	public Typepj update(Typepj typepj) {
		Typepj tp = getEntityManager().merge(typepj);
		return tp;
	}

	
	public void delete(Typepj typepj) {
		if(typepj.getClass().isAssignableFrom(typepj.getClass())){
			getEntityManager().remove(getEntityManager().getReference(typepj.getClass(), typepj.getIdType()));
		}else{
		typepj = getEntityManager().merge(typepj);
		getEntityManager().remove(typepj);
		}
	}

	
	public Typepj findById(Integer id) {
		Typepj tp = getEntityManager().find(Typepj.class, id);
		return tp;
	}

	
	@SuppressWarnings("unchecked")
	public List<Typepj> findAll() {
		
		return getEntityManager().createQuery("select t from "+ Typepj.class.getSimpleName() +" t").getResultList();
	}

	
	public void flush() {
		getEntityManager().flush();

	}

}
