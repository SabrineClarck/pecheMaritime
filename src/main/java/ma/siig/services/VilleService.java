package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Ville;

public interface VilleService {

	public Ville save (Ville ville);
	public Ville update(Ville ville);
	public void delete(Ville ville);
	public Ville findById(Integer id);
	public List<Ville> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
	 public Ville findByName(String name);
	
}
