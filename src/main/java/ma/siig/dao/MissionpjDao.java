package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Missionpj;



public interface MissionpjDao {

	public Missionpj save (Missionpj missionpj);
	public Missionpj update(Missionpj missionpj);
	public void delete(Missionpj missionpj);
	public Missionpj findById(Integer id);
	public List<Missionpj> findAll();
	public void flush();
	
	
}
