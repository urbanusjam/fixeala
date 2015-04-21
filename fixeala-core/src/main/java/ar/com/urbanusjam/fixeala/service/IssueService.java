package ar.com.urbanusjam.fixeala.service;

import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

import ar.com.urbanusjam.fixeala.model.Comment;
import ar.com.urbanusjam.fixeala.model.IssueFollow;
import ar.com.urbanusjam.fixeala.model.IssueRepair;
import ar.com.urbanusjam.fixeala.model.IssueVerification;
import ar.com.urbanusjam.fixeala.model.IssueVote;
import ar.com.urbanusjam.fixeala.service.dto.IssueCriteriaSearch;
import ar.com.urbanusjam.fixeala.service.dto.IssueDTO;

public interface IssueService {
	
	//issues
	public void reportIssue(IssueDTO issue);	
	public void updateIssue(IssueDTO issue) throws MessagingException, MailException;		
	public void updateIssueStatus(String username, String issueID, String newStatus, String resolution, String obs) throws MessagingException, MailException;	
	public IssueDTO getIssueById(String issueID);	
	public List<IssueDTO> loadAllIssues();	
	public List<IssueDTO> loadIssues(int numberOfResults);	
	public List<IssueDTO> loadIssuesByLocation(float latitude, float longitude, int numberOfResults);
	public List<IssueDTO> loadIssuesByStatus(String[] status);	
	public List<IssueDTO> loadIssuesByUser(String username);	
	public List<IssueDTO> findIssuesByCriteria(IssueCriteriaSearch search);
	public List<IssueDTO> searchByTagOrStatus(String searchType, String value);
		
	//comments
	public void postComment(Comment comment) throws MessagingException, MailException;		
	
	//repair
	public void addReparacion(IssueRepair repair, String username);
	public void deleteReparacion(String issueID, String username);
	
	//tags	
	public List<String> getTagList();
		
	//followers
	public void followIssue(IssueFollow follow);
	public void unFollowIssue(IssueFollow follow);
	public boolean isUserFollowingIssue(IssueFollow follow);
	public List<String> getIssueFollowers(String issueID);
	public List<String> getUserFollowings(String username);
	public String[] getFollowersEmails(Set<IssueFollow> followers, String reporterEmail);
	
	//votes
	public void submitVote(IssueVote vote);
	public IssueVote getCurrentVote(String issueID, String username);
	public Long countIssueVotes(String issueID);	
	
	//pageviews
//	public boolean trackIssuePageView(IssuePageView pageview);
	public int getIssuePageViews(String issueID);
	
	//provinces
	public List<String> loadProvinces();
	public List<String> loadLocalityByProvince(String province);
	
	public IssueVerification isIssueVerifiedByUser(String issueID, String username);
		
}
