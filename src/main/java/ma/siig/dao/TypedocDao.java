package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Typedoc;


public interface TypedocDao {

	
	public Typedoc save (Typedoc typedoc);
	public Typedoc update(Typedoc typedoc);
	public void delete(Typedoc typedoc);
	public Typedoc findById(Integer id);
	public List<Typedoc> findAll();
	public void flush();
}
