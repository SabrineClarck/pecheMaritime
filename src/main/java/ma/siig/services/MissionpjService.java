package ma.siig.services;

import java.io.IOException;
import java.util.List;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.StreamedContent;

import ma.siig.domain.Missionpj;

public interface MissionpjService {
	public Missionpj save (Missionpj missionpj);
	public Missionpj update(Missionpj missionpj);
	public void delete(Missionpj missionpj);
	public Missionpj findById(Integer id);
	public List<Missionpj> findAll();
	public void flush();
	 public void onRowEdit(RowEditEvent event);
	 public void onRowCancel(RowEditEvent event);
	 public void upload()throws IOException;
	 public StreamedContent fileDownload(int id)throws IOException;
}
