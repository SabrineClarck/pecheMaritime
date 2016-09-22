package ma.siig.services;

import java.io.IOException;
import java.util.List;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.StreamedContent;

import ma.siig.domain.Document;

public interface DocumentService {

	public Document save (Document document);
	public Document update(Document document);
	public void delete(Document document);
	public Document findById(Integer id);
	public List<Document> findAll();
	public List<Document> findArchives();
	public List<Document> findSources();
	public List<Document> findOthers();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
	 public void upload()throws IOException;
	 public StreamedContent fileDownload(int id)throws IOException;
}
