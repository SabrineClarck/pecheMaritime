package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.TypemissionDao;
import ma.siig.domain.Typemission;
import ma.siig.services.TypemissionService;

public class TypemissionServiceImpl implements TypemissionService {

	private TypemissionDao typemissionDao;
	
	public void setTypemissionDao(TypemissionDao typemissionDao) {
		this.typemissionDao = typemissionDao;
	}


	public TypemissionDao getTypemissionDao() {
		return typemissionDao;
	}


	public Typemission save(Typemission typemission) {
		if(typemission != null){
		 FacesMessage msg = new FacesMessage("Type bien enregistrée ", typemission.getType());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return typemissionDao.save(typemission);
	}

	
	public Typemission update(Typemission typemission) {
		
		return typemissionDao.update(typemission);
	}

	
	public void delete(Typemission typemission) {
		
		FacesMessage msg = new FacesMessage("Type bien supprimé ", typemission.getType());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
		typemissionDao.delete(typemission);
	}

	
	public Typemission findById(Integer id) {
		
		return typemissionDao.findById(id);
	}

	
	public List<Typemission> findAll() {
		
		return typemissionDao.findAll();
	}

	
	public void flush() {
		typemissionDao.findAll();

	}


	
	public void onRowEdit(RowEditEvent event) {
		Typemission mi = new Typemission();
		mi = (Typemission) event.getObject();
		update(mi);
		FacesMessage msg = new FacesMessage("Type mission modifié ",((Typemission) event.getObject()).getType());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}


	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulée ",((Typemission) event.getObject()).getType());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		
	}

}
