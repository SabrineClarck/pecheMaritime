package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Soustypedoc;

public interface SoustypedocService {

	public Soustypedoc save (Soustypedoc ss);
	public Soustypedoc update(Soustypedoc ss);
	public void delete(Soustypedoc ss);
	public Soustypedoc findById(Integer id);
	public List<Soustypedoc> findAll();
	public List<Soustypedoc> findArchives();
	public List<Soustypedoc> findSources();
	public List<Soustypedoc> findOthers();
	public void flush();
	
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
