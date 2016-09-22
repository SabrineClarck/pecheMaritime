package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.ProfilDao;
import ma.siig.domain.Profil;
import ma.siig.services.ProfilService;

public class ProfilServiceImpl implements ProfilService {

	private ProfilDao profilDao;
	
	public void setProfilDao(ProfilDao profilDao) {
		this.profilDao = profilDao;
	}


	public ProfilDao getProfilDao() {
		return profilDao;
	}


	public Profil save(Profil profil) {
		
		return profilDao.save(profil);
	}

	
	public Profil update(Profil profil) {
		
		return profilDao.update(profil);
	}

	
	public void delete(Profil profil) {
		
		profilDao.delete(profil);
	}

	
	public Profil findById(Integer id) {
		
		return profilDao.findById(id);
	}

	
	public List<Profil> findAll() {
		
		return profilDao.findAll();
	}

	
	public void flush() {
		
		profilDao.flush();
	}

	 public void onRowEdit(RowEditEvent event) {
		 Profil vi = new Profil();
		 vi = (Profil) event.getObject();
		 	update(vi);
	        FacesMessage msg = new FacesMessage("Profil modifié");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Modification annulée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
}
