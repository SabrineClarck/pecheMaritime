package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Typemission;

public interface TypemissionService {

	public Typemission save (Typemission typemission);
	public Typemission update(Typemission typemission);
	public void delete(Typemission typemission);
	public Typemission findById(Integer id);
	public List<Typemission> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
