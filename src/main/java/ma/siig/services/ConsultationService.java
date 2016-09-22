package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Consultation;

public interface ConsultationService {

	public Consultation save (Consultation consultation);
	public Consultation update(Consultation consultation);
	public void delete(Consultation consultation);
	public Consultation findById(Integer id);
	public List<Consultation> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
