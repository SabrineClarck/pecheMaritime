package ma.siig.commons.dao;
import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author SabrineMac
 * generic interface for dao access Objects. To be extended or implemented
 * contains common persistence methods.
 */

public interface GenericDao<T, ID extends Serializable> {

	/*
	 * we create GenericDao, so that it can be possible to apply
	 * it on any entity we have in the database,
	 *  the T parameter above, means accept any type of classe
	 *  then we'll add the common methods to access to the database
	 */
	
	
	T save (T entity);
	T update(T entity);
	void delete(T entity);
	T findById(ID id);
	List<T> findAll();
	void flush();
}
