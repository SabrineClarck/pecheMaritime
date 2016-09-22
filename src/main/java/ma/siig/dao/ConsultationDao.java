package ma.siig.dao;

import java.util.List;

import ma.siig.domain.Consultation;


public interface ConsultationDao {

	
	public Consultation save (Consultation consultation);
	public Consultation update(Consultation consultation);
	public void delete(Consultation consultation);
	public Consultation findById(Integer id);
	public List<Consultation> findAll();
	public void flush();
	
	
}
