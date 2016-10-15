package ma.siig.services.Impl;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



import org.apache.commons.io.IOUtils;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import org.springframework.transaction.annotation.Transactional;


import ma.siig.dao.DocumentDao;
import ma.siig.domain.Document;
import ma.siig.domain.Soustypedoc;
import ma.siig.services.DocumentService;
public class DocumentServiceImpl implements DocumentService {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DocumentDao documentDao;
	private UploadedFile file;
	private Document document = new Document();
	private Soustypedoc soustypedoc = new Soustypedoc();

	


	public void setFile(UploadedFile file) {
		this.file = file;
	}


	public UploadedFile getFile() {
		return file;
	}


	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}


	public DocumentDao getDocumentDao() {
		return documentDao;
	}

	public void setDocument(Document document) {
		this.document = document;
	}


	public Document getDocument() {
		return document;
	}


	public void setSoustypedoc(Soustypedoc soustypedoc) {
		this.soustypedoc = soustypedoc;
	}


	public Soustypedoc getSoustypedoc() {
		return soustypedoc;
	}


	
	


	public Document save(Document document) {
		/*	document.setDoc(getUploadedFile());
			FacesMessage msg = new FacesMessage("Document bien enregistré ", document.getTitre());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        */
			return documentDao.save(document);

	}

	
	public Document update(Document document) {
		
		return documentDao.update(document);
	}

	
	public void delete(Document document) {
		FacesMessage msg = new FacesMessage("Document supprimé ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		documentDao.delete(document);

	}

	
	public Document findById(Integer id) {
		
		return documentDao.findById(id);
	}

	
	public List<Document> findAll() {
		
		return documentDao.findAll();
	}

	
	public void flush() {
		documentDao.flush();

	}


	public void onRowEdit(RowEditEvent event) {
		Document en = new Document();
		en = (Document) event.getObject();
		update(en);
		FacesMessage msg = new FacesMessage("Document modifié ");
        FacesContext.getCurrentInstance().addMessage(null, msg);

	}


	
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulée ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
	
	/* public void handleFileUpload(FileUploadEvent event){
		
		try {
			InputStream input = event.getFile().getInputstream();
			byte[] doc =  IOUtils.toByteArray(input);
			setUploadedFile(doc);
			FacesMessage msg = new FacesMessage("File uploaded successfuly");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			FacesMessage msg = new FacesMessage("Error file upload ");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			e.printStackTrace();
		}
		
		
	
	
	
		
		FacesMessage msg = new FacesMessage("File uploaded successfuly "+ event.getFile().getFileName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	*/
	@Transactional
	public void upload() throws IOException{
	if(getFile()!= null){
	
		InputStream input = getFile().getInputstream();
		byte[] doc = IOUtils.toByteArray(input);
		document.setDoc(doc);
		document.setSoustypedoc(getSoustypedoc());
		documentDao.save(document);
		
		FacesMessage msg = new FacesMessage("Document bien enregistré ",getFile().getFileName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}else{
		FacesMessage msg = new FacesMessage("An error accured while uploading ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	}


	
	
	public StreamedContent fileDownload(int id) throws IOException {
		
		byte[] barr = documentDao.downloadDocument(id);
		InputStream is = new ByteArrayInputStream(barr);
		
		return new DefaultStreamedContent(is);
	}


	
	public List<Document> findArchives() {
		
		return documentDao.findArchives();
	}


	
	public List<Document> findSources() {
		
		return documentDao.findSources();
	}


	
	public List<Document> findOthers() {
		
		return documentDao.findOthers();
	}

	
}
