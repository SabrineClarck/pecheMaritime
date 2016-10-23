package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.DestinationDao;
import ma.siig.domain.Destination;
import ma.siig.services.DestinationService;

public class DestinationServiceImpl implements DestinationService {

	
	private DestinationDao destinationDao;
	private Destination selectedDestination;
	
	
	public void setSelectedDestination(Destination selectedDestination) {
		this.selectedDestination = selectedDestination;
	}


	public Destination getSelectedDestination() {
		return selectedDestination;
	}


	public void setDestinationDao(DestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}


	public DestinationDao getDestinationDao() {
		return destinationDao;
	}


	public Destination save(Destination destination) {
		if(destination != null){
			 FacesMessage msg = new FacesMessage("Destination bien enregistrée");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		return destinationDao.save(destination);
	}

	
	public Destination update(Destination destination) {
		
		return destinationDao.update(destination);
	}

	
	public void delete(Destination destination) {
		destinationDao.delete(destination);

	}

	
	public Destination findById(Integer id) {
		
		return destinationDao.findById(id);
	}

	
	public List<Destination> findAll() {
		
		return destinationDao.findAll();
	}

	
	public void flush() {
		
		destinationDao.flush();
	}

	 public void onRowEdit(RowEditEvent event) {
		 Destination vi = new Destination();
		 vi = (Destination) event.getObject();
		 	update(vi);
	        FacesMessage msg = new FacesMessage("Destination modifiée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Modification annulée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
}
