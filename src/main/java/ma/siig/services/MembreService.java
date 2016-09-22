package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Membreequipe;

public interface MembreService {

	public Membreequipe save (Membreequipe membre);
	public Membreequipe update(Membreequipe membre);
	public void delete(Membreequipe membre);
	public Membreequipe findById(Integer id);
	public List<Membreequipe> findAll();
	public void flush();
	
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
