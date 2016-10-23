package ma.siig.services.Impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ma.siig.dao.SoustypedocDao;
import ma.siig.domain.Soustypedoc;
import ma.siig.services.SoustypedocService;

public class SoustypedocServiceImpl implements SoustypedocService {

	private SoustypedocDao soustypedocDao;
	
	public void setSoustypedocDao(SoustypedocDao soustypedocDao) {
		this.soustypedocDao = soustypedocDao;
	}

	public SoustypedocDao getSoustypedocDao() {
		return soustypedocDao;
	}

	
	public Soustypedoc save(Soustypedoc ss) {
		if(ss != null){
			 FacesMessage msg = new FacesMessage("Sous-type bien enregistré");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		return soustypedocDao.save(ss);
	}

	
	public Soustypedoc update(Soustypedoc ss) {
		
		return soustypedocDao.update(ss);
	}

	
	public void delete(Soustypedoc ss) {
		
		soustypedocDao.delete(ss);
	}

	
	public Soustypedoc findById(Integer id) {
		
		return soustypedocDao.findById(id);
	}

	
	public List<Soustypedoc> findAll() {
		
		return soustypedocDao.findAll();
	}

	
	public void flush() {
		soustypedocDao.flush();

	}

	 public void onRowEdit(RowEditEvent event) {
		 Soustypedoc vi = new Soustypedoc();
		 vi = (Soustypedoc) event.getObject();
		 	update(vi);
	        FacesMessage msg = new FacesMessage("Sous-type modifié");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Modification annulée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

		
		public List<Soustypedoc> findArchives() {
			
			return soustypedocDao.findArchives();
		}

		
		public List<Soustypedoc> findSources() {
			
			return soustypedocDao.findSources();
		}

		
		public List<Soustypedoc> findOthers() {
			
			return soustypedocDao.findOthers();
		}
	
}
