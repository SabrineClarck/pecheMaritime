package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Typedoc;

public interface TypedocService {


	public Typedoc save (Typedoc typedoc);
	public Typedoc update(Typedoc typedoc);
	public void delete(Typedoc typedoc);
	public Typedoc findById(Integer id);
	public List<Typedoc> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
