package ma.siig.services;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import ma.siig.domain.User;

public interface UtilisateurService {

	public User save (User user);
	public User update(User user);
	public void delete(User user);
	public User findById(Integer id);
	public List<User> findAll();
	public void flush();
	public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
}
