package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Typemission;


public interface TypemissionDao {

	public Typemission save (Typemission typemission);
	public Typemission update(Typemission typemission);
	public void delete(Typemission typemission);
	public Typemission findById(Integer id);
	public List<Typemission> findAll();
	public void flush();
	
}
