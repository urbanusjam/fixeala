package ar.com.urbanusjam.fixeala.dao;

import java.util.List;

import ar.com.urbanusjam.fixeala.model.IssueFollow;

public interface IssueFollowDAO {
	
	public void saveFollowing (IssueFollow following);
	
	public void deleteFollowing (IssueFollow following);
	
	public IssueFollow findFollowing (IssueFollow following);
	
	public List<IssueFollow> findFollowingsByIssue(Long issueID);
	
	public List<IssueFollow> findFollowingsByUser(Long userID);

}
