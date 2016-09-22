package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Entite;


public interface EntiteService {
	//public Entite save (Entite entite,Ville v);
	public Entite save(Entite entite);
	public Entite update(Entite entite);
	public void delete(Entite entite);
	public Entite findById(Integer id);
	public List<Entite> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
