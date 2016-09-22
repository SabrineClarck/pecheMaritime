package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.ModuleDao;
import ma.siig.domain.Module;
import ma.siig.services.ModuleService;

public class ModuleServiceImpl implements ModuleService {

	private ModuleDao moduleDao;
	
	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}


	public ModuleDao getModuleDao() {
		return moduleDao;
	}


	public Module save(Module module) {
		
		return moduleDao.save(module);
	}

	
	public Module update(Module module) {
		
		return moduleDao.update(module);
	}

	
	public void delete(Module module) {
		
		moduleDao.delete(module);
	}

	
	public Module findById(Integer id) {
		
		return moduleDao.findById(id);
	}

	
	public List<Module> findAll() {
		
		return moduleDao.findAll();
	}

	
	public void flush() {
		moduleDao.flush();

	}

	
	public void onRowEdit(RowEditEvent event) {
		
		Module i = new Module();
		i = (Module) event.getObject();
		update(i);
		 FacesMessage msg = new FacesMessage("Module modifié");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulée");
        FacesContext.getCurrentInstance().addMessage(null, msg);

	}

}
