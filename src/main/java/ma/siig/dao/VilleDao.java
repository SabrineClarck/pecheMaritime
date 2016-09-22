package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Ville;

public interface VilleDao {

	public Ville save (Ville ville);
	public Ville update(Ville ville);
	public void delete(Ville ville);
	public Ville findById(Integer id);
	public List<Ville> findAll();
	public void flush();
	public Ville findByName(String name);
	
}
