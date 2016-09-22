package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Fonction;


public interface FonctionDao {

	public Fonction save (Fonction fonction);
	public Fonction update(Fonction fonction);
	public void delete(Fonction fonction);
	public Fonction findById(Integer id);
	public List<Fonction> findAll();
	public void flush();
	
}
