package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.TypedocDao;
import ma.siig.domain.Typedoc;
import ma.siig.services.TypedocService;

public class TypedocServiceImpl implements TypedocService {

	private TypedocDao typedocDao;
	
	public void setTypedocDao(TypedocDao typedocDao) {
		this.typedocDao = typedocDao;
	}


	public TypedocDao getTypedocDao() {
		return typedocDao;
	}


	public Typedoc save(Typedoc typedoc) {
		if(typedoc != null){
		FacesMessage msg = new FacesMessage("Type bien enregistré ", typedoc.getLibelle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return typedocDao.save(typedoc);
	}

	
	public Typedoc update(Typedoc typedoc) {
		
		return typedocDao.update(typedoc);
	}

	
	public void delete(Typedoc typedoc) {
		typedocDao.delete(typedoc);

	}

	
	public Typedoc findById(Integer id) {
		
		return typedocDao.findById(id);
	}

	
	public List<Typedoc> findAll() {
		
		return typedocDao.findAll();
	}

	
	public void flush() {
		
		typedocDao.flush();
	}


	
	public void onRowEdit(RowEditEvent event) {
		Typedoc bo = new Typedoc();
		bo = (Typedoc) event.getObject();
		update(bo);
		FacesMessage msg = new FacesMessage("Type modifié ",((Typedoc) event.getObject()).getLibelle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}


	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulée ",((Typedoc) event.getObject()).getLibelle());
        FacesContext.getCurrentInstance().addMessage(null, msg);

	}

}
