package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Membreequipe;



public interface MemebreEDao {

	public Membreequipe save (Membreequipe membre);
	public Membreequipe update(Membreequipe membre);
	public void delete(Membreequipe membre);
	public Membreequipe findById(Integer id);
	public List<Membreequipe> findAll();
	public void flush();
	
}
