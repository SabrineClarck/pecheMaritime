package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.ConsultationDao;
import ma.siig.domain.Consultation;
import ma.siig.services.ConsultationService;

public class ConsultationServiceImpl implements ConsultationService {

	
	private ConsultationDao consultationDao;
	
	
	public void setConsultationDao(ConsultationDao consultationDao) {
		this.consultationDao = consultationDao;
	}


	public ConsultationDao getConsultationDao() {
		return consultationDao;
	}


	public Consultation save(Consultation consultation) {
		if(consultation != null){
			 FacesMessage msg = new FacesMessage("Consultation bien enregistrée");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		return consultationDao.save(consultation);
	}

	
	public Consultation update(Consultation consultation) {
		
		return consultationDao.update(consultation);
	}

	
	public void delete(Consultation consultation) {
		
		consultationDao.delete(consultation);
	}

	
	public Consultation findById(Integer id) {
		
		return consultationDao.findById(id);
	}

	
	public List<Consultation> findAll() {
		
		return consultationDao.findAll();
	}

	
	public void flush() {
		
		consultationDao.flush();
	}
	
	 public void onRowEdit(RowEditEvent event) {
		 Consultation vi = new Consultation();
		 vi = (Consultation) event.getObject();
		 	update(vi);
	        FacesMessage msg = new FacesMessage("Consultation modifiée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Modification annulée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
}
