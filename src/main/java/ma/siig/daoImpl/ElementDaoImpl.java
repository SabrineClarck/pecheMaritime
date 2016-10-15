package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.ElementDao;
import ma.siig.domain.Element;
@Transactional
public class ElementDaoImpl implements ElementDao {

	private EntityManager entityManager;
	
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}


	public Element save(Element element) {
		if(element == null){
			getEntityManager().persist(element);
		}else{
			getEntityManager().merge(element);
		}
		return element;
	}

	
	public Element update(Element element) {
		Element el = getEntityManager().merge(element);
		return el;
	}

	
	public void delete(Element element) {
		if(element.getClass().isAssignableFrom(element.getClass())){
			getEntityManager().remove(entityManager.getReference(element.getClass(), element.getIdElement()));
		}else{
			element = getEntityManager().merge(element);
			getEntityManager().remove(element);
		}

	}

	
	public Element findById(Integer id) {
		Element el = getEntityManager().find(Element.class, id);
		return el;
	}

	
	@SuppressWarnings("unchecked")
	public List<Element> findAll() {
		
		return getEntityManager().createQuery("select e from "+Element.class.getSimpleName()+" e").getResultList();
	}

	
	public void flush() {
		getEntityManager().flush();

	}

}
