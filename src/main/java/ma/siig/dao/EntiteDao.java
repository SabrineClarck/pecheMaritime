package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Entite;


public interface EntiteDao {

	
	public Entite save (Entite entite);
	public Entite update(Entite entite);
	public void delete(Entite entite);
	public Entite findById(Integer id);
	public List<Entite> findAll();
	public void flush();
	
	
}
