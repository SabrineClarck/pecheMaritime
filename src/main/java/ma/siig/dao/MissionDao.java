package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Mission;


public interface MissionDao {

	public Mission save (Mission mission);
	public Mission update(Mission mission);
	public void delete(Mission mission);
	public Mission findById(Integer id);
	public List<Mission> findAll();
	public void flush();
	public List<Mission> updateList();
}
