package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Element;

public interface ElementDao {

	public Element save(Element element);
	public Element update(Element element);
	public void delete(Element element);
	public Element findById(Integer id);
	public List<Element> findAll();
	public void flush();
}
