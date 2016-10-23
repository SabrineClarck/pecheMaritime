package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;


import ma.siig.dao.VilleDao;
import ma.siig.domain.Ville;
import ma.siig.services.VilleService;

public class VilleServiceImpl implements VilleService {

	private VilleDao villeDao;
	private Ville selectedCity;


	

	public void setSelectedCity(Ville selectedCity) {
		this.selectedCity = selectedCity;
	}


	public Ville getSelectedCity() {
		return selectedCity;
	}


	public void setVilleDao(VilleDao villeDao) {
		this.villeDao = villeDao;
	}


	public VilleDao getVilleDao() {
		return villeDao;
	}


	public Ville save(Ville ville) {
		if(ville != null){
		 FacesMessage msg = new FacesMessage("Ville bien enregistrée", ville.getIntitule());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return villeDao.save(ville);
	}

	
	public Ville update(Ville ville) {
		
		return villeDao.update(ville);
	}

	
	public void delete(Ville ville) {
		FacesMessage msg = new FacesMessage("Ville supprimée ", ville.getIntitule());
        FacesContext.getCurrentInstance().addMessage(null, msg);
		villeDao.delete(ville);
	}

	
	public Ville findById(Integer id) {
		
		return villeDao.findById(id);
	}

	
	public List<Ville> findAll() {
		
		return villeDao.findAll();
	}

	
	public void flush() {
		
		villeDao.flush();

	}

	
	
	 public void onRowEdit(RowEditEvent event) {
		 Ville vi = new Ville();
		 vi = (Ville) event.getObject();
		 	update(vi);
	        FacesMessage msg = new FacesMessage("Ville modifiée", ((Ville) event.getObject()).getIntitule());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Modification annulée", ((Ville) event.getObject()).getIntitule());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }


		
		public Ville findByName(String name) {
			
			return villeDao.findByName(name);
		}


		
	
	
}
