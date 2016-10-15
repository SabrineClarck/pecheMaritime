package ma.siig.services;

import java.util.List;
import java.util.Set;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Mission;
import ma.siig.domain.Missionpj;

public interface MissionService {

	public Mission save (Mission mission);
	public Mission update(Mission mission);
	public void delete(Mission mission);
	public Mission findById(Integer id);
	public List<Mission> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
	 public boolean isCree(Mission mission);
	 public boolean isEnCours(Mission mission);
	 public List<Mission> updateList();
	 public boolean rapportFinal(Set<Missionpj> types);
}
