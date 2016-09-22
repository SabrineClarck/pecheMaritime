package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.ConsultationDao;
import ma.siig.domain.Consultation;


@Transactional
public class ConsultationDaoImpl implements ConsultationDao {
	
private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	public Consultation save(Consultation consultation) {
		if(consultation == null){
		getEntityManager().persist(consultation);
		}else{
			getEntityManager().merge(consultation);
		}
		return consultation;
	}

	
	public Consultation update(Consultation consultation) {
		getEntityManager().merge(consultation);
		return consultation;
	}

	
	public void delete(Consultation consultation) {
		
		if(consultation.getClass().isAssignableFrom(consultation.getClass())){
			
			getEntityManager().remove(getEntityManager().getReference(consultation.getClass(), consultation.getIdConsultation()));
		}else{
			consultation = getEntityManager().merge(consultation);
			getEntityManager().remove(consultation);
		}
		
			
	}

	
	public Consultation findById(Integer id) {
		Consultation cos = getEntityManager().find(Consultation.class, id);
		
		return cos;
	}

	
	@SuppressWarnings("unchecked")
	public List<Consultation> findAll() {
		
		return getEntityManager().createQuery("select x from "+ Consultation.class.getSimpleName() +" x").getResultList();
		
	}

	
	public void flush() {
		getEntityManager().flush();

	}

}
