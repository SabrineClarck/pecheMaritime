package ma.siig.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import ma.siig.dao.DocumentDao;
import ma.siig.domain.Document;

@Transactional
public class DocumentDaoImpl implements DocumentDao {
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

	

	
	public Document save(Document document) {
		if(document == null){
		getEntityManager().persist(document);
		}else{
			getEntityManager().merge(document);
		}
		return document;
	}

	
	public Document update(Document document) {
		getEntityManager().merge(document);
		return document;
	}

	
	public void delete(Document document) {
		
		if(document.getClass().isAssignableFrom(document.getClass())){
			getEntityManager().remove(getEntityManager().getReference(document.getClass(), document.getIdDoc()));
		}else{
			document = getEntityManager().merge(document);
		getEntityManager().remove(document);
		
		}
	}

	
	public Document findById(Integer id) {
		Document doc = getEntityManager().find(Document.class, id);
		return doc;
	}

	
	@SuppressWarnings("unchecked")
	public List<Document> findAll() {
		
		return getEntityManager().createQuery("select d from "+ Document.class.getSimpleName() +" d").getResultList();
	}

	
	public void flush() {
		
		getEntityManager().flush();
	}


	public byte[] downloadDocument(Integer id) {
		
		Query qr = getEntityManager().createQuery("select d.doc from "+Document.class.getSimpleName()+" d where d.idDoc = ?");
		qr.setParameter(1, id);
		byte[] file = (byte[]) qr.getSingleResult();
		
		return file;
	}


	
	@SuppressWarnings("unchecked")
	public List<Document> findArchives() {
		Query qr =getEntityManager().createQuery("select d from "+Document.class.getSimpleName()+" d where d.soustypedoc.typedoc.libelle like '%Archives%'");
		
		return qr.getResultList();
	}


	
	@SuppressWarnings("unchecked")
	public List<Document> findSources() {
		Query qr =getEntityManager().createQuery("select d from "+Document.class.getSimpleName()+" d where d.soustypedoc.typedoc.libelle like '%Sources%'");
		
		return qr.getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Document> findOthers() {
		Query qr =getEntityManager().createQuery("select d from "+Document.class.getSimpleName()+" d where d.soustypedoc.typedoc.libelle not like '%Sources%' and d.soustypedoc.typedoc.libelle not like '%Archives%' and d.soustypedoc.typedoc.libelle not like '%Modèles de document%'");

		return qr.getResultList();
	}


	
	@SuppressWarnings("unchecked")
	public List<Document> findModeles() {
		Query qr =getEntityManager().createQuery("select d from "+Document.class.getSimpleName()+" d where d.soustypedoc.typedoc.libelle like '%Modèles de document%'");

		return qr.getResultList();
	}

}
