package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Typepj;



public interface TypepjDao {

	public Typepj save (Typepj typepj);
	public Typepj update(Typepj typepj);
	public void delete(Typepj typepj);
	public Typepj findById(Integer id);
	public List<Typepj> findAll();
	public void flush();
	
	
}
