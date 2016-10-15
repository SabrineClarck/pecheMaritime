package ma.siig.services.Impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.MissionDao;
import ma.siig.domain.Mission;
import ma.siig.domain.Missionpj;
import ma.siig.services.MissionService;

public class MissionServiceImpl implements MissionService {

	private MissionDao missionDao;
	
	public void setMissionDao(MissionDao missionDao) {
		this.missionDao = missionDao;
	}


	public MissionDao getMissionDao() {
		return missionDao;
	}


	public Mission save(Mission mission) {
			
			mission.setEtat(Etats.CR.toString());
			Mission test = missionDao.save(mission);
			if(test != null){
			 FacesMessage msg = new FacesMessage("Mission bien enregistrée");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		return test;
	}

	
	public Mission update(Mission mission) {
		
		return missionDao.update(mission);
	}

	
	public void delete(Mission mission) {
		if(mission == null){
			delete(mission);
			return;
		}
		
		if(mission.getEtat().equals(Etats.CR.toString())){
			missionDao.delete(mission);
		}
		if(mission.getEtat().equals(Etats.EN.toString()) && !rapportFinal(mission.getMissionpjs())){
			mission.setEtat(Etats.AE.toString());
			update(mission);
		}
		if(mission.getEtat().equals(Etats.EN.toString()) && rapportFinal(mission.getMissionpjs())){
			mission.setEtat(Etats.CL.toString());
			update(mission);
		}
		
	}

	
	public Mission findById(Integer id) {
		
		return missionDao.findById(id);
	}

	
	public List<Mission> findAll() {
		
		return missionDao.findAll();
	}

	

	public void flush() {
		
		missionDao.flush();
	}

	public void onRowEdit(RowEditEvent event) {
		
		Mission en = new Mission();
		en = (Mission) event.getObject();
		if(en.getEtat().equals(Etats.CR.toString()) || en.getEtat().equals(Etats.EN.toString())){
		update(en);
		FacesMessage msg = new FacesMessage("Mission modifiée ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		}else{
		
		FacesMessage msg = new FacesMessage("Impossible de modifier la mission, car elle est ", ((Mission) event.getObject()).getEtat());
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);}
	}


	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulée ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	// méthode qui prend comme argument un Set<Typepj>, et qui retourne vrai ou faux
	//vrai si la liste contient le type Rapport final,faux sinon
	public boolean rapportFinal(Set<Missionpj> types){
		
		Iterator<Missionpj> itr = types.iterator();
		boolean decision = false;
		while(itr.hasNext()){
		// this may be changed because here we're using hard Code, which is not very
			//practical
			if(itr.next().getTypepj().getType().equalsIgnoreCase("Fiche final")){
				decision = true;
			}else{
				decision = false;
			}
		}
		return decision;
		
	}
	
	
	public boolean isEnCours(Mission mission){
		if(mission.getEtat().equalsIgnoreCase(Etats.EN.toString())){
			return true;
			}else{
			return false;
			}
	}
	
	public boolean isCree(Mission mission){
		
		if(mission.getEtat().equalsIgnoreCase(Etats.CR.toString())){
		return true;
		}else{
		return false;
		}
	}
	
	
	private enum Etats{
		
		CR ("Crée"),
		EN ("En cours"),
		AN ("Annulée"),
		AE ("Annulée En cours"),
		CL ("Clôturée");
		
		private String etat="";
		Etats(String etat){
			this.etat=etat;
		}
		
		
		public String toString(){
			return etat;
		}
		
	}



	public List<Mission> updateList() {
		
		return missionDao.updateList();
	}
	
	
}
