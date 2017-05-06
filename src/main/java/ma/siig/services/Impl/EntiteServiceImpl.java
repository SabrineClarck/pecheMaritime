package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.EntiteDao;
import ma.siig.domain.Entite;
import ma.siig.services.EntiteService;

public class EntiteServiceImpl implements EntiteService {

	private EntiteDao entiteDao;


	public void setEntiteDao(EntiteDao entiteDao) {
		this.entiteDao = entiteDao;
	}


	public EntiteDao getEntiteDao() {
		return entiteDao;
	}
	
	public Entite save(Entite entite) {
	
		if(entiteDao.save(entite) != null){
		 FacesMessage msg = new FacesMessage("Entité bien enregistrée", entite.getIntitule());
			
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	        return entite;
	}
	

	public Entite update(Entite entite) {
		
		return entiteDao.update(entite);
	}

	
	public void delete(Entite entite) {
		FacesMessage msg = new FacesMessage("Entité supprimée ", entite.getIntitule());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		entiteDao.delete(entite);
	}

	
	public Entite findById(Integer id) {
		
		return entiteDao.findById(id);
	}

	
	public List<Entite> findAll() {
		
		return entiteDao.findAll();
	}

	
	
	public void flush() {
		
		entiteDao.flush();
	}


	
	public void onRowEdit(RowEditEvent event) {
		Entite en = new Entite();
		en = (Entite) event.getObject();
		update(en);
		FacesMessage msg = new FacesMessage("Entité modifiée ",((Entite) event.getObject()).getIntitule());
        FacesContext.getCurrentInstance().addMessage(null, msg);

	}


	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulée ",((Entite) event.getObject()).getIntitule());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}


}
