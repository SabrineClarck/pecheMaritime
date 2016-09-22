package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.TypepjDao;
import ma.siig.domain.Typepj;
import ma.siig.services.TypepjService;

public class TypepjServiceImpl implements TypepjService {

	private TypepjDao typepjDao;
	
	public void setTypepjDao(TypepjDao typepjDao) {
		this.typepjDao = typepjDao;
	}


	public TypepjDao getTypepjDao() {
		return typepjDao;
	}


	public Typepj save(Typepj typepj) {
		 FacesMessage msg = new FacesMessage("Type bien enregistré ", typepj.getType());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        
		return typepjDao.save(typepj);
	}

	
	public Typepj update(Typepj typepj) {
		
		return typepjDao.update(typepj);
	}

	
	public void delete(Typepj typepj) {
		 FacesMessage msg = new FacesMessage("Type bien supprimé ", typepj.getType());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		typepjDao.delete(typepj);

	}

	
	public Typepj findById(Integer id) {
		
		return typepjDao.findById(id);
	}

	
	public List<Typepj> findAll() {
		
		return typepjDao.findAll();
	}

	
	public void flush() {
		typepjDao.flush();

	}


	
	public void onRowEdit(RowEditEvent event) {
		 Typepj vi = new Typepj();
		 vi = (Typepj) event.getObject();
		 	update(vi);
	        FacesMessage msg = new FacesMessage("Ville modifiée ", ((Typepj) event.getObject()).getType());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	
	public void onRowCancel(RowEditEvent event) {
		 FacesMessage msg = new FacesMessage("Modification annulée ", ((Typepj) event.getObject()).getType());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

}
