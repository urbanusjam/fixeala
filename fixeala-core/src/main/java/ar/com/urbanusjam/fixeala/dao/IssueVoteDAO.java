package ar.com.urbanusjam.fixeala.dao;

import java.util.List;

import ar.com.urbanusjam.fixeala.model.IssueVote;

public interface IssueVoteDAO {
	
	public void saveIssueVote(IssueVote vote);
	
	public IssueVote getVoteByUser(Long idIssue, Long userID);
	
	public List<IssueVote> getVotesByIssue(Long issueID);
	
	public Long getTotalVotesCount(Long issueID);

}
