package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Document;


public interface DocumentDao {

	public Document save (Document document);
	public Document update(Document document);
	public void delete(Document document);
	public Document findById(Integer id);
	public List<Document> findAll();
	public List<Document> findArchives();
	public List<Document> findSources();
	public List<Document> findOthers();
	public void flush();
	public byte[] downloadDocument(Integer id);
	
}
