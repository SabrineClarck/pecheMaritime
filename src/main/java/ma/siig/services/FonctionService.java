package ma.siig.services;

import java.util.List;


import ma.siig.domain.Fonction;

import org.primefaces.event.RowEditEvent;

public interface FonctionService {

	public Fonction save (Fonction fonction);
	public Fonction update(Fonction fonction);
	public void delete(Fonction fonction);
	public Fonction findById(Integer id);
	public List<Fonction> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
