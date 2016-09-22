package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.ProfilDao;
import ma.siig.domain.Profil;

@Transactional
public class ProfilDaoImpl implements ProfilDao {
	
private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	public Profil save(Profil profil) {
		if(profil == null){
		getEntityManager().persist(profil);
		}else{
			getEntityManager().merge(profil);
		}
		return profil;
	}

	
	public Profil update(Profil profil) {
		Profil p = getEntityManager().merge(profil);
		return p;
	}

	
	public void delete(Profil profil) {
		if(profil.getClass().isAssignableFrom(profil.getClass())){
			getEntityManager().remove(getEntityManager().getReference(profil.getClass(), profil.getIdProfil()));
		}else{
			profil = getEntityManager().merge(profil);
			getEntityManager().remove(profil);

		}
	}

	
	public Profil findById(Integer id) {
		Profil p = getEntityManager().find(Profil.class, id);
		return p;
	}

	
	@SuppressWarnings("unchecked")
	public List<Profil> findAll() {
		
		return getEntityManager().createQuery("select p from "+ Profil.class.getSimpleName() +" p").getResultList();
	}

	
	public void flush() {
		
		getEntityManager().flush();
	}

}
