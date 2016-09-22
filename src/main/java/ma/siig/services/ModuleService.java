package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Module;

public interface ModuleService {

	public Module save (Module module);
	public Module update(Module module);
	public void delete(Module module);
	public Module findById(Integer id);
	public List<Module> findAll();
	public void flush();
	
	public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
