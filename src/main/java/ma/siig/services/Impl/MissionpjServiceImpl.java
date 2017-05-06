package ma.siig.services.Impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import ma.siig.dao.MissionpjDao;
import ma.siig.domain.Document;
import ma.siig.domain.Mission;
import ma.siig.domain.Missionpj;
import ma.siig.domain.Soustypedoc;
import ma.siig.domain.Typepj;

import ma.siig.services.MissionpjService;

public class MissionpjServiceImpl implements MissionpjService {

	
	private MissionpjDao missionpjDao;
	private DocumentDao documentDao;
	private Missionpj selectedPiece;
	private UploadedFile file;
	private Missionpj missionpj = new Missionpj();
	private Typepj typepj = new Typepj();
	private Mission mission = new Mission();
	private  Soustypedoc ss = new Soustypedoc();
	
	
	/**
	 * @return the ss
	 */
	public Soustypedoc getSs() {
		return ss;
	}


	/**
	 * @param ss the ss to set
	 */
	public void setSs(Soustypedoc ss) {
		this.ss = ss;
	}


	/**
	 * @return the documentDao
	 */
	public DocumentDao getDocumentDao() {
		return documentDao;
	}


	/**
	 * @param documentDao the documentDao to set
	 */
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}
	
	
	public void setMission(Mission mission) {
		this.mission = mission;
	}


	public Mission getMission() {
		return mission;
	}


	public void setTypepj(Typepj typepj) {
		this.typepj = typepj;
	}


	public Typepj getTypepj() {
		return typepj;
	}

	public void setMissionpj(Missionpj missionpj) {
		this.missionpj = missionpj;
	}


	public Missionpj getMissionpj() {
		return missionpj;
	}


	public void setFile(UploadedFile file) {
		this.file = file;
	}


	public UploadedFile getFile() {
		return file;
	}


	public void setSelectedPiece(Missionpj selectedPiece) {
		this.selectedPiece = selectedPiece;
	}


	public Missionpj getSelectedPiece() {
		return selectedPiece;
	}


	public void setMissionpjDao(MissionpjDao missionpjDao) {
		this.missionpjDao = missionpjDao;
	}


	public MissionpjDao getMissionpjDao() {
		return missionpjDao;
	}


	public Missionpj save(Missionpj missionpj) {
		if(missionpj != null){
			 FacesMessage msg = new FacesMessage("Pièce jointe bien enregistrée");
				
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		return missionpjDao.save(missionpj);
	}

	
	public Missionpj update(Missionpj missionpj) {
		
		return missionpjDao.update(missionpj);
	}

	
	public void delete(Missionpj missionpj) {
			missionpjDao.delete(missionpj);
		
	}

	
	public Missionpj findById(Integer id) {
		
		return missionpjDao.findById(id);
	}

	
	public List<Missionpj> findAll() {
		
		return missionpjDao.findAll();
	}

	@Transactional
	public void upload() throws IOException{
	if(getFile()!= null){
	
		InputStream input = getFile().getInputstream();
		byte[] doc = IOUtils.toByteArray(input);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String td = dateFormat.format(today);
		 Document document = new Document();
		
		
		try {
			today = dateFormat.parse(td);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		missionpj.setDateAjout(today);
		document.setDoc(doc);
		document.setDateAjout(today);
		document.setTitre(missionpj.getTitre());
		document.setDescription(missionpj.getDescription());
		
		missionpj.setDocument(document);
		missionpj.setTypepj(getTypepj());
		missionpj.setMission(getMission());
		missionpjDao.save(missionpj);
		
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

	
	public void flush() {
			missionpjDao.flush();
		
	}
	
	 public void onRowEdit(RowEditEvent event) {
		 Missionpj vi = new Missionpj();
		 vi = (Missionpj) event.getObject();
		 	update(vi);
	        FacesMessage msg = new FacesMessage("Pièce jointe modifiée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Modification annulée");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

}
