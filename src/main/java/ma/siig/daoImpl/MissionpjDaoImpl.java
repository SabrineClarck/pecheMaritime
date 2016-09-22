package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.MissionpjDao;
import ma.siig.domain.Missionpj;
@Transactional
public class MissionpjDaoImpl implements MissionpjDao {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Missionpj save(Missionpj missionpj) {
		if(missionpj == null){
		getEntityManager().persist(missionpj);
		}else{
			getEntityManager().merge(missionpj);
		}
		return missionpj;
	}


	public Missionpj update(Missionpj missionpj) {
		Missionpj mj = getEntityManager().merge(missionpj);
		return mj;
	}


	public void delete(Missionpj missionpj) {
		if(missionpj.getClass().isAssignableFrom(missionpj.getClass())){
			getEntityManager().remove(getEntityManager().getReference(missionpj.getClass(), missionpj.getIdPj()));
		}else{
			missionpj = getEntityManager().merge(missionpj);
		getEntityManager().remove(missionpj);
		}
	}


	public Missionpj findById(Integer id) {
		Missionpj m = getEntityManager().find(Missionpj.class, id);
		return m;
	}


	@SuppressWarnings("unchecked")
	public List<Missionpj> findAll() {

		return getEntityManager().createQuery("select m from "+Missionpj.class.getSimpleName() +" m").getResultList();
	}


	public void flush() {
		getEntityManager().flush();

	}

}
