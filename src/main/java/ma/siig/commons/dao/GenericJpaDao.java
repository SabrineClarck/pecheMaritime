package ma.siig.commons.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ma.siig.commons.domain.BaseEntity;

import org.springframework.transaction.annotation.Transactional;

/**
 * provides generic common implementation of GenericDao interface persistence methods
 * extend this abstract class to implement DAO for your specific needs
 * @author SabrineMac
 *
 */
@Transactional
public abstract class GenericJpaDao<T, ID extends Serializable> implements GenericDao<T, ID>{

//
	private EntityManager entityManager;
//
	private Class<T> persistenceClass;
	
	
	// constructor
	public GenericJpaDao(Class<T> persistenceClass){
		this.persistenceClass = persistenceClass;
	}
	
	// getter and setter for the field entityManager
	protected EntityManager getEntityManager(){
		return entityManager;
	}
// the annotation below, when the app starts, hibernate will know where to inject the class EntityManager
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	

	public Class<T> getPersistenceClass() {
		return persistenceClass;
	}

	
	public T save(T entity) {
		getEntityManager().persist(entity);
		
		return entity;
	}

	public T update(T entity) {
	
		T mergeEntity = getEntityManager().merge(entity);
		return mergeEntity;
	}

	public void delete(T entity) {
	
		if(BaseEntity.class.isAssignableFrom(persistenceClass)){
			getEntityManager().remove(getEntityManager().getReference(entity.getClass(), ((BaseEntity)entity).getId()));
		}else{
			entity = getEntityManager().merge(entity);
			getEntityManager().remove(entity);
		}
		
		
		
		
	}

	@Transactional(readOnly=true)
	public T findById(ID id) {
		T entity =(T) getEntityManager().find(getPersistenceClass(), id);
		
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> findAll() {
		
		return getEntityManager().createQuery("select x from "+ getPersistenceClass().getSimpleName() + " x").getResultList();
	}

	
	public void flush() {
		
		getEntityManager().flush();
		
	}

	
	
	
	
}
