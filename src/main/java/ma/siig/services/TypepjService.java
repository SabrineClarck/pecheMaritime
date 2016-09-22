package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Typepj;

public interface TypepjService {

	public Typepj save (Typepj typepj);
	public Typepj update(Typepj typepj);
	public void delete(Typepj typepj);
	public Typepj findById(Integer id);
	public List<Typepj> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
	
}
