package ma.siig.daoImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.MissionDao;
import ma.siig.domain.Mission;
import ma.siig.domain.Missionpj;
import ma.siig.domain.Typepj;

@Transactional
public class MissionDaoImpl implements MissionDao {

private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Mission save(Mission mission) {
		
		if(mission == null){
		getEntityManager().persist(mission);
		}else{
		getEntityManager().merge(mission);
		}
		return mission;
	}

	
	public Mission update(Mission mission) {
		Mission ms = getEntityManager().merge(mission);
		return ms;
	}

	
	public void delete(Mission mission) {
		if(mission.getClass().isAssignableFrom(mission.getClass())){
			getEntityManager().remove(getEntityManager().getReference(mission.getClass(), mission.getIdMission()));
		}else{
			mission = getEntityManager().merge(mission);
		getEntityManager().remove(mission);
		}
	}

	
	public Mission findById(Integer id) {
		Mission ms = getEntityManager().find(Mission.class, id);
		return ms;
	}

	
	@SuppressWarnings("unchecked")
	public List<Mission> findAll() {
		
		return getEntityManager().createQuery("select m from "+ Mission.class.getSimpleName() +" m").getResultList();
	}

	
	public void flush() {
		
		getEntityManager().flush();
	}


	public List<Mission> updateList(){
		
		@SuppressWarnings("unchecked")
		List<Mission> miss = getEntityManager().createQuery("select m from "+ Mission.class.getSimpleName() +" m").getResultList();

		//1. on teste si l'état de la mission est crée
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String td = dateFormat.format(today);
		
		try {
			today = dateFormat.parse(td);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!miss.isEmpty()){
		
		for(Mission m : miss){
			if(m == null)
				continue;
			if(isCree(m)){
				
				// si l'etat de la mission est bien crée on teste si aujourd'hui est le jour de début de la mission
				if(today.equals(m.getDebut()) || today.after(m.getDebut())){
					m.setEtat(Etats.EN.toString());
					m = update(m);
						}
												}
			
			
			if(isEnCours(m)){
			  //2. on teste si l'etat de la mission est en cours
				if(rapportFinal(m.getIdMission())){
					// on teste si parmi les pièces jointes de la mission il y a la fiche ou le rapport final.
					m.setEtat(Etats.CL.toString());
					m = update(m);
													}	
							}
			
							}
		// on retourne la list des missions après modification
		return miss;
		}else{
			return miss;
		}
	}
	
	// méthode qui prend comme argument un Set<Typepj>, et qui retourne vrai ou faux
	//vrai si la liste contient le type Rapport final,faux sinon
	public boolean rapportFinal(int id){
		
		Query qr = getEntityManager().createQuery("select count(pj.idPj) from "+Mission.class.getSimpleName()+" m, "+Missionpj.class.getSimpleName()+" pj, "+Typepj.class.getSimpleName()
				+" t where m.idMission = pj.mission.idMission and t.idType = pj.typepj.idType and m.idMission = ? and t.type like '%Fiche final%'");
		qr.setParameter(1, id);
		
		Long nb = (Long) qr.getSingleResult();
		
		if(nb == 0){
			return false;
		}else{
			return true;
		}
		
	}
	
	
	public boolean isEnCours(Mission mission){
		if(mission != null){
			if(mission.getEtat() != null && mission.getEtat().equalsIgnoreCase(Etats.EN.toString()))
				return true;
		
		}
		return false;
	}
	
	public boolean isCree(Mission mission){
		if(mission != null){
			if(mission.getEtat() != null && mission.getEtat().equalsIgnoreCase(Etats.CR.toString()))
				return true;
		}
			return false;

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
	

}
