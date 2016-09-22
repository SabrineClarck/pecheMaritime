package ma.siig.services.Impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		df.format(d);
		
		if(d.equals(mission.getDebut())){
			
			mission.setEtat(Etats.EN.toString());
		}
		
		if(missionDao.save(mission) != null){
			 FacesMessage msg = new FacesMessage("Mission bien enregistrée");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		return missionDao.save(mission);
	}

	
	public Mission update(Mission mission) {
		
		return missionDao.update(mission);
	}

	
	public void delete(Mission mission) {
		if(mission.getEtat().equals(Etats.CR.toString())){
			mission.setEtat(Etats.AN.toString());
		}
		if(mission.getEtat().equals(Etats.EN.toString()) && !rapportFinal(mission.getMissionpjs())){
			mission.setEtat(Etats.EA.toString());
		}
		if(mission.getEtat().equals(Etats.EN.toString()) && rapportFinal(mission.getMissionpjs())){
			mission.setEtat(Etats.CL.toString());
		}
		
		
		if(mission.getEtat().equals(Etats.AN.toString())){
		missionDao.delete(mission);
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
		}
		
		FacesMessage msg = new FacesMessage("Impossible de modifier la mission, car elle est ", ((Mission) event.getObject()).getEtat());
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulée ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	// méthode qui prend comme argument un Set<Typepj>, et qui retourne vrai ou faux
	//vrai si la liste contient le type Rapport final,faux sinon
	private boolean rapportFinal(Set<Missionpj> types){
		
		Iterator<Missionpj> itr = types.iterator();
		
		while(itr.hasNext()){
		// this may be changed because here we're using hard Code, which is not very
			//practical
			if(itr.next().getTypepj().getType().equalsIgnoreCase("Rapport final")){
				return true;
			}else{
				return false;
			}
		}
		return false;
		
	}
	
	
	
	private enum Etats{
		
		CR ("Crée"),
		EN ("En cours"),
		AN ("Annulée"),
		EA ("En cours annulée"),
		CL ("Clôturée");
		
		private String etat="";
		Etats(String etat){
			this.etat=etat;
		}
		
		
		public String toString(){
			return etat;
		}
		
	}
	
	
}
