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

	
	public List<Mission> updateList(){
		
		List<Mission> miss = findAll();
		//1. on teste si l'état de la mission est crée
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		dateFormat.format(date);
		
		for(Mission m : miss){
			if(isCree(m)){
				
				// si l'etat de la mission est bien crée on teste si aujourd'hui est le jour de début de la mission
				if(date.equals(m.getDebut()) || date.after(m.getDebut())){
					m.setEtat(Etats.EN.toString());
					m = update(m);
						}
												}
			
			
			if(isEnCours(m)){
			  //2. on teste si l'etat de la mission est en cours
				if(rapportFinal(m.getMissionpjs())){
					// on teste si parmi les pièces jointes de la mission il y a la fiche ou le repport final.
					m.setEtat(Etats.CL.toString());
					m = update(m);
													}	
							}
			
							}
		// on retourne la list des missions après modification
		return miss;
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
	private boolean rapportFinal(Set<Missionpj> types){
		
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
