package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.VilleDao;
import ma.siig.domain.Ville;

@Transactional
public class VilleDaoImpl implements VilleDao {

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}


	public Ville save(Ville ville) {
		if(ville == null){
		getEntityManager().persist(ville);
		}else{
			getEntityManager().merge(ville);
		}
		return ville;
	}

	
	public Ville update(Ville ville) {
		Ville v = getEntityManager().merge(ville);
		return v;
	}

	
	public void delete(Ville ville) {
		
		if(ville.getClass().isAssignableFrom(ville.getClass())){
			getEntityManager().remove(getEntityManager().getReference(ville.getClass(), ville.getIdVille()));
		}else{
			ville = getEntityManager().merge(ville);
		getEntityManager().remove(ville);
		}

	}

	
	public Ville findById(Integer id) {
		Ville v = getEntityManager().find(Ville.class, id);
		return v;
	}

	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Ville> findAll() {
		
		return getEntityManager().createQuery("SELECT m FROM "+ Ville.class.getSimpleName() +" m").getResultList();
	}

	
	public void flush() {
		getEntityManager().flush();

	}


	public Ville findByName(String name) {
		
		Ville mn =(Ville) getEntityManager().createQuery("SELECT v FROM "+ Ville.class.getSimpleName() +" v where v.intitule = :value")
		.setParameter("value", name).getSingleResult();
		return mn;
	}

}
