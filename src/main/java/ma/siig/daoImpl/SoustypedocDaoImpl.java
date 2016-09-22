package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.SoustypedocDao;
import ma.siig.domain.Soustypedoc;

@Transactional
public class SoustypedocDaoImpl implements SoustypedocDao {

private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	public Soustypedoc save(Soustypedoc ss) {
		if(ss == null){
		getEntityManager().persist(ss);
		}else{
			getEntityManager().merge(ss);
		}
		return ss;
	}

	
	public Soustypedoc update(Soustypedoc ss) {
		Soustypedoc sm = getEntityManager().merge(ss);
		return sm;
	}

	
	public void delete(Soustypedoc ss) {
		if(ss.getClass().isAssignableFrom(ss.getClass())){
			getEntityManager().remove(getEntityManager().getReference(ss.getClass(), ss.getIdSousType()));
		}else{
		ss = getEntityManager().merge(ss);
		getEntityManager().remove(ss);
		}
	}

	
	public Soustypedoc findById(Integer id) {
		Soustypedoc doc = getEntityManager().find(Soustypedoc.class, id);
		return doc;
	}

	
	@SuppressWarnings("unchecked")
	public List<Soustypedoc> findAll() {
		
		return getEntityManager().createQuery("select s from "+ Soustypedoc.class.getSimpleName() +" s").getResultList();
	}

	
	public void flush() {
		getEntityManager().flush();

	}


	
	@SuppressWarnings("unchecked")
	public List<Soustypedoc> findArchives() {
		Query qr = getEntityManager().createQuery("select s from "+Soustypedoc.class.getSimpleName()+" s where s.typedoc.libelle like '%Archives%'");
		return qr.getResultList();
	}


	
	@SuppressWarnings("unchecked")
	public List<Soustypedoc> findSources() {
		Query qr = getEntityManager().createQuery("select s from "+Soustypedoc.class.getSimpleName()+" s where s.typedoc.libelle like '%Sources%'");
		return qr.getResultList();
	}


	
	@SuppressWarnings("unchecked")
	public List<Soustypedoc> findOthers() {
		Query qr = getEntityManager().createQuery("select s from "+Soustypedoc.class.getSimpleName()+" s where s.typedoc.libelle not like '%Sources%' and s.typedoc.libelle not like '%Archives%'");
		return qr.getResultList();
	}

}
