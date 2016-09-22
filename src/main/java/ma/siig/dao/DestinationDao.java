package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Destination;


public interface DestinationDao {

	public Destination save (Destination destination);
	public Destination update(Destination destination);
	public void delete(Destination destination);
	public Destination findById(Integer id);
	public List<Destination> findAll();
	public void flush();
	
}
