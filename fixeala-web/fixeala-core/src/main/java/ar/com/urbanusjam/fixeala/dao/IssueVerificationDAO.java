package ar.com.urbanusjam.fixeala.dao;

import ar.com.urbanusjam.fixeala.model.IssueVerification;

public interface IssueVerificationDAO {
	
	public IssueVerification findVerificationByUser(Long issueID, Long userID);

}
