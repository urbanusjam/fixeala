package ar.com.urbanusjam.fixeala.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ar.com.urbanusjam.fixeala.dao.IssueHistoryDAO;
import ar.com.urbanusjam.fixeala.model.IssueHistory;

@Repository
public class IssueHistoryDAOImpl implements IssueHistoryDAO {

	@PersistenceContext(unitName = "fixealaPU")
	private EntityManager entityManager; 
	
	public IssueHistoryDAOImpl() {}

	@Override
	public void saveHistorial(IssueHistory historial) {
		entityManager.persist(historial);		
	}
	
	

}
