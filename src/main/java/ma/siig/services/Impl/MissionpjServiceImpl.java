package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.MissionpjDao;
import ma.siig.domain.Missionpj;

import ma.siig.services.MissionpjService;

public class MissionpjServiceImpl implements MissionpjService {

	
	private MissionpjDao missionpjDao;
	private Missionpj selectedPiece;
	
	
	public void setSelectedPiece(Missionpj selectedPiece) {
		this.selectedPiece = selectedPiece;
	}


	public Missionpj getSelectedPiece() {
		return selectedPiece;
	}


	public void setMissionpjDao(MissionpjDao missionpjDao) {
		this.missionpjDao = missionpjDao;
	}


	public MissionpjDao getMissionpjDao() {
		return missionpjDao;
	}


	public Missionpj save(Missionpj missionpj) {
		if(missionpj != null){
			 FacesMessage msg = new FacesMessage("Pièce jointe bien enregistrée");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		return missionpjDao.save(missionpj);
	}

	
	public Missionpj update(Missionpj missionpj) {
		
		return missionpjDao.update(missionpj);
	}

	
	public void delete(Missionpj missionpj) {
			missionpjDao.delete(missionpj);
		
	}

	
	public Missionpj findById(Integer id) {
		
		return missionpjDao.findById(id);
	}

	
	public List<Missionpj> findAll() {
		
		return missionpjDao.findAll();
	}

	
	public void flush() {
			missionpjDao.flush();
		
	}
	
	 public void onRowEdit(RowEditEvent event) {
		 Missionpj vi = new Missionpj();
		 vi = (Missionpj) event.getObject();
		 	update(vi);
	        FacesMessage msg = new FacesMessage("Pièce jointe modifiée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Modification annulée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

}
