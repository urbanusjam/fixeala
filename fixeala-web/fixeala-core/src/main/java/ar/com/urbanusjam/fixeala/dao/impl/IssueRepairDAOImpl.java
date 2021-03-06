package ar.com.urbanusjam.fixeala.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ar.com.urbanusjam.fixeala.dao.IssueRepairDAO;
import ar.com.urbanusjam.fixeala.model.IssueRepair;

@Repository
public class IssueRepairDAOImpl implements IssueRepairDAO {
	
	@PersistenceContext(unitName = "fixealaPU")
	private EntityManager entityManager; 

	public IssueRepairDAOImpl() {}

	@Override
	public void deleteReparacion(Long issueID) {
		IssueRepair reparacion = entityManager.createQuery("SELECT r FROM IssueRepair r WHERE r.id = :issueID ", IssueRepair.class)
				   .setParameter("issueID", issueID)
			       .getSingleResult();	
		entityManager.remove(reparacion);
	}
	
}
