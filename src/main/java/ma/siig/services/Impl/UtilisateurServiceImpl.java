package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import ma.siig.dao.UtilisateurDao;
import ma.siig.domain.User;
import ma.siig.services.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurDao utilisateurDao;
	
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}


	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}


	public User save(User user) {
		if(user != null){
		 FacesMessage msg = new FacesMessage("Utilisateur bien enregistré ", user.getNom());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return utilisateurDao.save(user);
	}

	
	public User update(User user) {
		
		return utilisateurDao.update(user);
	}

	
	public void delete(User user) {
		FacesMessage msg = new FacesMessage("Utilisateur supprimé ", user.getNom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		utilisateurDao.delete(user);

	}

	
	public User findById(Integer id) {
		
		return utilisateurDao.findById(id);
	}

	
	public List<User> findAll() {
		
		return utilisateurDao.findAll();
	}

	
	public void flush() {
		
		utilisateurDao.flush();
	}


	
	public void onRowEdit(RowEditEvent event) {
		User us = new User();
		us = (User) event.getObject();
		update(us);
		FacesMessage msg = new FacesMessage("Utilisateur modifié ",((User) event.getObject()).getNom());
		 FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulée ",((User) event.getObject()).getNom());
		 FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
}
