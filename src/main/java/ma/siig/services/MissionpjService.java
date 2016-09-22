package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Missionpj;

public interface MissionpjService {
	public Missionpj save (Missionpj missionpj);
	public Missionpj update(Missionpj missionpj);
	public void delete(Missionpj missionpj);
	public Missionpj findById(Integer id);
	public List<Missionpj> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
