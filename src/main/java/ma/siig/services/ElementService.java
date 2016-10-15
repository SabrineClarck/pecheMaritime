package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Element;

public interface ElementService {

	public Element save(Element element);
	public Element update(Element element);
	public void delete(Element element);
	public Element findById(Integer id);
	public List<Element> findAll();
	public void flush();
	public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
	
}
