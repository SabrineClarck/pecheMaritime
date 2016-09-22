package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Soustypedoc;





public interface SoustypedocDao {

	public Soustypedoc save (Soustypedoc ss);
	public Soustypedoc update(Soustypedoc ss);
	public void delete(Soustypedoc ss);
	public Soustypedoc findById(Integer id);
	public List<Soustypedoc> findAll();
	public List<Soustypedoc> findArchives();
	public List<Soustypedoc> findSources();
	public List<Soustypedoc> findOthers();
	public void flush();
	
	
	
}
