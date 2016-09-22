package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Mission;

public interface MissionService {

	public Mission save (Mission mission);
	public Mission update(Mission mission);
	public void delete(Mission mission);
	public Mission findById(Integer id);
	public List<Mission> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
