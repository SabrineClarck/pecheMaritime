package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.FonctionDao;
import ma.siig.domain.Fonction;
import ma.siig.services.FonctionService;

public class FonctionServiceImpl implements FonctionService {

	private FonctionDao fonctionDao;
	
	public void setFonctionDao(FonctionDao fonctionDao) {
		this.fonctionDao = fonctionDao;
	}


	public FonctionDao getFonctionDao() {
		return fonctionDao;
	}


	public Fonction save(Fonction fonction) {
		if(fonction != null){
			 FacesMessage msg = new FacesMessage("Fonction bien enregistrée");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return fonctionDao.save(fonction);
	}

	
	public Fonction update(Fonction fonction) {
		
		return fonctionDao.update(fonction);
	}

	
	public void delete(Fonction fonction) {
		
		fonctionDao.delete(fonction);
	}

	
	public Fonction findById(Integer id) {
		
		return fonctionDao.findById(id);
	}

	
	public List<Fonction> findAll() {
		
		return fonctionDao.findAll();
	}

	
	public void flush() {
		fonctionDao.flush();

	}

	
	public void onRowEdit(RowEditEvent event) {
		
		Fonction f = new Fonction();
		f = (Fonction) event.getObject();
		update(f);
		 FacesMessage msg = new FacesMessage("Fonction modifiée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	
	public void onRowCancel(RowEditEvent event) {

		FacesMessage msg = new FacesMessage("Modification annulée");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
