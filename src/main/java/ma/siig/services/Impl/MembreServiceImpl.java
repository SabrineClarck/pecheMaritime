package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.MemebreEDao;
import ma.siig.domain.Membreequipe;
import ma.siig.services.MembreService;

public class MembreServiceImpl implements MembreService {

	
	private MemebreEDao membreDao;
	private Membreequipe selectedMember;
	
	
	
	public void setSelectedMember(Membreequipe selectedMember) {
		this.selectedMember = selectedMember;
	}


	public Membreequipe getSelectedMember() {
		return selectedMember;
	}


	public MemebreEDao getMembreDao() {
		return membreDao;
	}


	public void setMembreDao(MemebreEDao membreDao) {
		this.membreDao = membreDao;
	}


	public Membreequipe save(Membreequipe membre) {
		if(membreDao.save(membre) != null){
			 FacesMessage msg = new FacesMessage("Membre bien enregistrée");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		return membreDao.save(membre);
	}

	
	public Membreequipe update(Membreequipe membre) {
		
		return membreDao.update(membre);
	}

	
	public void delete(Membreequipe membre) {
			
		membreDao.delete(membre);
	}

	
	public Membreequipe findById(Integer id) {
		
		return membreDao.findById(id);
	}

	
	public List<Membreequipe> findAll() {
		
		return membreDao.findAll();
	}

	
	public void flush() {
			
		membreDao.flush();
		
	}

	 public void onRowEdit(RowEditEvent event) {
		 Membreequipe vi = new Membreequipe();
		 vi = (Membreequipe) event.getObject();
		 	update(vi);
	        FacesMessage msg = new FacesMessage("Membre modifiée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Modification annulée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
}
