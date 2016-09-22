package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Module;


public interface ModuleDao {
	public Module save (Module module);
	public Module update(Module module);
	public void delete(Module module);
	public Module findById(Integer id);
	public List<Module> findAll();
	public void flush();
}
