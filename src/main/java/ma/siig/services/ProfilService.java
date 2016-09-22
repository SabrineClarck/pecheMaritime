package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.Profil;

public interface ProfilService {
	public Profil save (Profil profil);
	public Profil update(Profil profil);
	public void delete(Profil profil);
	public Profil findById(Integer id);
	public List<Profil> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
