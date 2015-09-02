package ar.com.urbanusjam.fixeala.dao;

import java.util.List;
import java.util.Set;

import ar.com.urbanusjam.fixeala.dao.impl.utils.IssueCriteriaSearchRaw;
import ar.com.urbanusjam.fixeala.model.Issue;
import ar.com.urbanusjam.fixeala.model.Tag;


public interface IssueDAO {
	
	public void saveIssue(Issue issue);
	
	public void updateIssue(Issue issue);
	
	public List<Issue> getAllIssues();
	
	public List<Issue> getIssues(int numberOfResults);
	
	public List<Issue> getIssuesByLocation(float latitude, float longitude, int numberOfResults);
	
	public List<Issue> getIssuesByStatus(String[] status);
	
	public List<Issue> getIssuesByUser(String username);
	
	public List<Issue> getIssuesByCriteria(IssueCriteriaSearchRaw fields);
	
	public List<Issue> getIssuesByTag(String tag);
		
	public Issue findIssueById(String id);
	
	public Set<Tag> findIssueTagsById(String id);

}
