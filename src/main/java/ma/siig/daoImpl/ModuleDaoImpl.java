package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.ModuleDao;
import ma.siig.domain.Module;


@Transactional
public class ModuleDaoImpl implements ModuleDao {

	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}


	public Module save(Module module) {
		if(module == null){
			getEntityManager().persist(module);
		}else{
			getEntityManager().merge(module);
		}
		return module;
	}

	
	public Module update(Module module) {
		Module m = getEntityManager().merge(module);
		return m;
	}

	
	public void delete(Module module) {
		if(module.getClass().isAssignableFrom(module.getClass())){
			getEntityManager().remove(getEntityManager().getReference(module.getClass(), module.getIdModule()));
		}else{
			module = getEntityManager().merge(module);
			getEntityManager().remove(module);

		}

	}

	
	public Module findById(Integer id) {
		Module m = getEntityManager().find(Module.class, id);
		return m;
	}

	
	@SuppressWarnings("unchecked")
	public List<Module> findAll() {
		
		return getEntityManager().createQuery("select m from "+ Module.class.getSimpleName() +" m").getResultList();
	}

	
	public void flush() {
		getEntityManager().flush();

	}

}
