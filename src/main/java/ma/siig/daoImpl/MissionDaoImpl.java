package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.MissionDao;
import ma.siig.domain.Mission;
@Transactional
public class MissionDaoImpl implements MissionDao {

private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Mission save(Mission mission) {
		if(mission == null){
		getEntityManager().persist(mission);
		}else{
			getEntityManager().merge(mission);
		}
		return mission;
	}

	
	public Mission update(Mission mission) {
		Mission ms = getEntityManager().merge(mission);
		return ms;
	}

	
	public void delete(Mission mission) {
		if(mission.getClass().isAssignableFrom(mission.getClass())){
			getEntityManager().remove(getEntityManager().getReference(mission.getClass(), mission.getIdMission()));
		}else{
			mission = getEntityManager().merge(mission);
		getEntityManager().remove(mission);
		}
	}

	
	public Mission findById(Integer id) {
		Mission ms = getEntityManager().find(Mission.class, id);
		return ms;
	}

	
	@SuppressWarnings("unchecked")
	public List<Mission> findAll() {
		
		return getEntityManager().createQuery("select m from "+ Mission.class.getSimpleName() +" m").getResultList();
	}

	
	public void flush() {
		
		getEntityManager().flush();
	}



}
