package ma.siig.dao;

import java.util.List;

import ma.siig.domain.User;


public interface UtilisateurDao {

	public User save (User user);
	public User update(User user);
	public void delete(User user);
	public User findById(Integer id);
	public List<User> findAll();
	public void flush();
	
}
