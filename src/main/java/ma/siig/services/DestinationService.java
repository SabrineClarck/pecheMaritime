package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Destination;

public interface DestinationService {

	public Destination save (Destination destination);
	public Destination update(Destination destination);
	public void delete(Destination destination);
	public Destination findById(Integer id);
	public List<Destination> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
