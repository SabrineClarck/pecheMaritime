package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Profil;

public interface ProfilDao {

	public Profil save (Profil profil);
	public Profil update(Profil profil);
	public void delete(Profil profil);
	public Profil findById(Integer id);
	public List<Profil> findAll();
	public void flush();
	
}
