package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.ElementDao;
import ma.siig.domain.Element;
import ma.siig.services.ElementService;

public class ElementServiceImpl implements ElementService {

	private ElementDao elementDao;
	
	public void setElementDao(ElementDao elementDao) {
		this.elementDao = elementDao;
	}


	public ElementDao getElementDao() {
		return elementDao;
	}


	public Element save(Element element) {
		if(elementDao.save(element) != null){
			FacesMessage msg = new FacesMessage("Elément bien enregistré");
	        FacesContext.getCurrentInstance().addMessage(null, msg);

		}
		
		return element;
	}

	
	public Element update(Element element) {
		
		return elementDao.update(element);
	}

	
	public void delete(Element element) {
		FacesMessage msg = new FacesMessage("Element supprimé ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		elementDao.delete(element);

	}

	
	public Element findById(Integer id) {
		
		return elementDao.findById(id);
	}

	
	public List<Element> findAll() {
		
		return elementDao.findAll();
	}

	
	public void flush() {
		elementDao.flush();

	}
	
	public void onRowEdit(RowEditEvent event) {
		Element en = new Element();
		en = (Element) event.getObject();
		update(en);
		FacesMessage msg = new FacesMessage("Element modifié ");
        FacesContext.getCurrentInstance().addMessage(null, msg);

	}


	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulée ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

}
